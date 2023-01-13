package com.fastestindia.thedatatalk.TestActivities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.util.*

class TestSessionActivity : AppCompatActivity() {
    lateinit var questionPallete: TextView
    lateinit var questionNumber: TextView
    lateinit var option1Text: TextView
    lateinit var option2Text: TextView
    lateinit var option3Text: TextView
    lateinit var option4Text: TextView
    lateinit var previewImage: ImageView
    lateinit var next: Button
    lateinit var option1: CardView
    lateinit var option2: CardView
    lateinit var option3: CardView
    lateinit var option4: CardView
    lateinit var close: ImageButton
    var questions = ArrayList<String>()
    var choices = ArrayList<String>()
    var correct = ArrayList<String>()
    var id = ArrayList<String>()
    var image = ArrayList<String>()
    lateinit var testQuestions: ArrayList<String>
    lateinit var course: String
    var pressCount = 0
    var questionNo = 1
    var score = 0
    var correctAns = 0
    var wrongAns = 0
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_session)
        score = 0
        correctAns = 0
        wrongAns = 0
        window.statusBarColor = R.color.peach_puff
        close = findViewById(R.id.closeTestImageButton)
        previewImage = findViewById(R.id.previewImageTextView)
        option1 = findViewById(R.id.option1CardView)
        option2 = findViewById(R.id.option2CardView)
        option3 = findViewById(R.id.option3CardView)
        option4 = findViewById(R.id.option4CardView)
        option1Text = findViewById(R.id.option1TextView)
        option2Text = findViewById(R.id.option2TextView)
        option3Text = findViewById(R.id.option3TextView)
        option4Text = findViewById(R.id.option4TextView)
        questionNumber = findViewById(R.id.questionNumberTextView)
        next = findViewById(R.id.nextButton)
        questionPallete = findViewById(R.id.questionTextView)
        close.setOnClickListener(View.OnClickListener { finish() })
        val intent = intent
        course = intent.getStringExtra("course").toString()
        try {
            json
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        next.setOnClickListener(View.OnClickListener { nextButtonFunction() })
    }

    @get:Throws(IOException::class, JSONException::class)
    private val json: Unit
        private get() {
            val json: String
            val inputStream = assets.open("mcq.json")
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            inputStream.close()
            val charset:Charset=Charset.forName("UTF-8")
            json = String(bytes, charset)
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                if (jsonObject.getString("topic") == course) {
                    questions.add(jsonObject.getString("question"))
                }
            }
            if (questions.size < 10) {
                questionNumber!!.text = "Question $questionNo"
            }
//            if (image.contains("null")) {
//                previewImage!!.visibility = View.GONE
//            } else {
//                previewImage!!.visibility = View.VISIBLE
//                previewImage.setImageBitmap(getBitmapFromURL(image[0]))
//            }
            questionPallete!!.text =
                getRandomElement(questions, 1).toString().replace("[", "").replace("]", "")
                    .trim { it <= ' ' }
            getOptionsAndAnswerKey(questionPallete!!.text.toString())
            val choicesAsText = choices.toString()
            val example = choicesAsText.replace("[\"", "").replace("[", "").replace("]", "")
                .replace("\"]", "").replace("\"", "").split(",").toTypedArray()
            if(example[0]==""){
                option1Text.text="null"
            }else{
                option1Text!!.text = example[0]
            }
            if(example[1]==""){
                option2Text.text="null"
            }else{
                option2Text!!.text = example[1]
            }
            if(example[2]==""){
                option3Text.text="null"
            }else{
                option3Text!!.text = example[2]
            }
            if(example[3]==""){
                option4Text.text="null"
            }else{
                option4Text!!.text = example[3]
            }
            option1!!.setOnClickListener {
                Log.e("Tag", option1!!.tag.toString())
                if(correct[0]=="null"){
                    option1!!.setCardBackgroundColor(getColor(R.color.red))
                    wrongAns++
                    option2!!.isEnabled = false
                    option3!!.isEnabled = false
                    option4!!.isEnabled = false
                }else{
                    if (correct[0].equals(option1!!.tag as String)) {
                        option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                        score++
                        correctAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    } else {
                        option1!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }
                }
            }
            option2!!.setOnClickListener {
                Log.e("Clicked", "Yes")
                if(correct[0]=="null"){
                    option2!!.setCardBackgroundColor(getColor(R.color.red))
                    wrongAns++
                    option1!!.isEnabled = false
                    option3!!.isEnabled = false
                    option4!!.isEnabled = false
                }else{
                    if (correct[0].equals(option2!!.tag as String)) {
                        option2!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                        score++
                        correctAns++
                        option1!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    } else {
                        option2!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option1!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }
                }
            }
            option3!!.setOnClickListener {
                Log.e("Clicked", "Yes")
                if(correct[0]=="null"){
                    option3!!.setCardBackgroundColor(getColor(R.color.red))
                    wrongAns++
                    option2!!.isEnabled = false
                    option1!!.isEnabled = false
                    option4!!.isEnabled = false
                }else{
                    if (correct[0].equals(option3!!.tag as String)) {
                        option3!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                        score++
                        correctAns++
                        option2!!.isEnabled = false
                        option1!!.isEnabled = false
                        option4!!.isEnabled = false
                    } else {
                        option3!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option1!!.isEnabled = false
                        option4!!.isEnabled = false
                    }
                }
            }
            option4!!.setOnClickListener {
                Log.e("Clicked", "Yes")
                if(correct[0]=="null"){
                    option4!!.setCardBackgroundColor(getColor(R.color.red))
                    wrongAns++
                    option2!!.isEnabled = false
                    option3!!.isEnabled = false
                    option1!!.isEnabled = false
                }else{
                    if (correct[0].equals(option4!!.tag as String)) {
                        option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                        score++
                        correctAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option1!!.isEnabled = false
                    } else {
                        option4!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option1!!.isEnabled = false
                    }
                }
            }
        }


    fun getRandomElement(list: ArrayList<String>, totalItems: Int): ArrayList<String> {
        val rand = Random()
        val newList = ArrayList<String>()
        for (i in 0 until totalItems) {
            val randomIndex = rand.nextInt(list.size)
            newList.add(list[randomIndex])
            list.removeAt(randomIndex)
        }
        return newList
    }

    @Throws(IOException::class, JSONException::class)
    fun getOptionsAndAnswerKey(question: String) {
        image.clear()
        choices.clear()
        correct.clear()
        val json: String
        var bmp:Bitmap
        val inputStream = assets.open("mcq.json")
        val size = inputStream.available()
        val bytes = ByteArray(size)
        inputStream.read(bytes)
        inputStream.close()
        val charset:Charset=Charset.forName("UTF-8")
        json = String(bytes, charset)
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.getString("question") == question) {
                choices.add(jsonObject.getString("choices"))
                correct.add(jsonObject.getString("correct"))
                image.add(jsonObject.getString("image"))
                if (!image.contains("null")) {
                    previewImage!!.visibility = View.VISIBLE
                    val imageUrl:String=image[0]
                    val `in` = URL(imageUrl).openStream()
                    bmp = BitmapFactory.decodeStream(`in`)
                    previewImage.setImageBitmap(bmp)
                } else {
                    previewImage!!.visibility = View.GONE
                }
                Log.e("ImageURL", image.size.toString())
            }
        }
    }

    fun nextButtonFunction() {
        option1!!.isEnabled = true
        option2!!.isEnabled = true
        option3!!.isEnabled = true
        option4!!.isEnabled = true
        option1!!.setCardBackgroundColor(getColor(R.color.white))
        option2!!.setCardBackgroundColor(getColor(R.color.white))
        option3!!.setCardBackgroundColor(getColor(R.color.white))
        option4!!.setCardBackgroundColor(getColor(R.color.white))
        Log.e("Press Count: ", pressCount.toString())
        if (questions.size > 10) {
            pressCount++
            questionNo++
            questionNumber!!.text = "Question $questionNo"
            if (pressCount == 10) {
                next!!.isEnabled = false
                val intent = Intent(applicationContext, ScoreCardActivity::class.java)
                intent.putExtra("total", score.toString())
                intent.putExtra("correct", correctAns.toString())
                intent.putExtra("wrong", wrongAns.toString())
                startActivity(intent)
                finish()
            }
            questionPallete!!.text =
                getRandomElement(questions, 1).toString().replace("[", "").replace("]", "")
                    .trim { it <= ' ' }
            try {
                getOptionsAndAnswerKey(questionPallete!!.text.toString())
                val choicesAsText = choices.toString()
                val example = choicesAsText.replace("[\"", "").replace("[", "").replace("]", "")
                    .replace("\"]", "").replace("\"", "").split(",").toTypedArray()
                if(example[0].isEmpty()){
                    option1Text.text="null"
                }else{
                    option1Text!!.text = example[0]
                }
                if(example[1].isEmpty()){
                    option2Text.text="null"
                }else{
                    option2Text!!.text = example[1]
                }
                if(example[2].isEmpty()){
                    option3Text.text="null"
                }else{
                    option3Text!!.text = example[2]
                }
                if(example[3].isEmpty()){
                    option4Text.text="null"
                }else{
                    option4Text!!.text = example[3]
                }
                option1!!.setOnClickListener {
                    Log.e("Tag", option1!!.tag.toString())
                    if(correct[0]=="null"){
                        option1!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option1!!.tag as String)) {
                            option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option1!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }
                }
                option2!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option2!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option1!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option2!!.tag as String)) {
                            option2!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option1!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option2!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option1!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }
                }
                option3!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option3!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option1!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option3!!.tag as String)) {
                            option3!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option1!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option3!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option1!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }
                }
                option4!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option4!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option1!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option4!!.tag as String)) {
                            option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option1!!.isEnabled = false
                        } else {
                            option4!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option1!!.isEnabled = false
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            pressCount++
            questionNo++
            questionNumber!!.text = "Question $questionNo"
            if (pressCount == questions.size + 1) {
                next!!.isEnabled = false
                val intent = Intent(applicationContext, ScoreCardActivity::class.java)
                intent.putExtra("total", score.toString())
                intent.putExtra("correct", correctAns.toString())
                intent.putExtra("wrong", wrongAns.toString())
                startActivity(intent)
                finish()
            }
            questionPallete!!.text =
                getRandomElement(questions, 1).toString().replace("[", "").replace("]", "")
                    .trim { it <= ' ' }
            try {
                getOptionsAndAnswerKey(questionPallete!!.text.toString())
                val choicesAsText = choices.toString()
                val example = choicesAsText.replace("[\"", "").replace("[", "").replace("]", "")
                    .replace("\"]", "").replace("\"", "").split(",").toTypedArray()
                if(example[0].isEmpty()){
                    option1Text.text="null"
                }else{
                    option1Text!!.text = example[0]
                }
                if(example[1].isEmpty()){
                    option2Text.text="null"
                }else{
                    option2Text!!.text = example[1]
                }
                if(example[2].isEmpty()){
                    option3Text.text="null"
                }else{
                    option3Text!!.text = example[2]
                }
                if(example[3].isEmpty()){
                    option4Text.text="null"
                }else{
                    option4Text!!.text = example[3]
                }
                option1!!.setOnClickListener {
                    Log.e("Tag", option1!!.tag.toString())
                    if(correct[0]=="null"){
                        option1!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option1!!.tag as String)) {
                            option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option1!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }

                }
                option2!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option2!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option1!!.isEnabled = false
                        option3!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option2!!.tag as String)) {
                            option2!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option1!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option2!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option1!!.isEnabled = false
                            option3!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }
                }
                option3!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option3!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option1!!.isEnabled = false
                        option4!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option3!!.tag as String)) {
                            option3!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option1!!.isEnabled = false
                            option4!!.isEnabled = false
                        } else {
                            option3!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option1!!.isEnabled = false
                            option4!!.isEnabled = false
                        }
                    }
                }
                option4!!.setOnClickListener {
                    Log.e("Clicked", "Yes")
                    if(correct[0]=="null"){
                        option4!!.setCardBackgroundColor(getColor(R.color.red))
                        wrongAns++
                        option2!!.isEnabled = false
                        option3!!.isEnabled = false
                        option1!!.isEnabled = false
                    }else{
                        if (correct[0].equals(option4!!.tag as String)) {
                            option1!!.setCardBackgroundColor(getColor(R.color.flouroscent_green))
                            score++
                            correctAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option1!!.isEnabled = false
                        } else {
                            option4!!.setCardBackgroundColor(getColor(R.color.red))
                            wrongAns++
                            option2!!.isEnabled = false
                            option3!!.isEnabled = false
                            option1!!.isEnabled = false
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getBitmapFromURL(src: String?): Bitmap? {
        return try {
            val url = URL(src)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            val myBitmap = BitmapFactory.decodeStream(input)
            Log.e("Bitmap", "returned")
            myBitmap
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("Exception", e.message!!)
            null
        }
    }

}

