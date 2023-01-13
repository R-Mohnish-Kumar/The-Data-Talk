package com.fastestindia.thedatatalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fastestindia.thedatatalk.APIs.LoginResponse
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.*
import com.fastestindia.thedatatalk.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPageActivity : AppCompatActivity() {
    lateinit var login_username: EditText
    lateinit var register: TextView
    lateinit var login_password: EditText
    lateinit var login: Button
    lateinit var forgotPassword:TextView
    lateinit var progressBar: ProgressBar
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        progressBar = findViewById(R.id.progressBar)
        forgotPassword=findViewById(R.id.forgotPasswordTextView)
        forgotPassword.setOnClickListener {
            val intent:Intent= Intent(applicationContext,WebViewActivity::class.java)
            intent.putExtra("url","http://thedatatalk.org/accounts/forgot-password/")
            startActivity(intent)
        }
        register = findViewById(R.id.passwordTextView)
        login_username = findViewById(R.id.editText1)
        login_password = findViewById(R.id.editText2)
        login = findViewById(R.id.Button)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        login.setOnClickListener(View.OnClickListener {
            if (login_username.getText().toString().equals("")) {
                login_username.setError("Enter the username/email")
                login_username.requestFocus()
                return@OnClickListener
            }
            if (login_password.getText().toString().equals("")) {
                login_password.setError("Enter the password")
                login_password.requestFocus()
                return@OnClickListener
            }
            if (login_password.length() < 6) {
                login_password.setError("Invalid password format")
                login_password.requestFocus()
                return@OnClickListener
            }
            progressBar.setVisibility(View.VISIBLE)
            val loginResponseCall = com.fastestindia.thedatatalk.APIs.APIClient.service
                .loginUser(login_username.getText().toString(), login_password.getText().toString())
            loginResponseCall.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse=response.body()
                    if (response.isSuccessful) {
                        if (loginResponse!!.status.equals("success")) {
                            Log.e("Authorization", loginResponse.authorization)
                            sharedPrefaManager!!.saveUser(loginResponse.user)
                            sharedPrefaManager!!.saveAuthorization(loginResponse.authorization)
                            progressBar.setVisibility(View.INVISIBLE)
                            Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginPageActivity, HomePage::class.java))
                            finish()
                        }
                    } else {
                        Toast.makeText(applicationContext,
                            "No such user found. Kindly register",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    progressBar.setVisibility(View.INVISIBLE)
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            })
        })
        register.setOnClickListener(View.OnClickListener {
            val intent:Intent= Intent(applicationContext,WebViewActivity::class.java)
            intent.putExtra("url","http://thedatatalk.org/#pricing")
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        if (sharedPrefaManager!!.isLoggedIn) {
            startActivity(Intent(this@LoginPageActivity, HomePage::class.java))
            finish()
        }
    }




}