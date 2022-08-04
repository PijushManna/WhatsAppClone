package animations

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.content.Intent
import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.transition.Transition
import animations.dissolve.Dissolve


fun AppCompatActivity.useBasicSceneTransition(mIntent: Intent, vararg viewsWithId:Pair<View,String>){
    val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
        this,  // Now we provide a list of Pair items which contain the view we can transitioning
        // from, and the name of the view it is transitioning to, in the launched activity
        *viewsWithId
    )
    startActivity(mIntent, activityOptions.toBundle());
}

/**
 * TransitionManager.beginDelayedTransition(card, dissolve)
 */
fun ImageView.dissolve(duration: Long = 500L,interpolator: TimeInterpolator = FAST_OUT_SLOW_IN): Transition {
   val dissolve =  Dissolve()
    dissolve.addTarget(this)
    dissolve.duration = duration
    dissolve.interpolator = interpolator
    return dissolve
}

/**
 * This is the animation we apply to each of the list items. It animates the alpha value from 1
 * to 0, then back to 1. The animation repeats infinitely until it is manually ended.
 */
fun View.getFadeAnimation(fadeDuration: Long, bindingAdapterPosition:Int): ObjectAnimator {
    return ObjectAnimator.ofFloat(this, View.ALPHA, 1f, 0f, 1f).apply {
        repeatCount = ObjectAnimator.INFINITE
        duration = fadeDuration
        // Reset the alpha on animation end.
        doOnEnd { this@getFadeAnimation.alpha = 1f }
        currentPlayTime = (SystemClock.elapsedRealtime() - bindingAdapterPosition * 30L) % fadeDuration
    }
}