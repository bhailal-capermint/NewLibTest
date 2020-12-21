package com.gamesdk

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


@BindingAdapter("resourceId")
fun loadImage(imageView: ImageView, id: Int = 0) {
    imageView.setImageResource(id)
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: Any?) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@BindingAdapter("circleImageUrl")
fun loadCircleImage(imageView: ImageView, url: Any?) {
    Glide.with(imageView.context).load(url).circleCrop().into(imageView)
}

@BindingAdapter("cornerImageUrl")
fun loadCornerImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).transform(RoundedCorners(10)).into(imageView)
}
