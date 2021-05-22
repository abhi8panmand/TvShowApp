package com.gravity.tvshows.Detail.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.Detail.Adapter.TvShowCastAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowGenreAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowSeasonAdapter;
import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.Detail.Presenter.TvShowDetailPresenter;
import com.gravity.tvshows.Detail.ViewInterface.TvShowDetailViewInterface;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Adapter.TvShowAdapter;
import com.gravity.tvshows.Support.Adapter.ImageViewPagerAdapter;
import com.gravity.tvshows.Search.Model.MImage;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.Support.Fragment.ViewPagerFragment;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.ActivityTvShowDetailBinding;
import com.gravity.tvshows.databinding.ActivityTvShowDetailTrialBinding;

import java.util.ArrayList;
import java.util.List;

public class TvShowDetailActivity extends AppCompatActivity implements TvShowDetailViewInterface, Constant {

    private Activity activity;
    private MTvShow tvShow;
//    private ActivityTvShowDetailBinding binding;
    private ActivityTvShowDetailTrialBinding binding;
    private List<MDetailImage> imageList =  new ArrayList<>();
    private List<MShowCast>castList = new ArrayList<>();
    private List<MShowSeason> seasonList = new ArrayList<>();
    private int TvShowId;
    private float avgrating;
    private TvShowCastAdapter castAdapter;
    private TvShowGenreAdapter genreAdapter;
    private TvShowSeasonAdapter seasonAdapter;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private TvShowDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_tv_show_detail_trial);
//        binding = DataBindingUtil.setContentView(activity, R.layout.activity_tv_show_detail);

        getIntentData();
        setLayout();
    }


    private void setupViewPager(ViewPager viewPager, List<MDetailImage> imageList, String sku) {
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(getSupportFragmentManager());

        if (imageList != null) {
            for (MDetailImage mImage : imageList) {
                try {
//                    if (mImage.getType().equals("poster"))
                    if (mImage.getType().equals("background"))
                    {
                        // adding images to image view via viewpager fragments
                        adapter.addFrag(ViewPagerFragment.newInstance(mImage.getResolutions().getOriginal().getUrl(), sku), mImage.getResolutions().getOriginal().getUrl());
                    }
                }catch (NullPointerException e){

                }

            }
        }

        viewPager.setAdapter(adapter);
        Log.d(Utils.TAG_ABHI, "setupViewPager: "+viewPager.getAdapter().getCount());
        binding.dotsIndicator.setViewPager(viewPager);
    }

    private void setLayout() {

//        if (tvShow.getShow().getImage() != null && tvShow.getShow().getImage().getOriginal() != null) {
//
//            Glide.with(activity)
//                    .load(tvShow.getShow().getImage().getOriginal())
//                    .apply(new RequestOptions()
//                            .placeholder(R.mipmap.default_image)
//                            .error(R.mipmap.default_image))
//                    .into(binding.ivTvShow);
//        }else {
//
//            Glide.with(activity)
//                    .load(default_image)
//                    .apply(new RequestOptions()
//                            .placeholder(R.mipmap.default_image)
//                            .error(R.mipmap.default_image))
//                    .into(binding.ivTvShow);
//        }

//        binding.tvToolbarName.setText(tvShow.getShow().getName());
//        binding.tvShowName.setText(tvShow.getShow().getName());
        binding.collapseActionView.setTitle(tvShow.getShow().getName());

        if (tvShow.getShow().getSummary() != null)
            binding.showDescrption.setHtml(tvShow.getShow().getSummary());

        if (tvShow.getShow().getGenres() != null && tvShow.getShow().getGenres().size() != 0)
            setGenreRecyclerView();
        else
            binding.tvShowGenres.setVisibility(View.GONE);

        binding.tvAvgRating.setText("Avg. Rating : "+avgrating+"/10");
        binding.rbTvShowRating.setRating(avgrating);

        setCastRecyclerView();
        setSeasonRecyclerView();
    }

    private void setSeasonRecyclerView() {

        gridLayoutManager = new GridLayoutManager(activity, 3);
        binding.recyclerViewSeason.setLayoutManager(gridLayoutManager);
        binding.recyclerViewSeason.setHasFixedSize(true);
        binding.recyclerViewSeason.setItemAnimator(new DefaultItemAnimator());
        seasonAdapter = new TvShowSeasonAdapter(activity, seasonList);
        binding.recyclerViewSeason.setAdapter(seasonAdapter);

    }

    private void setGenreRecyclerView() {
        
        linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        binding.recyclerViewGenre.setLayoutManager(linearLayoutManager);
        binding.recyclerViewGenre.setHasFixedSize(true);
        binding.recyclerViewGenre.setItemAnimator(new DefaultItemAnimator());
        genreAdapter = new TvShowGenreAdapter(activity, tvShow.getShow().getGenres());
        binding.recyclerViewGenre.setAdapter(genreAdapter);
    }

    private void setCastRecyclerView() {

        linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        binding.recyclerViewCast.setLayoutManager(linearLayoutManager);
        binding.recyclerViewCast.setHasFixedSize(true);
        binding.recyclerViewCast.setItemAnimator(new DefaultItemAnimator());
        castAdapter = new TvShowCastAdapter(activity, castList);
        binding.recyclerViewCast.setAdapter(castAdapter);
    }

    private void getIntentData() {

        // To retrieve object in second Activity
//        tvShow.add(getIntent().getSerializableExtra("TvShowModel"));
        Utils.logthis(activity, ""+getIntent().getSerializableExtra("TvShowModel"));
        tvShow = (MTvShow) getIntent().getSerializableExtra("TvShowModel");

        TvShowId = tvShow.getShow().getId();
        avgrating = tvShow.getShow().getRating().getAverage();

        callApi();

    }

    private void callApi() {

        presenter = new TvShowDetailPresenter(activity, this);
        presenter.getImages(TvShowId);
        presenter.getCast(TvShowId);
        presenter.getSeason(TvShowId);
    }

    @Override
    public void onSucessfullyGetImage(List<MDetailImage> imageList) {
        if (imageList != null && imageList.size() != 0){
            this.imageList = imageList;

            // add images to product list view with watermark
            setupViewPager(binding.viewPager, imageList, imageList.get(0).getType());
        }
    }

    @Override
    public void onFailToGetImage(String errorMessage) {

    }

    @Override
    public void onSuccessfullyGetTvShowCast(List<MShowCast> cast) {

        if (cast != null && cast.size() != 0){
            this.castList.addAll(cast);
            castAdapter.notifyDataSetChanged();
        }else {
            binding.tvShowCast.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailedToGetTvShowCast(String errorMessage) {

    }

    @Override
    public void onSuccessfullyGetTvShowSeason(List<MShowSeason> seasons) {
        
        if (seasons != null && seasons.size() != 0){
            this.seasonList.addAll(seasons);
            seasonAdapter.notifyDataSetChanged();
        }else {
            binding.tvShowSeason.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailedToGetTvShowSeason(String errorMessage) {

    }


}
