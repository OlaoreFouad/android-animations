package dev.foodie.androidanimations

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var fadeAnimator: Animator? = null
    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fade(view: View) {
        fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.fade)
        fadeAnimator?.apply {
            setTarget(target_image)
            addListener(this@MainActivity)
            start()
        }
    }

    fun scale(view: View) {
        scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator?.apply {
            setTarget(target_image)
            addListener(this@MainActivity)
            start()
        }
    }

    fun translate(view: View) {
        translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator?.apply {
            setTarget(target_image)
            addListener(this@MainActivity)
            start()
        }
    }

    fun rotate(view: View) {
        rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(target_image)
            addListener(this@MainActivity)
            start()
        }
    }

    override fun onAnimationRepeat(p0: Animator?) {
        Toast.makeText(this, "Animation repeated", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(p0: Animator?) {
        Toast.makeText(this, "Animation ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(p0: Animator?) {
        Toast.makeText(this, "Animation canceled", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationStart(p0: Animator?) {
        Toast.makeText(this, "Animation started!", Toast.LENGTH_SHORT).show()
    }

}
