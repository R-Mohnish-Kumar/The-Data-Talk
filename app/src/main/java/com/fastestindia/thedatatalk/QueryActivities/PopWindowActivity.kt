package com.fastestindia.thedatatalk.QueryActivities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.widget.EditText
import com.fastestindia.thedatatalk.SharedPrefaManager
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopWindowActivity : AppCompatActivity() {

    lateinit var sharedPrefaManager: SharedPrefaManager
    lateinit var replyButton: Button
    lateinit var replyField: EditText
    lateinit var questionTv: TextView
    lateinit var queryReplies: List<GetQueryReplies>
    lateinit var replyRecycler: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var getQueryReplies: GetQueryReplies
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_window)
        replyField = findViewById(R.id.jobReplyEditText)
        replyButton = findViewById(R.id.jobReplyButton)
        replyRecycler = findViewById(R.id.collabReplyRecyclerView)
        replyRecycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        replyRecycler.setLayoutManager(linearLayoutManager)
        questionTv = findViewById(R.id.jobQuestionTv)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * 1.0).toInt(), (height * .8).toInt())
        val bundle = intent.extras
        val title = bundle!!.getString("title")
        val pk = bundle.getString("pk").toString()
        questionTv.setText(title)

        replyButton.setOnClickListener {
            Log.e("Clicked", "Yes")
            val postQueryReply = com.fastestindia.thedatatalk.APIs.APIClient.queryAPI().postQueryReply(
                sharedPrefaManager.authorization.authorization,
                pk,
                replyField.getText().toString()
            )
            postQueryReply.enqueue(object : Callback<PostQueryReply?> {
                override fun onResponse(
                    call: Call<PostQueryReply?>,
                    response: Response<PostQueryReply?>
                ) {
                    Toast.makeText(this@PopWindowActivity, "replied", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostQueryReply?>, t: Throwable) {
                    Toast.makeText(this@PopWindowActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }

        val getQueryReply = com.fastestindia.thedatatalk.APIs.APIClient.queryAPI().getQueryReply(
            sharedPrefaManager.authorization.authorization, pk)
        getQueryReply.enqueue(object : Callback<List<GetQueryReplies>> {
            override fun onResponse(call: Call<List<GetQueryReplies>>, response: Response<List<GetQueryReplies>>) {
                Log.e("Data", response.headers().toString())
                Log.e("body", response.body().toString())
                queryReplies = response.body()!!
                replyRecycler.setAdapter(ReplyRecyclerAdapter(applicationContext, queryReplies))
            }

            override fun onFailure(call: Call<List<GetQueryReplies>>, t: Throwable) {
                Log.e("onFailure", t.message!!)
            }
        })
    }

}