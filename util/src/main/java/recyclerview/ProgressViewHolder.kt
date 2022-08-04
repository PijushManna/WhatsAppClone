package recyclerview

import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import animations.getFadeAnimation
import com.example.util.R
import utils.loadImage

class ProgressViewHolder(itemView: View, fadeDuration: Long) : BaseViewHolder(itemView){
    override fun bind(item: BaseModel) {

    }

    override fun from(parent: ViewGroup): BaseViewHolder {
        TODO("Not yet implemented")
    }

    /**
     * This is the animation we apply to each of the list items. It animates the alpha value from 1
     * to 0, then back to 1. The animation repeats infinitely until it is manually ended.
     */
    private val animation: ObjectAnimator = itemView.getFadeAnimation(fadeDuration,bindingAdapterPosition)

    fun showPlaceholder(imageView:List<ImageView>, textView: List<TextView>) {
        // Shift the timing of fade-in/out for each item by its adapter position. We use the
        // elapsed real time to make this independent from the timing of method call.
        animation.start()
        // Show the placeholder UI.
        imageView.forEach {
            it.loadImage(R.drawable.image_placeholder)
        }
        textView.forEach {
            it.text = null
            it.setBackgroundResource(R.drawable.text_placeholder)
        }
    }

    fun hidePlaceholder() {
        animation.end()
    }
}