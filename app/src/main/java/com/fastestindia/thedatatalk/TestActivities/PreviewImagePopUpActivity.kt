package com.fastestindia.thedatatalk.TestActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.os.StrictMode
import android.util.DisplayMetrics
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class PreviewImagePopUpActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_image_pop_up)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        imageView = findViewById(R.id.previewImageView)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * 1.0).toInt(), (height * .6).toInt())
        val intent = intent
        val imageUrl = intent.getStringExtra("image")
        imageView.setImageBitmap(getBitmapFromURL(imageUrl))
        Log.e("Image", imageUrl!!)
    }

    companion object {
        fun getBitmapFromURL(src: String?): Bitmap? {
            return try {
                val url = URL(src)
                val connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input = connection.inputStream
                val myBitmap = BitmapFactory.decodeStream(input)
                Log.e("Bitmap", "returned")
                myBitmap
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("Exception", e.message!!)
                null
            }
        }
    }
}