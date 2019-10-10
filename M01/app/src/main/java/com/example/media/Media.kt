package com.example.media

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.play
import kotlinx.android.synthetic.main.media.*

class Media : AppCompatActivity() {

    lateinit var videoExoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.media)

        val URL = "https://r3---sn-n4v7sney.googlevideo.com/videoplayback?expire=1570498684&ei=G5SbXemmO5SDkwbW1ILIAg&ip=2605%3Aa601%3Aa91f%3A7d00%3A9c9f%3Ad92a%3A6f91%3A24e5&id=o-ABMCVg-ge-kMN-LIzMhUlnocMR-BvXKQbfCsDQZVWLPn&itag=43&source=youtube&requiressl=yes&mime=video%2Fwebm&gir=yes&clen=5607623&ratebypass=yes&dur=0.000&lmt=1541369937210372&fvip=3&fexp=23842630&c=WEB&txp=5411222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=ALgxI2wwRgIhAJwiPu2Kn1jv-fL3lVddaeMDY9adh2bjFWqCn6BP_yJCAiEAlRoGyQVCprR-FrgBVJekOHyNncnKwQWOQ2MRQdfHxZk%3D&redirect_counter=1&cm2rm=sn-bvvbax4pcxg-naje7s&req_id=f8957a01580aa3ee&cms_redirect=yes&mm=29&mn=sn-n4v7sney&ms=rdu&mt=1570477124&mv=m&mvi=2&pl=42&lsparams=mm,mn,ms,mv,mvi,pl&lsig=AHylml4wRQIhAIkGgPhzt2Tu-tBzTJ_rKIrUMQRhiBUcR1gvvzMgIlcmAiAf3nFZd3Ghycz21iD8aS6wkLXh5YXKgDLAURFIpozfRA=="

        val trackSelector = DefaultTrackSelector()
        val loadControl = DefaultLoadControl()
        val rendersFactory = DefaultRenderersFactory(this)
        videoExoPlayer = ExoPlayerFactory.newSimpleInstance(this, rendersFactory, trackSelector, loadControl)
        videoExoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING

        player.player = videoExoPlayer

        videoExoPlayer.prepare(createUrlMediaSource(URL))


    }

    fun createUrlMediaSource(url: String): MediaSource {
        val userAgent = Util.getUserAgent(this, getString(R.string.app_name))
        return ExtractorMediaSource.Factory(DefaultDataSourceFactory(this, userAgent))
            .setExtractorsFactory(DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(url))
    }

    override fun onStop() {
        super.onStop()
        videoExoPlayer.stop()
    }


}