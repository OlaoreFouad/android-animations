package dev.foodie.androidanimations

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var fadeAnimator: ObjectAnimator? = null
    private var rotateAnimator: ObjectAnimator? = null
    private var translateAnimator: ObjectAnimator? = null
    private var scaleAnimator: ObjectAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fade(view: View) {
        fadeAnimator = ObjectAnimator.ofFloat(target_image, "alpha", 0f, 1f)
        fadeAnimator?.apply {
            addListener(this@MainActivity)
            duration = 1500
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    fun scale(view: View) {
        scaleAnimator = ObjectAnimator.ofFloat(target_image, "scaleX", 1.0f, 2.0f)
        scaleAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun translate(view: View) {
        translateAnimator = ObjectAnimator.ofInt(target_image, "translationX", 0, 200)
        translateAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun rotate(view: View) {
        rotateAnimator = ObjectAnimator.ofFloat(target_image, "rotation", 0f, 180f)
        rotateAnimator?.apply {
            addListener(this@MainActivity)
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
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

    fun playFromXML(view: View) {
        val setAnimator = AnimatorInflater.loadAnimator(this, R.animator.set)
        setAnimator.apply {
            setTarget(target_image)
            start()
        }
    }

    fun playFromCode(view: View) {

        // Root set of the animator - it contains all other animations...
        val rootSet = AnimatorSet()

        val rotationAnimator = ObjectAnimator.ofFloat(
                target_image, "rotationY", 0f, 360f
        )
        rotationAnimator.apply {
            duration = 500
        }

        // The child animator set that contains two scale object animations
        val childSet = AnimatorSet()

        val scaleXAnimator = ObjectAnimator.ofFloat(
                target_image, "scaleX", 1.5f, 1.0f
        )

        scaleXAnimator.apply { duration = 500 }

        val scaleYAnimator = ObjectAnimator.ofFloat(
                target_image, "scaleY", 1.5f, 1.0f
        )

        scaleYAnimator.apply { duration = 500 }
        childSet.playTogether(scaleXAnimator, scaleYAnimator)

        rootSet.play(rotationAnimator).before(childSet).after(3000)
        rootSet.start()

    }

    fun viewPropertyAnimator(view: View) {
        val vpa = target_image.animate()

        vpa.apply {
            duration = 1000
            rotationX(360f)
            scaleX(1.5f)
            translationX(200f)
            scaleY(1.6f)
            start()
        }
    }

}
