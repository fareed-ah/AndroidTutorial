package com.mobile.android.myalbum.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
