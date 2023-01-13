package com.fastestindia.thedatatalk.CollabActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.SharedPrefaManager
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CollabActivity : AppCompatActivity() {
    lateinit var searchCard: CardView
    lateinit var layoutAdd: LinearLayout
    lateinit var buttonSearch: ImageView
    lateinit var buttonAdd: ImageView
    lateinit var progressBar:ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var collabDetails: List<CollabDataItem>
    var filterList:MutableList<CollabDataItem> = mutableListOf()
    lateinit var getDetailsForSearch:List<CollabDataItem>
    lateinit var searchCollab: CardView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var submitNewCollab: Button
    lateinit var searchContent: EditText
    lateinit var newCollabTitle: EditText
    lateinit var newCollabDescription: EditText
    lateinit var noOfParticipants: EditText
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collab)
        progressBar=findViewById(R.id.progressBar)
        searchCard = findViewById(R.id.cardviewsearch)
        searchContent=findViewById(R.id.searchCollab)
        layoutAdd = findViewById(R.id.LayoutAddJobReferral)
        buttonAdd = findViewById(R.id.btnadd)
        buttonSearch = findViewById(R.id.btnsearch)
        submitNewCollab = findViewById(R.id.submitNewCollabButton)
        newCollabTitle = findViewById(R.id.new_Collab_Title)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        newCollabDescription = findViewById(R.id.new_Collab_Description)
        noOfParticipants = findViewById(R.id.no_Of_Participants)
        recyclerView = findViewById(R.id.collabRecyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)
        buttonAdd.setOnClickListener(View.OnClickListener {
            if (layoutAdd.getVisibility() == View.GONE) {
                layoutAdd.setVisibility(View.VISIBLE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_cancel_24)
                submitNewCollab.setOnClickListener(View.OnClickListener {
                    val createNewCollab = com.fastestindia.thedatatalk.APIs.APIClient.collabAPI().createNewCollab(
                        sharedPrefaManager!!.authorization.authorization,
                        noOfParticipants.text.toString(),
                        newCollabTitle.text.toString(),newCollabDescription.text.toString()
                    )
                    createNewCollab.enqueue(object : Callback<CreateNewCollab?> {
                        override fun onResponse(
                            call: Call<CreateNewCollab?>,
                            response: Response<CreateNewCollab?>
                        ) {
                            Toast.makeText(applicationContext, "Collab Created", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onFailure(call: Call<CreateNewCollab?>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                        }
                    })
                })
            } else {
                layoutAdd.setVisibility(View.GONE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_add_24)
            }
        })
        buttonSearch.setOnClickListener(View.OnClickListener {
            if (searchCard.getVisibility() == View.GONE) {
                searchCard.setVisibility(View.VISIBLE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_search_24)
                searchContent.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int
                    ) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int
                    ) {
                    }

                    override fun afterTextChanged(s: Editable?) {
                        filterList.clear()
                        if(s.toString().toLowerCase(Locale.getDefault()).isEmpty()){
                            recyclerView.adapter= RecyclerAdapterCollab(applicationContext,collabDetails)
                        }else{
                            filter(s.toString())
                        }
                        recyclerView.adapter= RecyclerAdapterCollab(applicationContext,collabDetails)
                    }

                })
            } else {
                searchCard.setVisibility(View.GONE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_search_24)
            }
        })
        progressBar.visibility=View.VISIBLE
        val call = com.fastestindia.thedatatalk.APIs.APIClient.collabAPI().collabDetails
        call.enqueue(object : Callback<List<CollabDataItem>> {
            override fun onResponse(
                call: Call<List<CollabDataItem>>,
                response: Response<List<CollabDataItem>>
            ) {
                if (response.isSuccessful) {
                    progressBar.visibility=View.INVISIBLE
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    collabDetails = response.body()!!
                    Log.e("onResponse", collabDetails.toString())
                    recyclerView.setAdapter(RecyclerAdapterCollab(applicationContext, collabDetails))
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<CollabDataItem>>, t: Throwable) {
                progressBar.visibility=View.INVISIBLE
                Log.e("onFailure", t.message!!)
            }
        })
    }
    private fun filter(text: String) {
        val createNewBlog = com.fastestindia.thedatatalk.APIs.APIClient.collabAPI().searchCollab(
            sharedPrefaManager!!.authorization.authorization,
            searchContent.text.toString())
        createNewBlog.enqueue(object : Callback<List<CollabDataItem>?> {
            override fun onResponse(call: Call<List<CollabDataItem>?>, response: Response<List<CollabDataItem>?>) {
                if (response.isSuccessful) {
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    getDetailsForSearch= response.body()!!
                    Log.e("onResponse",getDetailsForSearch.toString() )
                    for(searchList:CollabDataItem in getDetailsForSearch){
                        if(searchList.fields?.title.equals(text)){
                            filterList.add(searchList)
                        }
                    }
                    recyclerView.adapter=RecyclerAdapterCollab(applicationContext,filterList)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<CollabDataItem>?>, t: Throwable) {
                Log.e("onFailure: ",t.message.toString())
            }
        })

    }
}