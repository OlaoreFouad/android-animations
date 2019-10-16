package dev.foodie.androidanimations

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : AppCompatActivity() {

    lateinit var wifiAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        supportActionBar?.title = "Frame Animation"
    }

    override fun onStart() {
        super.onStart()
        animating_image.setBackgroundResource(R.drawable.wifi_animation)
        wifiAnimation = animating_image.background as AnimationDrawable
        wifiAnimation.start()
    }

    fun startStopAnimation(view: View) {
        if (wifiAnimation.isRunning) {
            wifiAnimation.stop()
        } else {
            wifiAnimation.start()
        }
    }
}
