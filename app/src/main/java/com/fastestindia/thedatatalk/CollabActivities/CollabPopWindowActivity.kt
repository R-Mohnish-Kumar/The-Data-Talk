package com.fastestindia.thedatatalk.CollabActivities

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
import com.fastestindia.thedatatalk.SharedPrefaManager
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollabPopWindowActivity : AppCompatActivity() {
    lateinit var sharedPrefaManager: SharedPrefaManager
    lateinit var replyButton: Button
    lateinit var replyField: EditText
    lateinit var questionTv: TextView
    lateinit var collabReplies: List<GetCollabReplies>
    lateinit var replyRecycler: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collab_pop_window)
        replyField = findViewById(R.id.collabReplyEditText)
        replyButton = findViewById(R.id.collabReplyButton)
        replyRecycler = findViewById(R.id.collabReplyRecyclerView)
        replyRecycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        replyRecycler.setLayoutManager(linearLayoutManager)
        questionTv = findViewById(R.id.collabQuestionTv)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * 1.0).toInt(), (height * .8).toInt())
        val bundle = intent.extras
        val title = bundle!!.getString("title")
        val pk = bundle.getString("pk")
        questionTv.text = title
        replyButton.setOnClickListener(View.OnClickListener {
            Log.e("Clicked", "Yes")
            val postCollabReply = com.fastestindia.thedatatalk.APIs.APIClient.collabAPI().postCollabReply(
                sharedPrefaManager.authorization.authorization,
                pk,
                replyField.getText().toString()
            )
            postCollabReply.enqueue(object : Callback<PostCollabReply?> {
                override fun onResponse(
                    call: Call<PostCollabReply?>,
                    response: Response<PostCollabReply?>
                ) {
                    Toast.makeText(this@CollabPopWindowActivity, "replied", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostCollabReply?>, t: Throwable) {
                    Toast.makeText(this@CollabPopWindowActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        })
            val getCollabReply = com.fastestindia.thedatatalk.APIs.APIClient.collabAPI().getCollabReply( sharedPrefaManager.authorization.authorization, pk)
        getCollabReply.enqueue(object : Callback<List<GetCollabReplies>> {
            override fun onResponse(call: Call<List<GetCollabReplies>>, response: Response<List<GetCollabReplies>>) {
                Log.e("Data", response.headers().toString())
                Log.e("body", response.body().toString())
                collabReplies = response.body()!!
                replyRecycler.adapter = ReplyRecyclerAdapterCollab(applicationContext, collabReplies)
            }

            override fun onFailure(call: Call<List<GetCollabReplies>>, t: Throwable) {
                Log.e("onFailure", t.message!!)
            }
        })
    }
}