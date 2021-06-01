package com.gravity.tvshows.Detail.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.Detail.Adapter.TvShowCastAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowCrewAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowGenreAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowSeasonAdapter;
import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.Detail.Model.MShowCrew;
import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.Detail.Model.MTvShowAKAS;
import com.gravity.tvshows.Detail.Presenter.TvShowDetailPresenter;
import com.gravity.tvshows.Detail.ViewInterface.TvShowDetailViewInterface;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Activity.MainActivity;
import com.gravity.tvshows.Search.Adapter.TvShowAdapter;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Support.Adapter.ImageViewPagerAdapter;
import com.gravity.tvshows.Search.Model.MImage;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.Support.Fragment.ViewPagerFragment;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.ActivityTvShowDetailBinding;
import com.gravity.tvshows.databinding.ActivityTvShowDetailTrialBinding;
import com.lopei.collageview.CollageView;
//import com.sagrishin.collageview.CollageItemUrlData;
//import com.sagrishin.collageview.CollageItemView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.val;

public class TvShowDetailActivity extends AppCompatActivity implements TvShowDetailViewInterface,
        Constant, CollageView.IconSelector, TvShowSeasonAdapter.CallBack {

    private Activity activity;
    private MShow tvShow;
//    private ActivityTvShowDetailBinding binding;
    private ActivityTvShowDetailTrialBinding binding;
    private List<MDetailImage> imageList =  new ArrayList<>();
    private List<MShowCast>castList = new ArrayList<>();
    private List<MShowSeason> seasonList = new ArrayList<>();
    private List<MShowCrew> showCrewList = new ArrayList<>();
    private List<String> Urls = new ArrayList<>();
    private int TvShowId;
    private float avgrating;
    private TvShowCastAdapter castAdapter;
    private TvShowGenreAdapter genreAdapter;
    private TvShowSeasonAdapter seasonAdapter;
    private TvShowCrewAdapter crewAdapter;
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
        binding.collapseActionView.setTitle(tvShow.getName());

        if (tvShow.getSummary() != null)
            binding.showDescrption.setHtml(tvShow.getSummary());

        if (tvShow.getGenres() != null && tvShow.getGenres().size() != 0)
            setGenreRecyclerView();
        else
            binding.tvShowGenres.setVisibility(View.GONE);

        binding.tvAvgRating.setText("Avg. Rating : "+avgrating+"/10");
        binding.rbTvShowRating.setRating(avgrating);

        setSeasonRecyclerView();
        setCastRecyclerView();
//        setCrewRecyclerView();
    }

    private void setSeasonRecyclerView() {

        gridLayoutManager = new GridLayoutManager(activity, 3);
        binding.recyclerViewSeason.setLayoutManager(gridLayoutManager);
        binding.recyclerViewSeason.setHasFixedSize(true);
        binding.recyclerViewSeason.setItemAnimator(new DefaultItemAnimator());
        seasonAdapter = new TvShowSeasonAdapter(activity, seasonList, this);
        binding.recyclerViewSeason.setAdapter(seasonAdapter);

    }

    private void setCrewRecyclerView() {

        gridLayoutManager = new GridLayoutManager(activity, 2);
        binding.recyclerViewCrew.setLayoutManager(gridLayoutManager);
        binding.recyclerViewCrew.setHasFixedSize(true);
        binding.recyclerViewCrew.setItemAnimator(new DefaultItemAnimator());
        crewAdapter = new TvShowCrewAdapter(activity, showCrewList);
        binding.recyclerViewCrew.setAdapter(crewAdapter);

    }

    private void setGenreRecyclerView() {
        
        linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        binding.recyclerViewGenre.setLayoutManager(linearLayoutManager);
        binding.recyclerViewGenre.setHasFixedSize(true);
        binding.recyclerViewGenre.setItemAnimator(new DefaultItemAnimator());
        genreAdapter = new TvShowGenreAdapter(activity, tvShow.getGenres());
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
        tvShow = (MShow) getIntent().getSerializableExtra("TvShowModel");

        TvShowId = tvShow.getId();
        avgrating = tvShow.getRating().getAverage();

        callApi();

    }

    private void callApi() {

        presenter = new TvShowDetailPresenter(activity, this);
        presenter.getImages(TvShowId);
        presenter.getCast(TvShowId);
        presenter.getSeason(TvShowId);
        presenter.getCrew(TvShowId);
    }

    @Override
    public void onSucessfullyGetImage(List<MDetailImage> imageList) {
        if (imageList != null && imageList.size() != 0){
            this.imageList = imageList;

            // add images to product list view with watermark
            setupViewPager(binding.viewPager, imageList, imageList.get(0).getType());

/*

            binding.collageViewId.itemPreviewLoader = GlideItemPreviewLoaderImpl.Builder(activity).build();
*/
//            val images = photos.map { singlePhoto ->
//                CollageItemUrlData(singlePhoto.url).apply {
//                    this.width = singlePhoto.width
//                    this.height = singlePhoto.height
//                }
//            }
//            collageViewId.setItemDatas(images)

/*
            for (MDetailImage image : this.imageList){
                Map<String, String > singlePhoto = new HashMap<>();
                singlePhoto.put("width", image.getResolutions().getOriginal().getWidth());
                singlePhoto.put("height", image.getResolutions().getOriginal().getHeight());
            }
//            Map<String, String> singlePhoto = new HashMap<>();
//            singlePhoto.put("width", imageList.);
//            singlePhoto.put("height", )

            CollageItemUrlData();
            singlePhoto
            CollageItemUrlData(singlePhoto.url).apply {
                this.width = singlePhoto.width;
                this.height = singlePhoto.height;
            }
            val images = photos.map {
            }
            collageViewId.setItemDatas(images);

            binding.collageViewId.showCollage();
*/
            setImageCollage();
        }
    }

    private void setImageCollage() {

        CollageView collageView = (CollageView) findViewById(R.id.collageView);

        for (MDetailImage image : this.imageList) {
            Urls.add(image.getResolutions().getOriginal().getUrl());
        }
        collageView
                .photoMargin(1)
                .photoPadding(3)
                .backgroundColor(getResources().getColor(R.color.color_grey_text))
                .photoFrameColor(Color.WHITE)
                .useFirstAsHeader(true) // makes first photo fit device widtdh and use full line
                .defaultPhotosForLine(2) // sets default photos number for line of photos (can be changed by program at runtime)
                .iconSelector(this, 0) // (or use 0 as size to wrap content)
                .useCards(true) // adds cardview backgrounds to all photos
                .maxWidth(100) // will resize images if their side is bigger than 100
                .placeHolder(R.mipmap.default_image) //adds placeholder resource
                .headerForm(CollageView.ImageForm.IMAGE_FORM_SQUARE) // sets form of image for header (if useFirstAsHeader == true)
                .photosForm(CollageView.ImageForm.IMAGE_FORM_HALF_HEIGHT) //sets form of image for other photos
                .loadPhotos(Urls); // here you can use Array/List of photo urls or array of resource ids


        setImageClickListner();
    }

    private void setImageClickListner() {

        binding.collageView.setOnPhotoClickListener(new CollageView.OnPhotoClickListener() {
            @Override
            public void onPhotoClick(int position) {

        // do random stuff here

            }

        }
        );
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

    @Override
    public void onSucessfullyGetShowCrew(List<MShowCrew> showCrews) {

        if (showCrews != null && showCrews.size() != 0){
//            this.showCrewList.addAll(showCrews);
//            crewAdapter.notifyDataSetChanged();
        }else {
//            binding.tvShowCrew.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailToGetShowCrew(String errorMessage) {

    }

    @Override
    public void onSucessfullyGetShowAKAS(List<MTvShowAKAS> showAKAS) {

    }

    @Override
    public void onFailToGetShowAKAS(String errorMessage) {

    }


    @Override
    public int getIconResId(int pos) {
        return 0;
    }

    @Override
    public void onSeasonClick(MShowSeason showSeason, int position) {
        callIntent(showSeason);
    }

    private void callIntent(MShowSeason showSeason) {

        Intent intent = new Intent(TvShowDetailActivity.this, SeasonActivity.class);
        intent.putExtra("TvShowSeasonModel", showSeason);
        startActivity(intent);

    }
}
