package com.geohuo.dongnao.seniorui.utils.glideUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.util.Util;

import java.io.ByteArrayOutputStream;

/**
 * Created by geo on 2016-11-8.
 */

public class GlideUtils {

    private static RequestManager glideRequest;

    /**
     *  加载图片
     * @param context context
     * @param imageView view
     * @param imageUrl 图片地址
     */
    public static void loadImage(Context context, ImageView imageView, String imageUrl) {
        if(TextUtils.isEmpty(imageUrl)) return;
        if(context== null) return;
        if(imageView== null) return;
        if(Util.isOnMainThread()) {
            Glide.with(context).load(imageUrl).centerCrop().crossFade().into(imageView);
        }

    }

    public static void loadImage(Context context, ImageView imageView, int imageUrl) {
        if(context== null) return;
        if(imageView== null) return;
        if(Util.isOnMainThread()) {
            Glide.with(context).load(imageUrl).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
        }

    }

    public static void loadLocalImage(Context context, ImageView imageView, int imageUrl) {
        if(context== null) return;
        if(imageView== null) return;
        if(Util.isOnMainThread()) {
            Glide.with(context).load(imageUrl).into(imageView);
        }

    }

    /**
     *  加载圆角图片
     * @param context  Contex
     * @param imageView VIEW
     * @param imageUrl URL
     */
    public static void loadCircleImage(Context context, ImageView imageView, String imageUrl) {
        if(TextUtils.isEmpty(imageUrl)) return;
        if(context== null) return;
        if(imageView== null) return;
        DrawableTypeRequest builder = (DrawableTypeRequest) Glide.with(context).load(imageUrl).dontAnimate();
        builder.transform(new CircleTransform(context));
        builder.into(imageView);
    }

    /**
     *  加载圆角图片
     * @param context  Contex
     * @param imageView VIEW
     * @param imageUrl URL
     */
    public static void loadCircleImageByLocal(Context context, ImageView imageView, int imageUrl) {
        if(context== null) return;
        if(imageView== null) return;
        DrawableTypeRequest builder = (DrawableTypeRequest) Glide.with(context).load(imageUrl).dontAnimate();
        builder.transform(new CircleTransform(context));
        builder.into(imageView);
    }
    /**
     *  加载圆角图片
     * @param context  Contex
     * @param imageView VIEW
     * @param image Bitmap
     */
    public static void loadCircleImageByLocalBitmap(Context context, ImageView imageView, Bitmap image) {
        if(context== null) return;
        if(imageView== null) return;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        DrawableTypeRequest builder = (DrawableTypeRequest) Glide.with(context).load(byteArray).dontAnimate();
        builder.transform(new CircleTransform(context));
        builder.into(imageView);
    }
}
