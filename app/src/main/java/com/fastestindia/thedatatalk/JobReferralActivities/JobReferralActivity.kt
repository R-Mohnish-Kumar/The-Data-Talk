package com.fastestindia.thedatatalk.JobReferralActivities

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
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class JobReferralActivity : AppCompatActivity() {
    var option = arrayOf("High", "Medium", "Low")
    lateinit var spinner: Spinner
    lateinit var searchCard: CardView
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar:ProgressBar
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var jobDetails: List<JobDataItem>
    var filterList:MutableList<JobDataItem> = mutableListOf()
    lateinit var getDetailsForSearch:List<JobDataItem>
    lateinit var searchContent: EditText
    lateinit var layoutAdd: LinearLayout
    lateinit var buttonSearch: ImageView
    lateinit var buttonAdd: ImageView
    lateinit var submitJobButton: Button
    lateinit var jobPosition: EditText
    lateinit var jobSkillsAndExperience: EditText
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_referral)
        spinner = findViewById(R.id.spinnerjob)
        progressBar=findViewById(R.id.progressBar)
        searchCard = findViewById(R.id.cardviewsearch)
        searchContent=findViewById(R.id.searchJob)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        layoutAdd = findViewById(R.id.LayoutAddJobReferral)
        buttonAdd = findViewById(R.id.btnadd)
        buttonSearch = findViewById(R.id.btnsearch)
        submitJobButton = findViewById(R.id.jobSubmitButton)
        jobPosition = findViewById(R.id.jobPositionRoleEditText)
        jobSkillsAndExperience = findViewById(R.id.jobSkillsAndExperienceEditText)
        recyclerView = findViewById(R.id.jobRecyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)
        spinner.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, option))
        buttonAdd.setOnClickListener(View.OnClickListener {
            if (layoutAdd.getVisibility() == View.GONE) {
                layoutAdd.setVisibility(View.VISIBLE)
                buttonAdd.setImageResource(R.drawable.ic_baseline_cancel_24)
                submitJobButton.setOnClickListener(View.OnClickListener {
                    val createNewQuery = com.fastestindia.thedatatalk.APIs.APIClient.jobAPI().createNewJob(
                        sharedPrefaManager!!.authorization.authorization,
                        jobPosition.text.toString(),
                        jobSkillsAndExperience.text.toString(),
                        spinner.selectedItem.toString()
                    )
                    createNewQuery.enqueue(object : Callback<CreateNewJob?> {
                        override fun onResponse(
                            call: Call<CreateNewJob?>,
                            response: Response<CreateNewJob?>
                        ) {
                            Toast.makeText(applicationContext, "Job Requested", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onFailure(call: Call<CreateNewJob?>, t: Throwable) {
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
                            recyclerView.adapter= RecyclerAdapterJob(applicationContext,jobDetails)
                        }else{
                            filter(s.toString())
                        }
                        recyclerView.adapter= RecyclerAdapterJob(applicationContext,jobDetails)
                    }

                })
            } else {
                searchCard.setVisibility(View.GONE)
                buttonSearch.setImageResource(R.drawable.ic_baseline_search_24)
            }
        })
        progressBar.visibility=View.VISIBLE
        val call = com.fastestindia.thedatatalk.APIs.APIClient.jobAPI().JobDetails
        call.enqueue(object : Callback<List<JobDataItem>> {
            override fun onResponse(
                call: Call<List<JobDataItem>>,
                response: Response<List<JobDataItem>>
            ) {
                if (response.isSuccessful) {
                    progressBar.visibility=View.INVISIBLE
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    jobDetails = response.body()!!
                    Log.e("onResponse", jobDetails.toString())
                    recyclerView.adapter = RecyclerAdapterJob(applicationContext, jobDetails)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<JobDataItem>>, t: Throwable) {
                progressBar.visibility=View.INVISIBLE
                Log.e("onFailure", t.message!!)
            }
        })
    }
    private fun filter(text: String) {
        val createNewBlog = com.fastestindia.thedatatalk.APIs.APIClient.jobAPI().searchJob(
            sharedPrefaManager!!.authorization.authorization,
            searchContent.text.toString())
        createNewBlog.enqueue(object : Callback<List<JobDataItem>?> {
            override fun onResponse(call: Call<List<JobDataItem>?>, response: Response<List<JobDataItem>?>) {
                if (response.isSuccessful) {
                    Log.e("Success", response.code().toString())
                    assert(response.body() != null)
                    getDetailsForSearch= response.body()!!
                    Log.e("onResponse",getDetailsForSearch.toString() )
                    for(searchList:JobDataItem in getDetailsForSearch){
                        if(searchList.fields?.query.equals(text)){
                            filterList.add(searchList)
                        }
                    }
                    recyclerView.adapter=RecyclerAdapterJob(applicationContext,filterList)
                } else {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<JobDataItem>?>, t: Throwable) {
                Log.e("onFailure: ",t.message.toString())
            }
        })

    }
}