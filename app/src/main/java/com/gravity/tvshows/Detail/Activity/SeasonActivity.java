package com.gravity.tvshows.Detail.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.gravity.tvshows.Detail.Adapter.TvShowCastAdapter;
import com.gravity.tvshows.Detail.Adapter.TvShowEpisodeAdapter;
import com.gravity.tvshows.Detail.Model.MShowEpisode;
import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.Detail.Presenter.TvShowEpisodePresenter;
import com.gravity.tvshows.Detail.ViewInterface.TvShowEpisodeViewInterface;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.ActivitySeasonBinding;

import java.util.ArrayList;
import java.util.List;

public class SeasonActivity extends AppCompatActivity implements TvShowEpisodeViewInterface {

    private Activity activity;
    private ActivitySeasonBinding binding;
    private MShowSeason season;
    private List<MShowEpisode> episodeList = new ArrayList<>();
    private TvShowEpisodeAdapter episodeAdapter;
    private int seasonNo;
    private LinearLayoutManager linearLayoutManager;
    private TvShowEpisodePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_season);

        getIntentData();
    }

    private void setEpisodeRecyclerView() {

        linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.VERTICAL, false);
        binding.recyclerViewTvShow.setLayoutManager(linearLayoutManager);
        binding.recyclerViewTvShow.setHasFixedSize(true);
        binding.recyclerViewTvShow.setItemAnimator(new DefaultItemAnimator());
        episodeAdapter = new TvShowEpisodeAdapter(activity, episodeList);
        binding.recyclerViewTvShow.setAdapter(episodeAdapter);
    }

    private void getIntentData() {

        // To retrieve object in second Activity

        Utils.logthis(activity, ""+getIntent().getSerializableExtra("TvShowSeasonModel"));
        season = (MShowSeason) getIntent().getSerializableExtra("TvShowSeasonModel");

        seasonNo = season.getId();

        callApi();
        setEpisodeRecyclerView();
    }

    private void callApi() {

        presenter = new TvShowEpisodePresenter(activity, this);
        presenter.ToGetEpisodeList(seasonNo);
    }

    @Override
    public void onSuccessfullyGetEpisodeList(List<MShowEpisode> episodeList) {

        if (episodeList != null && episodeList.size() != 0){
            this.episodeList.addAll(episodeList);
            episodeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailedToGetEpisodeList(String errorMessage) {

    }
}