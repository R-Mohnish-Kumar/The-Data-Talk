package com.fastestindia.thedatatalk.ProfileActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fastestindia.thedatatalk.LoginPageActivity
import com.fastestindia.thedatatalk.UpdateForgotPassword
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileUpdateActivity : AppCompatActivity() {
    lateinit var updatePassword:Button
    lateinit var updateProfile: Button
    lateinit var firstName: EditText
    lateinit var lastName:EditText
    lateinit var designation: EditText
    lateinit var company:EditText
    lateinit var experience: EditText
    lateinit var college:EditText
    lateinit var stream: EditText
    lateinit var profileBrief: EditText
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_update)
        firstName=findViewById(R.id.Fname)
        lastName=findViewById(R.id.Lname)
        designation=findViewById(R.id.Designation)
        college=findViewById(R.id.College)
        experience=findViewById(R.id.Experience)
        company=findViewById(R.id.Company)
        stream=findViewById(R.id.Stream)
        profileBrief=findViewById(R.id.ProfileBrief)
        updateProfile=findViewById(R.id.Update)
        updatePassword=findViewById(R.id.UpdatePassword)
        sharedPrefaManager= SharedPrefaManager(applicationContext)

        if(sharedPrefaManager.user.firstname!="" && sharedPrefaManager.user.lastname!=""){
           firstName.hint=sharedPrefaManager.user.firstname
           lastName.hint=sharedPrefaManager.user.lastname
        }else{
            firstName.hint="First Name"
            lastName.hint="Last Name"
        }
        updateProfile.setOnClickListener {
            val update_profile = com.fastestindia.thedatatalk.APIs.APIClient.service.updateProfile(sharedPrefaManager.authorization.authorization,designation.text.toString(),
                company.text.toString(),experience.text.toString(),college.text.toString(),stream.text.toString(),profileBrief.text.toString(),firstName.text.toString(),lastName.text.toString())

            update_profile.enqueue(object : Callback<ProfileUpdate?> {
                override fun onResponse(call: Call<ProfileUpdate?>, response: Response<ProfileUpdate?>) {
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                    finish()
                }
                override fun onFailure(call: Call<ProfileUpdate?>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })

        }
        updatePassword.setOnClickListener {
            startActivity(Intent(applicationContext,UpdatePasswordPopWindowActivity::class.java))

        }




    }
}