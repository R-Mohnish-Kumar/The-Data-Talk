package com.fastestindia.thedatatalk.BlogActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class BlogActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var blogDetails: List<GetBlogDetails>
    var filterList:MutableList<GetBlogDetails> = mutableListOf()
    lateinit var getDetailsForSearch:List<GetBlogDetails>
    lateinit var progressBar:ProgressBar
    lateinit var layoutAdd: LinearLayout
    lateinit var layoutSearch: LinearLayout
    lateinit var buttonAdd: ImageView
    lateinit var buttonSearch: ImageView
    lateinit var newBlogTitle: EditText
    lateinit var searchContent: EditText
    lateinit var newBlogDescription: EditText
    lateinit var submitNewBlog: Button
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)
        submitNewBlog = findViewById(R.id.submitBlogButton)
        searchContent=findViewById(R.id.searchContentEt)
        newBlogTitle = findViewById(R.id.blogTitleEd)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        newBlogDescription = findViewById(R.id.blogDescriptionEd)

        progressBar=findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.blogRecyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        layoutAdd = findViewById(R.id.LayoutAddJobReferral)
        layoutSearch = findViewById(R.id.LayoutSearch)
        buttonAdd = findViewById(R.id.btnadd)
        buttonSearch = findViewById(R.id.btnsearch)

        buttonAdd.setOnClickListener(View.OnClickListener {
            if (layoutAdd.getVisibility() == View.GONE) {
                layoutAdd.setVisibility(View.VISIBLE)
                layoutSearch.setVisibility(View.GONE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_cancel_24)
                submitNewBlog.setOnClickListener(View.OnClickListener {
                    val createNewBlog = com.fastestindia.thedatatalk.APIs.APIClient.blogAPI().createNewCollab(
                        sharedPrefaManager!!.authorization.authorization,
                        newBlogTitle.text.toString(),
                        newBlogDescription.text.toString())
                    createNewBlog.enqueue(object : Callback<CreateNewBlog?> {
                        override fun onResponse(
                            call: Call<CreateNewBlog?>,
                            response: Response<CreateNewBlog?>
                        ) {
                            Toast.makeText(applicationContext, "Blog Created", Toast.LENGTH_SHORT).show()
                        }
                        override fun onFailure(call: Call<CreateNewBlog?>, t: Throwable) {
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
            if (layoutSearch.getVisibility() == View.GONE) {
                layoutSearch.setVisibility(View.VISIBLE)
                layoutAdd.setVisibility(View.GONE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_cancel_24)
                searchContent.addTextChangedListener(object : TextWatcher{
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int
                    ) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int
                    ) {
                    }

                    override fun afterTextChanged(s: Editable?) {
                        filterList.clear()
                        if(s.toString().toLowerCase(Locale.getDefault()).isEmpty()){
                            recyclerView.adapter=BlogRecyclerAdapter(applicationContext,blogDetails)
                        }else{
                            filter(s.toString())
                        }
                        recyclerView.adapter=BlogRecyclerAdapter(applicationContext,blogDetails)
                    }

                })
            } else {
                layoutSearch.setVisibility(View.GONE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_search_24)
            }
        })

        progressBar.visibility=View.VISIBLE
        val call = com.fastestindia.thedatatalk.APIs.APIClient.blogAPI().getBlogDetails
        call.enqueue(object : Callback<List<GetBlogDetails>> {
            override fun onResponse(call: Call<List<GetBlogDetails>>,response: Response<List<GetBlogDetails>>)
            {
                if (response.isSuccessful) {
                    progressBar.visibility=View.INVISIBLE
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    blogDetails = response.body()!!
                    Log.e("onResponse", blogDetails.toString())
                    recyclerView.adapter = BlogRecyclerAdapter(applicationContext, blogDetails)
                } else { Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show() }
            }
            override fun onFailure(call: Call<List<GetBlogDetails>>, t: Throwable) {
                progressBar.visibility=View.INVISIBLE
                Log.e("onFailure", t.message!!)
            }
        })
    }

    private fun filter(text: String) {
        val createNewBlog = com.fastestindia.thedatatalk.APIs.APIClient.blogAPI().searchBlog(
            sharedPrefaManager!!.authorization.authorization,
            searchContent.text.toString())
        createNewBlog.enqueue(object : Callback<List<GetBlogDetails>?> {
            override fun onResponse(call: Call<List<GetBlogDetails>?>, response: Response<List<GetBlogDetails>?>) {
                if (response.isSuccessful) {
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                      getDetailsForSearch= response.body()!!
                    Log.e("onResponse",getDetailsForSearch.toString() )
                    for(searchList:GetBlogDetails in getDetailsForSearch){
                        if(searchList.fields?.title.equals(text)){
                            filterList.add(searchList)
                        }
                    }
                    recyclerView.adapter=BlogRecyclerAdapter(applicationContext,filterList)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<GetBlogDetails>?>, t: Throwable) {
                Log.e("onFailure: ",t.message.toString())
            }
        })

    }
}
