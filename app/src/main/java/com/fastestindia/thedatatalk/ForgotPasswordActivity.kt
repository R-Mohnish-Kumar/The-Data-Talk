package com.fastestindia.thedatatalk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var username:EditText
    lateinit var otp:EditText
    lateinit var getOTP:Button
    lateinit var updatePassword:Button
    lateinit var password:EditText
    lateinit var reEnterPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        password=findViewById(R.id.newPasswordEditText)
        reEnterPassword=findViewById(R.id.reEnterPasswordEditText)
        username=findViewById(R.id.forgotPasswordUsernameEditText)
        otp=findViewById(R.id.otpEditText)
        getOTP=findViewById(R.id.getOTPButton)
        updatePassword=findViewById(R.id.verifyOTPButton)
        getOTP.setOnClickListener {
            if (username.getText().toString().equals("")) {
                username.setError("Enter the username/email")
                username.requestFocus()
                return@setOnClickListener
            }
            val forgotPassword = com.fastestindia.thedatatalk.APIs.APIClient.service.forgotPassword(
                username.text.toString())
            forgotPassword.enqueue(object : Callback<ForgotPasswordDetails?> {
                override fun onResponse(call: Call<ForgotPasswordDetails?>, response: Response<ForgotPasswordDetails?>) {
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
                }
                override fun onFailure(call: Call<ForgotPasswordDetails?>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
        updatePassword.setOnClickListener {
            if (username.getText().toString().equals("")) {
                username.setError("Enter the username/email")
                username.requestFocus()
                return@setOnClickListener
            }
            if (otp.getText().toString().equals("")) {
                otp.setError("Enter the otp")
                otp.requestFocus()
                return@setOnClickListener
            }
            if (password.getText().toString().equals("")) {
                password.setError("Enter the password")
                password.requestFocus()
                return@setOnClickListener
            }
            if (password.length() < 6) {
                password.setError("Invalid password format")
                password.requestFocus()
                return@setOnClickListener
            }
            if (reEnterPassword.getText().toString() != password.getText().toString()) {
                reEnterPassword.setError("Password not matching")
                reEnterPassword.requestFocus()
                return@setOnClickListener
            }

            val forgotPassword = com.fastestindia.thedatatalk.APIs.APIClient.service.updateForgotPassword(
                username.text.toString(),
            otp.text.toString(),
            password.text.toString())
            forgotPassword.enqueue(object : Callback<UpdateForgotPassword?> {
                override fun onResponse(call: Call<UpdateForgotPassword?>, response: Response<UpdateForgotPassword?>) {
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,LoginPageActivity::class.java))
                    finish()
                }
                override fun onFailure(call: Call<UpdateForgotPassword?>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}