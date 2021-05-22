package com.gravity.tvshows.Search.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gravity.tvshows.Detail.Activity.TvShowDetailActivity;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Adapter.TvShowAdapter;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Search.Presenter.SerachTvShowPresenter;
import com.gravity.tvshows.Search.ViewInterface.SerachTvShowViewInterface;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends AppCompatActivity implements SerachTvShowViewInterface , TvShowAdapter.CallBack {

    private Activity activity;
    private ActivityMainBinding binding;
    private SerachTvShowPresenter presenter;
    private List<MTvShow> tvShowList = new ArrayList<>();
    private TvShowAdapter adapter;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

//        callApi(query);
        setRecyclerview();
        onClick();
    }

    private void setRecyclerview() {

        manager = new GridLayoutManager(activity, 2);
        binding.recyclerViewTvShow.setLayoutManager(manager);
        binding.recyclerViewTvShow.setHasFixedSize(true);
        binding.recyclerViewTvShow.setItemAnimator(new DefaultItemAnimator());
        adapter = new TvShowAdapter(activity, tvShowList, this);
        binding.recyclerViewTvShow.setAdapter(adapter);
    }

    private void onClick() {

        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tvShowList.clear();
                adapter.notifyDataSetChanged();
                callApi(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void callApi(String showname) {

        Map<String, String> map = new HashMap<>();
        map.put("q", showname);
        Utils.logthis(activity, showname);

        presenter = new SerachTvShowPresenter(activity, this);
        presenter.getTvShow(map);
    }

    @Override
    public void onSucessfullyGetTvShow(List<MTvShow> tvShow) {

        this.tvShowList.addAll(tvShow);
//        Utils.logthis(activity, tvShowList.get(0).getShow().getName());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailToGetTvShow(String errorMessage) {

//        Utils.showToastServerError(activity, errorMessage, "Something went wrong!");
        Utils.logthis(activity, errorMessage);
    }

    @Override
    public void onCardClick(MTvShow show, int position) {

        Intent intent = new Intent(MainActivity.this, TvShowDetailActivity.class);
        intent.putExtra("TvShowModel", show);
        startActivity(intent);
    }
}
/*

Duplicate class android.support.v4.app.INotificationSideChannel found in modules core-1.3.1-runtime(androidx.core:core:1.3.1) and support-compat-25.3.1-runtime(com.android.support:support-compat:25.3.1)

*/
