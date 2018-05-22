package com.module.base.manager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by shibing on 18/5/22.
 */

public class GlideManager {

    public static void loadImage(Context context, String url, ImageView imageView) {
        loadImage(context, url, imageView, 0);
    }

    public static void loadImage(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment).load(url).into(imageView);
    }

    public static void loadImage(Fragment fragment, int resId, ImageView imageView) {
        Glide.with(fragment).load(resId).into(imageView);
    }

    public static void loadImage(Context context, String url, ImageView imageView, int placeHolder) {
        loadImage(context, url, imageView, placeHolder, 0);
    }

    public static void loadImage(Context context, String url, ImageView imageView, int placeHolder, int error) {
        GlideApp.with(context).load(url).placeholder(placeHolder).error(error).into(imageView);
    }
}
