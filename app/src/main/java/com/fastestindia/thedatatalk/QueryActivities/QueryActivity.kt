package com.fastestindia.thedatatalk.QueryActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.fastestindia.thedatatalk.SharedPrefaManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class QueryActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var queryDetails: List<GetQueryDetails>
    lateinit var getDetailsForSearch:List<GetQueryDetails>
    var filterList:MutableList<GetQueryDetails> = mutableListOf()
    lateinit var buttonAdd: ImageView
    lateinit var buttonSearch: ImageView
    lateinit var raiseQuery: CardView
    lateinit var searchQuery: CardView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var submitNewQuery: Button
    lateinit var searchContent: EditText
    lateinit var newQueryTitle: EditText
    lateinit var newQueryKeyword: EditText
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)
        buttonAdd = findViewById(R.id.btnadd)
        progressBar=findViewById(R.id.progressBar)
        searchContent=findViewById(R.id.searchQuery)
        submitNewQuery = findViewById(R.id.submitNewQueryButton)
        newQueryTitle = findViewById(R.id.newQueryEditText)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        newQueryKeyword = findViewById(R.id.newKeywordEditText)
        buttonSearch = findViewById(R.id.btnsearch)
        recyclerView = findViewById(R.id.recyclerView)
        raiseQuery = findViewById(R.id.cardviewnewquery)
        searchQuery = findViewById(R.id.cardviewsearch)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)
        buttonAdd.setOnClickListener(View.OnClickListener {
            if (raiseQuery.getVisibility() == View.GONE) {
                raiseQuery.setVisibility(View.VISIBLE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_cancel_24)
                submitNewQuery.setOnClickListener(View.OnClickListener {
                    val createNewQuery = com.fastestindia.thedatatalk.APIs.APIClient.queryAPI().createNewQuery(
                        sharedPrefaManager!!.authorization.authorization,
                        newQueryKeyword.getText().toString(),
                        newQueryTitle.getText().toString()
                    )
                    createNewQuery.enqueue(object : Callback<CreateNewQuery?> {
                        override fun onResponse(
                            call: Call<CreateNewQuery?>,
                            response: Response<CreateNewQuery?>
                        ) {
                            Toast.makeText(applicationContext, "Query Created", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onFailure(call: Call<CreateNewQuery?>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                        }
                    })
                })
            } else {
                raiseQuery.setVisibility(View.GONE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_add_24)
            }
        })
        buttonSearch.setOnClickListener(View.OnClickListener {
            if (searchQuery.getVisibility() == View.GONE) {
                searchQuery.setVisibility(View.VISIBLE)
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
                            recyclerView.adapter= RecyclerAdapter(applicationContext,queryDetails)
                        }else{
                            filter(s.toString())
                        }
                        recyclerView.adapter= RecyclerAdapter(applicationContext,queryDetails)
                    }

                })

            } else {
                searchQuery.setVisibility(View.GONE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_search_24)
            }
        })
        progressBar.visibility=View.VISIBLE
        val call = com.fastestindia.thedatatalk.APIs.APIClient.queryAPI().queryDetails
        call.enqueue(object : Callback<List<GetQueryDetails>> {
            override fun onResponse(
                call: Call<List<GetQueryDetails>>,
                response: Response<List<GetQueryDetails>>
            ) {
                if (response.isSuccessful) {
                    progressBar.visibility=View.INVISIBLE
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    queryDetails = response.body()!!
                    Log.e("onResponse", queryDetails.toString())
                    recyclerView.adapter = RecyclerAdapter(applicationContext, queryDetails)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<GetQueryDetails>>, t: Throwable) {
                progressBar.visibility=View.INVISIBLE
                Log.e("onFailure", t.message!!)
            }
        })
    }
    private fun filter(text: String) {
        val createNewBlog = com.fastestindia.thedatatalk.APIs.APIClient.queryAPI().searchQuery(
            sharedPrefaManager!!.authorization.authorization,
            searchContent.text.toString())
        createNewBlog.enqueue(object : Callback<List<GetQueryDetails>?> {
            override fun onResponse(call: Call<List<GetQueryDetails>?>, response: Response<List<GetQueryDetails>?>) {
                if (response.isSuccessful) {
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    getDetailsForSearch= response.body()!!
                    Log.e("onResponse",getDetailsForSearch.toString() )
                    for(searchList: GetQueryDetails in getDetailsForSearch){
                        if(searchList.fields?.title.equals(text)){
                            filterList.add(searchList)
                        }
                    }
                    recyclerView.adapter=RecyclerAdapter(applicationContext,filterList)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<GetQueryDetails>?>, t: Throwable) {
                Log.e("onFailure: ",t.message.toString())
            }
        })

    }
}