package com.fastestindia.thedatatalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Patterns
import android.view.View
import android.widget.*
import com.fastestindia.thedatatalk.APIs.RegisterResponse
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    lateinit var emailId: EditText
    lateinit var password: EditText
    lateinit var rePassword: EditText
    lateinit var register: Button
    lateinit var contact: EditText
    lateinit var couponcode: EditText
    lateinit var name: EditText
    lateinit var loginTextView: TextView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        progressBar = findViewById(R.id.progressBar)
        emailId = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
        register = findViewById(R.id.registerButton)
        rePassword = findViewById(R.id.editTextTextPassword2)
        loginTextView = findViewById(R.id.loginTextView)
        contact = findViewById(R.id.contactEditText)
        couponcode = findViewById(R.id.couponCodeEditText)
        name = findViewById(R.id.nameEditText)
        loginTextView.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@RegistrationActivity,
                    LoginPageActivity::class.java
                )
            )
        })
        register.setOnClickListener(View.OnClickListener {
            if (emailId.getText().toString().equals("")) {
                emailId.setError("Please enter email address")
                emailId.requestFocus()
                return@OnClickListener
            }
            if (contact.getText().toString().equals("")) {
                contact.setError("Please enter contact number")
                contact.requestFocus()
                return@OnClickListener
            }
            if (name.getText().toString().equals("")) {
                name.setError("Please enter username")
                name.requestFocus()
                return@OnClickListener
            }
            if (password.getText().toString().equals("")) {
                password.setError("Please enter password")
                password.requestFocus()
                return@OnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(emailId.getText().toString()).matches()) {
                emailId.setError("Invalid email address")
                emailId.requestFocus()
                return@OnClickListener
            }
            if (password.getText().toString().length < 6) {
                password.setError("Password should consist of minimum 6 characters")
                password.requestFocus()
                return@OnClickListener
            }
            if (rePassword.getText().toString() != password.getText().toString()) {
                rePassword.setError("Password not matching")
                rePassword.requestFocus()
                return@OnClickListener
            }
            progressBar.setVisibility(View.VISIBLE)
            val registerResponseCall = com.fastestindia.thedatatalk.APIs.APIClient
                .service
                .registerUser(
                    emailId.getText().toString(),
                    password.getText().toString(),
                    contact.getText().toString(),
                    name.getText().toString(),
                    couponcode.getText().toString()
                )
            registerResponseCall.enqueue(object : Callback<RegisterResponse?> {
                override fun onResponse(
                    call: Call<RegisterResponse?>,
                    response: Response<RegisterResponse?>
                ) {
                    if (response.isSuccessful) {
                        progressBar.setVisibility(View.INVISIBLE)
                        Toast.makeText(applicationContext, "Successfull", Toast.LENGTH_SHORT).show()
                        startActivity(
                            Intent(
                                this@RegistrationActivity,
                                LoginPageActivity::class.java
                            )
                        )
                        finish()
                    } else {
                        progressBar.setVisibility(View.INVISIBLE)
                        Toast.makeText(
                            applicationContext,
                            "Some error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse?>, t: Throwable) {
                    progressBar.setVisibility(View.INVISIBLE)
                    Toast.makeText(applicationContext, "Registration failed", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        })
    }

}