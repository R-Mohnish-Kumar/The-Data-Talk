package com.fastestindia.thedatatalk.ProfileActivities


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.fastestindia.thedatatalk.APIs.APIClient
import com.fastestindia.thedatatalk.APIs.LoginResponse
import com.fastestindia.thedatatalk.APIs.RefreshLoginResponse
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class ProfileActivity : AppCompatActivity() {
    lateinit var sharedPrefaManager: SharedPrefaManager
    lateinit var profileUsername: TextView
    lateinit var swipeRefresh: SwipeRefreshLayout
    lateinit var profileEmail: TextView
    lateinit var profileContact: TextView
    lateinit var profileDesignation: TextView
    lateinit var profileCollege: TextView
    lateinit var profileStream: TextView
    lateinit var profileCompany: TextView
    lateinit var profileExperience: TextView
    lateinit var profileBrief: TextView
    lateinit var userName: String
    lateinit var contact: String
    lateinit var email: String
    lateinit var designation: String
    lateinit var college: String
    lateinit var experience: String
    lateinit var stream: String
    lateinit var company: String
    lateinit var profile_brief: String
    lateinit var updateProfile: Button
    lateinit var membershipDetails: ImageButton
    lateinit var profileImage: ImageView
    private var selectedImageUri: Uri? = null
    lateinit var rootLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        profileImage=findViewById(R.id.profileImageUpload)
        profileUsername = findViewById(R.id.profileUsernameTextView)
        profileEmail = findViewById(R.id.emailTextView)
        swipeRefresh=findViewById(R.id.swipeRefreshLayoutProfile)
        profileContact = findViewById(R.id.contactTextView)
        updateProfile = findViewById(R.id.updateProfileButton)
        profileDesignation = findViewById(R.id.designationTextView)
        profileCollege = findViewById(R.id.collegeTextView)
        profileStream = findViewById(R.id.streamTextView)
        profileCompany = findViewById(R.id.companyTextView)
        profileExperience = findViewById(R.id.experienceTextView)
        profileBrief = findViewById(R.id.profileBriefTextView)
        sharedPrefaManager= SharedPrefaManager(applicationContext)
        rootLayout=findViewById(R.id.layout_root)
        membershipDetails = findViewById(R.id.membershipDetailsImageButton)

        profileImage.setOnClickListener{
            openImageChooser()
        }
        membershipDetails.setOnClickListener(View.OnClickListener {
            val popupMenu = PopupMenu(this@ProfileActivity, membershipDetails)
            popupMenu.menuInflater.inflate(R.menu.membership_details_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.membershipDetails -> {
                        startActivity(
                            Intent(
                                this@ProfileActivity,
                                MemberDetailsActivity::class.java
                            )
                        )
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        })
        updateProfile.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@ProfileActivity,
                    ProfileUpdateActivity::class.java
                )
            )
        })
        userName = sharedPrefaManager!!.user.firstname + " " + sharedPrefaManager!!.user.lastname
        if (userName!!.equals("")) {
            profileUsername.setText("")
        }
        profileUsername.setText(userName)
        contact = sharedPrefaManager!!.user.contact.toString()
        if (contact.equals("")) {
            profileContact.setText("")
        }
        profileContact.setText(contact)
        email = sharedPrefaManager!!.user.username.toString()
        if (email.equals("")) {
            profileEmail.setText("")
        }
        profileEmail.setText(email)
        designation = sharedPrefaManager!!.user.designation.toString()
        if (designation.equals("")) {
            profileDesignation.setText("")
        }
        profileDesignation.setText(designation)
        company = sharedPrefaManager!!.user.company.toString()
        if (company.equals("")) {
            profileCompany.setText("")
        }
        profileCompany.setText(company)
        experience = sharedPrefaManager!!.user.experience.toString()
        if (experience.equals("")) {
            profileExperience.setText("")
        }
        profileExperience.setText(experience)
        college = sharedPrefaManager!!.user.college.toString()
        if (college.equals("")) {
            profileCollege.setText("")
        }
        profileCollege.setText(college)
        stream = sharedPrefaManager!!.user.stream.toString()
        if (stream.equals("")) {
            profileStream.setText("")
        }
        profileStream.setText(stream)
        profile_brief = sharedPrefaManager!!.user.profile_brief.toString()
        if (profile_brief.equals("")) {
            profileBrief.setText("")
        }
        profileBrief.text= profile_brief

        swipeRefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                val call = APIClient.service.refreshDetails(sharedPrefaManager.authorization.authorization)
                call.enqueue(object : retrofit2.Callback<RefreshLoginResponse> {
                    override fun onResponse(call: Call<RefreshLoginResponse>, response: Response<RefreshLoginResponse>) {
                        if (response.isSuccessful) {
                            val refreshLoginResponse=response.body()
                            if (refreshLoginResponse != null) {
                                sharedPrefaManager.saveRefreshUser(refreshLoginResponse.user)
                                sharedPrefaManager.saveAuthorization(refreshLoginResponse.authorization)
                                Toast.makeText(applicationContext, "Refreshed", Toast.LENGTH_SHORT).show()
                            }
                            else{
                                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<RefreshLoginResponse>, t: Throwable) {
                        Log.e("onFailure", t.message!!)
                        Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                })
                swipeRefresh.isRefreshing=false
            }

        })
    }
    private fun openImageChooser() {
        Intent(Intent.ACTION_PICK).also {
            it.type = "image/*"
            val mimeTypes = arrayOf("image/jpeg", "image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startActivityForResult(it, REQUEST_CODE_PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_PICK_IMAGE -> {
                    selectedImageUri = data?.data
                    profileImage.setImageURI(selectedImageUri)

                    val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedImageUri!!, "r", null) ?: return
                    val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
                    val file = File(cacheDir, contentResolver.getFileName(selectedImageUri!!))
                    val outputStream = FileOutputStream(file)
                    inputStream.copyTo(outputStream)

                    val body = UploadRequestBody(file, "image")

                    val headers: MutableMap<String, String> = HashMap()
                    headers["Authorization"] = sharedPrefaManager.authorization.authorization

                    val call=APIClient.service.uploadProfileImage(headers,MultipartBody.Part.createFormData("image", file.name,body), RequestBody.create("multipart/form-data".toMediaTypeOrNull(), "json"))
                    call.enqueue(object : retrofit2.Callback<UpdateResponse> {
                        override fun onResponse(call: Call<UpdateResponse>, response: Response<UpdateResponse>)
                        {
                            response.body()?.let { rootLayout.snackbar(it.message)
                            }
                        }
                        override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                            rootLayout.snackbar(t.message!!)
                        }

                    })
                }
            }
        }
    }
    companion object {
        const val REQUEST_CODE_PICK_IMAGE = 101
    }
}