package com.example.media

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.isEnabled = false


        play.setOnClickListener {
            if(video_view.isPlaying){
                video_view.pause()
                play.text = "play"
            } else {
                video_view.start()
                play.text = "pause"
            }
        }

        seek_bar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2){
                    video_view.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    override fun onStart() {
        super.onStart()
        video_view.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.pokemon))

        video_view.setOnPreparedListener {
            play.isEnabled = true
            seek_bar.max = it.duration
        }


        val handler = Handler()
        this@MainActivity.runOnUiThread(object: Runnable{
            override fun run() {
                if (video_view != null){
                    val cp = video_view.currentPosition
                    seek_bar.progress = cp
                    println("cp: $cp")
                }
                handler.postDelayed(this, 1000)
            }

        })

    }



    override fun onStop() {
        super.onStop()
        video_view.pause()
        play.text = "play"

    }
}
