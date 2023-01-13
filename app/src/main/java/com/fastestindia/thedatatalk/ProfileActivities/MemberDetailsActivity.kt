package com.fastestindia.thedatatalk.ProfileActivities

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.fastestindia.thedatatalk.SharedPrefaManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.fastestindia.thedatatalk.APIs.APIClient
import com.fastestindia.thedatatalk.R
import com.razorpay.Checkout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class MemberDetailsActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var joining: TextView
    lateinit var end: TextView
    lateinit var status: TextView
    lateinit var inviteCode: TextView
    lateinit var ic_usage: TextView
    lateinit var sharedPrefaManager: SharedPrefaManager
    lateinit var joiningDate: String
    lateinit var endingDate: String
    lateinit var paybutton: Button
    lateinit var spinner: Spinner
    lateinit var buttonpaybynft: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_details)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        name = findViewById(R.id.memberNameTextView)
        joining = findViewById(R.id.memberStartTextView)
        end = findViewById(R.id.memberEndTextView)
        status = findViewById(R.id.memberStatusTextView)
        inviteCode = findViewById(R.id.memberInviteCodeTextView)
        ic_usage = findViewById(R.id.memberIcUsageTextView)
        joiningDate = sharedPrefaManager!!.user.start_date.toString()
        endingDate = sharedPrefaManager!!.user.end_date.toString()
        name.setText(sharedPrefaManager!!.user.firstname + " " + sharedPrefaManager!!.user.lastname)
        joining.setText(joiningDate.substring(0, 10))
        end.setText(endingDate.substring(0, 10))
        inviteCode.setText(sharedPrefaManager!!.user.invite_code)
        ic_usage.setText(sharedPrefaManager!!.user.ic_usage)
        status.setText("Active")
        paybutton= findViewById(R.id.paybutton)
        spinner = findViewById(R.id.spinner)
        buttonpaybynft= findViewById(R.id.buttonpaybynft)

        val options =
            arrayOf("Extend by", "Three Month (₹299)", "Six Month (₹499)", "One Year (₹999)")
        spinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MemberDetailsActivity, options.get(p2), Toast.LENGTH_SHORT).show()
                val x:Int
                if(options.get(p2).equals("Three Month (₹299)"))
                {
                    x=299
                    paybutton.setOnClickListener {
                        startPayment(x)

                    }}
                else if(options.get(p2).equals("Six Month (₹499)"))
                {
                    x=499
                    paybutton.setOnClickListener {
                        startPayment(x)

                    }}
                else if(options.get(p2).equals("One Year (₹999)"))
                {
                    x=999
                    paybutton.setOnClickListener {
                        startPayment(x)

                    }}


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MemberDetailsActivity, "Please choose a option", Toast.LENGTH_SHORT).show()
            }
        }
        buttonpaybynft.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://opensea.io/collection/thedatatalk"))
            startActivity(intent)
        }
    }
    fun startPayment(x:Int ) {

        val checkout = Checkout()
        checkout.setKeyID("rzp_live_a7S4EdKcCt2iXP")

        try {
            val options = JSONObject()
            options.put("name", "The Data Talk")
            options.put("description", "Membership Renewal")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://cdn.razorpay.com/logos/HKQNHERhBYCtFz_medium.png")
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "${(x.toInt() * 100)}")//pass amount in currency subunits

            if(x==299)
            {
                options.put("notes", "APK 3 months")
            }
            else if(x==499)
            {
                options.put("notes", "APK 6 months")
            }
            else if(x==999)
            {
                options.put("notes", "APK 1 Year")
            }


            val retryObj = JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            val prefill = JSONObject()
            prefill.put("email",sharedPrefaManager!!.user.username)
            prefill.put("contact",sharedPrefaManager!!.user.contact)

            options.put("prefill",prefill)
            checkout.open(this, options)
            onPaymentSuccess(x)
        } catch (e: Exception) {
            Toast.makeText(this, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }
    fun onPaymentSuccess(amount:Int) {
        var call= APIClient.service.paymentUpdate(sharedPrefaManager.authorization.authorization,amount.toString())
        call.enqueue( object : retrofit2.Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                //Toast.makeText(applicationContext,response.message(),Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, "Payment Successful for Rs."+amount, Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                //Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, "Payment Unsuccessful", Toast.LENGTH_SHORT).show()
            }

        })


    }

    fun onPaymentError(p0: Int, p1: String?) {
        Log.d(ContentValues.TAG, "onPaymentError: ${p0}")
        Log.d(ContentValues.TAG, "onPaymentError: ${p1}")

        Toast.makeText(this, "Payment Not Successful", Toast.LENGTH_SHORT).show()
    }
}