package com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnBufferingUpdateListener
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R

class MediaPlayerActivity() : AppCompatActivity() {
    lateinit var playPauseImage: ImageView
    lateinit var playerImageView: ImageView
    lateinit var playerTitleTextView: TextView
    lateinit var backButton: ImageButton
    lateinit var menuButton: ImageButton
    lateinit var playPause: CardView
    lateinit var forward: CardView
    lateinit var rewind: CardView
    lateinit var seekBar: SeekBar
    lateinit var title: String
    lateinit var audioURL: String
    lateinit var spotifyURL: String
    lateinit var googleURL: String
    lateinit var appleURL: String
    var handler = Handler()
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        playerImageView = findViewById(R.id.playerImageView)
        playerTitleTextView = findViewById(R.id.playerTitleImageView)
        mediaPlayer = MediaPlayer()

        //MediaPlayerAttributes
        val intent = intent
        title = intent.extras!!.getString("title").toString()
        audioURL = intent.extras!!.getString("audio").toString()
        spotifyURL = intent.extras!!.getString("spotify").toString()
        googleURL = intent.extras!!.getString("google").toString()
        appleURL = intent.extras!!.getString("apple").toString()
        playerTitleTextView.text=title
        //MediaPlayerImage
        val extras = getIntent().extras
        if (extras != null) {
            val id = extras.getInt("picture")
            playerImageView.setImageResource(id)
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        playPause = findViewById(R.id.playPauseCardView)
        forward = findViewById(R.id.forwardCardView)
        rewind = findViewById(R.id.rewindCardView)
        seekBar = findViewById(R.id.seekBar)
        backButton = findViewById(R.id.backImageButton)
        menuButton = findViewById(R.id.menuImageButton)
        backButton.setOnClickListener(View.OnClickListener { finish() })
        menuButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val popupMenu = PopupMenu(this@MediaPlayerActivity, menuButton)
                popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
                popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.one -> {
                            val spotify = Uri.parse(spotifyURL)
                            startActivity(Intent(Intent.ACTION_VIEW, spotify))
                            true
                        }
                        R.id.two -> {
                            val apple = Uri.parse(appleURL)
                            startActivity(Intent(Intent.ACTION_VIEW, apple))
                            true
                        }
                        R.id.three -> {
                            val google = Uri.parse(googleURL)
                            startActivity(Intent(Intent.ACTION_VIEW, google))
                            true
                        }
                        else -> false
                    }
                })
                popupMenu.show()
            }
        })
        playPauseImage = findViewById(R.id.playPauseButtonImageView)
        playPauseImage.setBackgroundResource(R.drawable.playbutton)
        playPause.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (mediaPlayer!!.isPlaying) {
                    handler.removeCallbacks(runnable)
                    mediaPlayer!!.pause()
                    playPauseImage.setBackgroundResource(R.drawable.playbutton)
                } else {
                    mediaPlayer!!.start()
                    playPauseImage.setBackgroundResource(R.drawable.pausebutton)
                    updateSeekbar()
                }
            }
        })
        prepareMediaPlayer()
        seekBar.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                val seekBar = v as SeekBar
                val playPosition = (mediaPlayer!!.duration / 100) * seekBar.progress
                mediaPlayer!!.seekTo(playPosition)
                return false
            }
        })
        mediaPlayer!!.setOnBufferingUpdateListener(object : OnBufferingUpdateListener {
            override fun onBufferingUpdate(mp: MediaPlayer, percent: Int) {
                seekBar.setSecondaryProgress(percent)
            }
        })

        forward.setOnClickListener {
            forwardSong()
        }

        rewind.setOnClickListener {
            rewindSong()
        }
    }

    private fun prepareMediaPlayer() {
        try {
            mediaPlayer!!.setDataSource(audioURL)
            mediaPlayer!!.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val runnable: Runnable = object : Runnable {
        override fun run() {
            updateSeekbar()
        }
    }

    private fun updateSeekbar() {
        if (mediaPlayer!!.isPlaying) {
            seekBar!!.progress = ((mediaPlayer!!.currentPosition
                .toFloat() / mediaPlayer!!.duration) * 100).toInt()
            handler.postDelayed(runnable, 1000)
        }
    }

    private val seekForwardTime = 5 * 1000
    private val seekBackwardTime = 5 * 1000
    fun forwardSong() {
        if (mediaPlayer != null) {
            val currentPosition: Int = mediaPlayer!!.getCurrentPosition()
            if (currentPosition + seekForwardTime <= mediaPlayer!!.getDuration()) {
                mediaPlayer!!.seekTo(currentPosition + seekForwardTime)
            } else {
                mediaPlayer!!.seekTo(mediaPlayer!!.getDuration())
            }
        }
    }
    fun rewindSong() {
        if (mediaPlayer != null) {
            val currentPosition: Int = mediaPlayer!!.getCurrentPosition()
            if (currentPosition - seekBackwardTime >= 0) {
                mediaPlayer!!.seekTo(currentPosition - seekBackwardTime)
            } else {
                mediaPlayer!!.seekTo(0)
            }
        }
    }


    companion object {
        var mediaPlayer: MediaPlayer? = null
    }
}