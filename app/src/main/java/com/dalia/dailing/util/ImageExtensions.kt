package com.dalia.dailing.util

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.dalia.common.glide.GlideApp
import com.dalia.dailing.R
import com.example.common.utils.glide.SvgSoftwareLayerSetter


private lateinit var requestBuilder: RequestBuilder<PictureDrawable>


fun ImageView.setImage(url: String) {
    Glide.with(this.context)
        .load(url.ifEmpty { null })
        .error(R.mipmap.ic_launcher)
        .centerCrop()
        .transition(withCrossFade())
        .into(this)
}

fun ImageView.setSvgImage(url: String){
    requestBuilder = Glide.with(this)
        .`as`(PictureDrawable::class.java)
//        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .transition(withCrossFade())
        .listener(SvgSoftwareLayerSetter())

    val uri =
        Uri.parse(url)
    requestBuilder
        .load(uri)
        .into(this)
}

@BindingAdapter("crestUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    if (imageUrl.endsWith(".svg")) {
        GlideApp.with(view.context)
                .`as`(PictureDrawable::class.java)
                .error(R.mipmap.ic_launcher)
                .transition(withCrossFade())
                .listener(SvgSoftwareLayerSetter())
                .load(Uri.parse(imageUrl))
                .into(view)
    } else {
        GlideApp.with(view.context)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transition(withCrossFade())
                .into(view)
    }
}