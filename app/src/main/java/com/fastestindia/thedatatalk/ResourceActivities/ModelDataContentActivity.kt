package com.fastestindia.thedatatalk.ResourceActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import org.json.JSONArray
import java.nio.charset.Charset

class ModelDataContentActivity : AppCompatActivity() {
    lateinit var modelLinearLayoutManager: LinearLayoutManager
    lateinit var modelRecyclerView: RecyclerView
    lateinit var backButton: ImageButton
    lateinit var modelNameTv:TextView

    var namesArray=ArrayList<String>()
    var notebookLinkArray=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_data_content)
        modelNameTv=findViewById(R.id.modelNameTv)
        backButton=findViewById(R.id.backImageButton)
        backButton.setOnClickListener{
            finish()
        }
        modelRecyclerView=findViewById(R.id.modelContentRecyclerView)
        modelRecyclerView.setHasFixedSize(true)
        modelLinearLayoutManager = LinearLayoutManager(this)
        modelRecyclerView.layoutManager = modelLinearLayoutManager

        val modelName=intent.getStringExtra("Model")
        modelNameTv.text=modelName

        val json: String
        val inputStream = assets.open("models.json")
        val size = inputStream.available()
        val bytes = ByteArray(size)
        inputStream.read(bytes)
        inputStream.close()
        val charset: Charset = Charset.forName("UTF-8")
        json = String(bytes, charset)
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.getString("Model") == modelName) {
                namesArray.add(jsonObject.getString("Name"))
                notebookLinkArray.add(jsonObject.getString("Notebook link"))
            }

        }
        modelRecyclerView.adapter=ModelRecyclerAdapter(applicationContext,namesArray,notebookLinkArray)

    }
}