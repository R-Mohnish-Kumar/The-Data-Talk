package com.fastestindia.thedatatalk.JobReferralActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JobPopWindowActivity : AppCompatActivity() {
    lateinit var sharedPrefaManager: SharedPrefaManager
    lateinit var replyButton: Button
    lateinit var replyField: EditText
    lateinit var questionTv: TextView
    lateinit var jobReplies: List<GetJobReplies>
    lateinit var replyRecycler: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_pop_window)

        replyField = findViewById(R.id.jobReplyEditText)
        replyButton = findViewById(R.id.jobReplyButton)
        replyRecycler = findViewById(R.id.jobReplyRecyclerView)
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
        val pk = bundle.getString("pk")
        questionTv.setText(title)
        val getJobReply = com.fastestindia.thedatatalk.APIs.APIClient.jobAPI().getJobReply(
            sharedPrefaManager!!.authorization.authorization.toString(), pk
        )
        getJobReply.enqueue(object : Callback<List<GetJobReplies>> {
            override fun onResponse(call: Call<List<GetJobReplies>>, response: Response<List<GetJobReplies>>) {
                Log.e("Data", response.headers().toString())
                Log.e("body", response.body().toString())
                jobReplies = response.body()!!
                replyRecycler.adapter = ReplyRecyclerAdapterJob(applicationContext, jobReplies)
            }

            override fun onFailure(call: Call<List<GetJobReplies>>, t: Throwable) {
                Log.e("onFailure", t.message!!)
            }
        })

        replyButton.setOnClickListener(View.OnClickListener {
            val postJobReply = com.fastestindia.thedatatalk.APIs.APIClient.jobAPI().postJobReply(
                sharedPrefaManager.authorization.authorization, pk, replyField.text.toString()
            )
            postJobReply.enqueue(object : Callback<PostJobReply> {
                override fun onResponse(
                    call: Call<PostJobReply>,
                    response: Response<PostJobReply>
                ) {
                    Toast.makeText(this@JobPopWindowActivity, "replied", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostJobReply>, t: Throwable) {
                    Toast.makeText(this@JobPopWindowActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        })
    }
}