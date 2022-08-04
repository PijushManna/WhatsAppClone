package utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

fun Context.toast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?){
    url?.let {
        Glide.with(context).load(it).into(this)
    }
}

@BindingAdapter("loadImageCircular")
fun ImageView.loadImageCircular(url: String?){
    url?.let {
        Glide.with(context)
            .load(it)
            .transform(CircleCrop())
            .into(this)
    }
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(resId: Int?){
    resId?.let { res->
        Glide.with(context)
            .load(res)
            .into(this)
    }
}