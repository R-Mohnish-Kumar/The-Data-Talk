package com.fastestindia.thedatatalk.ProfileActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fastestindia.thedatatalk.APIs.APIClient
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.SharedPrefaManager
import retrofit2.Call
import retrofit2.Response

class UpdatePasswordPopWindowActivity : AppCompatActivity() {
    lateinit var newPassword: EditText
    lateinit var reEnterNewPassword: EditText
    lateinit var newPasswordButton: Button
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password_pop_wiindow)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * 1.0).toInt(), (height * .5).toInt())
        newPassword=findViewById(R.id.updatePasswordEditText)
        sharedPrefaManager= SharedPrefaManager(applicationContext)
        reEnterNewPassword=findViewById(R.id.reEnterUpdatePasswordEditText)
        newPasswordButton=findViewById(R.id.updatePasswordButton)

        newPasswordButton.setOnClickListener {
            if (newPassword.text.toString() == "") {
                newPassword.error = "Please enter password"
                newPassword.requestFocus()
                return@setOnClickListener
            }
            if (reEnterNewPassword.text.toString() != newPassword.text.toString()) {
                reEnterNewPassword.error = "Password not matching"
                reEnterNewPassword.requestFocus()
                return@setOnClickListener
            }

            var call=APIClient.service.updatePassword(sharedPrefaManager.authorization.authorization,newPassword.text.toString())
            call.enqueue(object:retrofit2.Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(applicationContext,"Password Updated",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,ProfileActivity::class.java))
                    finish()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,ProfileActivity::class.java))
                    finish()
                }

            })

        }




    }
}