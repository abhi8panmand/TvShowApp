package com.gravity.tvshows.Support.Transform;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Support.Utils;

import java.security.MessageDigest;

import jp.wasabeef.glide.transformations.BitmapTransformation;

/**
 * Created by oded on 9/15/15.
 * Watermark Transformation for the Picasso image loading library (https://github.com/square/picasso).
 * The transformation will add the text you provide in the constructor to the image.
 * This was created to be implemented in http://wheredatapp.com, android's greatest search engine.
 */
public class waterTransformation extends BitmapTransformation {

    private String waterMark;
    private static final int PADDING = 20;
    private Context context;

    public waterTransformation(Context context, String waterMark){
        this.waterMark = waterMark;
        this.context = context;
    }

    /*
    private String waterMark;

    public WatermarkTransformation(String waterMark) {
        this.waterMark = waterMark;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        //choose the color of the text based on the color contents of the image
        Palette palette = Palette.generate(source);

        Bitmap workingBitmap = Bitmap.createBitmap(source);
        Bitmap mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(mutableBitmap);

        Paint paint2 = new Paint();
        paint2.setColor(palette.getVibrantColor(0xdd03a9f4));
        paint2.setTextSize(24);
        paint2.setTextAlign(Paint.Align.RIGHT);
        paint2.setAntiAlias(true);
        Rect textBounds = new Rect();
        paint2.getTextBounds(waterMark, 0, waterMark.length(), textBounds);
        int x = source.getWidth() - PADDING;
        int y = source.getHeight() - PADDING;


        canvas.drawText(waterMark, x, y, paint2);
        source.recycle();

        return mutableBitmap;
    }


     */

    @Override
    protected Bitmap transform(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {


        Bitmap workingBitmap = Bitmap.createBitmap(toTransform);
        Bitmap mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(mutableBitmap);

        // calculating
        if (waterMark != null && waterMark.length() > 0) {

            Paint paint2 = new Paint();
            paint2.setColor(context.getResources().getColor(R.color.white));
            paint2.setTextSize(140);
            paint2.setTextAlign(Paint.Align.RIGHT);
            paint2.setShadowLayer(10f, 10f, 10f, context.getResources().getColor(R.color.black));
            paint2.setAntiAlias(true);
            paint2.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            paint2.setAlpha(210);
            Rect textBounds = new Rect();
            paint2.getTextBounds(waterMark, 0, waterMark.length(), textBounds);

            int x = outWidth - PADDING;
            //int y = outHeight + outHeight;
            int y = outHeight + (int) (outHeight * 1.2);

            Log.d(Utils.TAG_ABHI, "transform: outHeight = " + outHeight);

            canvas.drawText(waterMark, x, y, paint2);
            // toTransform.recycle();

        }
        return mutableBitmap;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}