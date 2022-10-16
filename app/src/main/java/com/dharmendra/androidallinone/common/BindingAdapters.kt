package com.dharmendra.androidallinone.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dharmendra.androidallinone.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}