package com.gravity.tvshows.Support.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Support.Transform.waterTransformation;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.FragmentViewPagerBinding;
import com.watermark.androidwm_light.bean.WatermarkText;

public class ViewPagerFragment extends Fragment {

    private FragmentViewPagerBinding binding;
    private Context mContext;
    private String mImageUrl;
    private String SKU = "Tv Show";
    private WatermarkText watermarkText;
    private Bundle bundle;
    //  private Bitmap bit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        bundle = this.getArguments();
        if (bundle != null) {
            mImageUrl = bundle.getString("imageUrl");
            SKU = bundle.getString("SKU");
        }
        Log.d(Utils.TAG_ABHI, "ViewPagerFragment onCreate: sku = "+SKU);

    }


    public static Fragment newInstance(String imageUrl, String sku) {

        Bundle args = new Bundle();
        args.putSerializable("imageUrl", imageUrl);
        args.putSerializable("SKU", sku);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
        initializeView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false);
        View view = binding.getRoot();
        mContext = getActivity();
        return view;
    }

    private void initializeView() {

        // adding image to imageview with watermark
        MultiTransformation<Bitmap> multiTransformation = new MultiTransformation<>(new waterTransformation(mContext, SKU),new FitCenter()
        );
        Glide.with(mContext)
                .load(mImageUrl)
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                // .apply(RequestOptions.bitmapTransform(new waterTransformation(mContext,SKU)))
                .into(binding.ivImage);


        /*
        Glide.with(Objects.requireNonNull(getActivity()))
                .asBitmap()
                .load(mImageUrl)
                .into(new BitmapImageViewTarget(binding.ivImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //Play with bitmap
                        bit = resource;
                        super.setResource(resource);
                    }
                });


        FutureTarget<Bitmap> futureTarget =
                Glide.with(mContext)
                        .asBitmap()
                        .load(mImageUrl)
                        .submit(200, 200);

       bit = futureTarget.get();

        Log.d(Utils.TAG_Abhi, "initializeView: bit.getByteCount() ="+bit.getByteCount());

        WatermarkBuilder
                .create(mContext,bit)
                .loadWatermarkText(watermarkText)  // use .loadWatermarkImage(watermarkImage) to load an image.
                .getWatermark()
                .setToImageView(binding.ivImage);

         */


    }

}
