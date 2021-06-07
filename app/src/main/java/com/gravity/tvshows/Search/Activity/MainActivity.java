package com.gravity.tvshows.Search.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gravity.tvshows.Detail.Activity.TvShowDetailActivity;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Adapter.TvShowAdapter;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Search.Presenter.SerachTvShowPresenter;
import com.gravity.tvshows.Search.ViewInterface.SerachTvShowViewInterface;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.Support.Session;
import com.gravity.tvshows.Support.Utils;
import com.gravity.tvshows.databinding.ActivityMainBinding;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gravity.tvshows.Support.Constant.default_image;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends AppCompatActivity implements SerachTvShowViewInterface , TvShowAdapter.CallBack {

    private Activity activity;
    private ActivityMainBinding binding;
    private SerachTvShowPresenter presenter;
    private List<MTvShow> tvShowList = new ArrayList<>();
    private List<MShow> ShowList = new ArrayList<>();
    private MShow show;
    private TvShowAdapter adapter;
    private GridLayoutManager manager;
    private LinearLayoutManager linearManager;
    private float avgrating;
    private List<MShow> PrefShowList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

//        callApi(query);
        LoadData();
        setRecyclerview();
        onClick();
    }

    private void setRecyclerview() {

        manager = new GridLayoutManager(activity, 2);
        binding.recyclerViewTvShow.setLayoutManager(manager);
        binding.recyclerViewTvShow.setHasFixedSize(true);
        binding.recyclerViewTvShow.setItemAnimator(new DefaultItemAnimator());
        adapter = new TvShowAdapter(activity, ShowList, this);
        binding.recyclerViewTvShow.setAdapter(adapter);
    }

    private void onClick() {

        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tvShowList.clear();
                ShowList.clear();
                adapter.notifyDataSetChanged();
                callApi(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        binding.cvTvShow.setOnClickListener(view -> {
            callIntent(show);
        });
    }

    private void callIntent(MShow show) {
//        Type type = new TypeToken<MUser>() {}.getType();
//        MUser mUser = new Gson().fromJson(genericResponse.getJSONObject(DATA).toString(), type);
//        new Session(activity).setString(IS_LOGIN, YES);
//        new Session(activity).setUserProfile(mUser);

//        Type type = new TypeToken<MShow>(){}.getType();
//
//        MShow mShow = new Gson().fromJson(show.toString(), type);
//        new Session(activity).setShowList(mShow);

        saveData(show);

        Intent intent = new Intent(MainActivity.this, TvShowDetailActivity.class);
        intent.putExtra("TvShowModel", show);
        startActivity(intent);

    }

    private void saveData(MShow show) {

        SharedPreferences pref = getSharedPreferences(Constant.User_Search_History, 0);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();

//        start:
//        if (PrefShowList.size() < 5){
            for (int i = 0; i < PrefShowList.size(); i++){
                if (PrefShowList.get(i).getId() == show.getId()){
                    break;
                }else {
                    if (i+1 == PrefShowList.size()){
//                        PrefShowList.add(show);
//
//                        String json = gson.toJson(PrefShowList);
//                        editor.putString(Constant.SEARCH_DATA, json);
//                        editor.apply();
                        start:
                        if (PrefShowList.size() <= 5){
                            IfValidSize(gson, editor);
                        }else {
                            PrefShowList.remove(0);
                            String json = gson.toJson(PrefShowList);
                            editor.putString(Constant.SEARCH_DATA, json);
                            editor.apply();
                            break start;
                        }
                    }
                }
            }
//        }else {
//            PrefShowList.remove(0);
//            break start;
//        }


//        PrefShowList.add(show);
//        String json = gson.toJson(PrefShowList);
//        editor.putString(Constant.SEARCH_DATA, json);
//        editor.apply();
    }

    private void IfValidSize(Gson gson, SharedPreferences.Editor editor){
        PrefShowList.add(show);

        String json = gson.toJson(PrefShowList);
        editor.putString(Constant.SEARCH_DATA, json);
        editor.apply();
    }

    private void LoadData(){
        SharedPreferences pref = getSharedPreferences(Constant.User_Search_History, 0);
        Gson gson = new Gson();
        String json = pref.getString(Constant.SEARCH_DATA, null);

        Type type = new TypeToken<ArrayList<MShow>>(){}.getType();
        PrefShowList = gson.fromJson(json, type);

        if (PrefShowList == null){
            PrefShowList = new ArrayList<>();
        }

        setRecentSearchRecyclerview();
    }

    private void setRecentSearchRecyclerview() {

        linearManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        binding.recentSearchRecyclerViewTvShow.setLayoutManager(linearManager);
        binding.recentSearchRecyclerViewTvShow.setHasFixedSize(true);
        binding.recentSearchRecyclerViewTvShow.setItemAnimator(new DefaultItemAnimator());
        adapter = new TvShowAdapter(activity, PrefShowList, this);
        binding.recentSearchRecyclerViewTvShow.setAdapter(adapter);

    }

    private void callApi(String showname) {

        Map<String, String> map = new HashMap<>();
        map.put("q", showname);
        Utils.logthis(activity, showname);

        presenter = new SerachTvShowPresenter(activity, this);
        presenter.getTvShow(map);
        presenter.getSingleShow(map);
    }

    @Override
    public void onSucessfullyGetTvShow(List<MTvShow> tvShow) {

        if (tvShow != null && tvShow.size() != 0){

            binding.tvShowListHeader.setVisibility(View.VISIBLE);
            binding.recyclerViewTvShow.setVisibility(View.VISIBLE);
            this.tvShowList.addAll(tvShow);

            for (MTvShow tvShow1 : tvShow){
                ShowList.add(tvShow1.getShow());
            }
//        Utils.logthis(activity, tvShowList.get(0).getShow().getName());
            adapter.notifyDataSetChanged();
        }else {
            binding.tvShowListHeader.setVisibility(View.GONE);
            binding.recyclerViewTvShow.setVisibility(View.GONE);
        }

    }

    @Override
    public void onFailToGetTvShow(String errorMessage) {

//        Utils.showToastServerError(activity, errorMessage, "Something went wrong!");
        Utils.logthis(activity, errorMessage);
    }

    @Override
    public void onSucessfullyGetSingleTvShow(MShow tvShow) {

        if (tvShow != null) {

            this.show = tvShow;

            binding.tvSingleShowHeader.setVisibility(View.VISIBLE);
            binding.llSingleShow.setVisibility(View.VISIBLE);

            if (show.getImage() != null && show.getImage().getMedium() != null) {

                Glide.with(activity)
                        .load(show.getImage().getOriginal())
                        .apply(new RequestOptions()
                                .placeholder(R.mipmap.default_image)
                                .error(R.mipmap.default_image))
                        .into(binding.ivTvShow);
            }else {

                Glide.with(activity)
                        .load(default_image)
                        .apply(new RequestOptions()
                                .placeholder(R.mipmap.default_image)
                                .error(R.mipmap.default_image))
                        .into(binding.ivTvShow);
            }

            binding.tvTvShowName.setText(show.getName());
            avgrating = show.getRating().getAverage();

            binding.tvAvgRating.setText("Avg. Rating : "+avgrating+"/10");

            binding.rbTvShowRating.setRating(show.getRating().getAverage());

        }else {
            binding.tvSingleShowHeader.setVisibility(View.GONE);
            binding.llSingleShow.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailToGetSingleTvShow(String errorMessage) {
        Utils.logthis(activity, errorMessage);
    }

    @Override
    public void onCardClick(MShow show, int position) {
        callIntent(show);
    }
}
/*

Duplicate class android.support.v4.app.INotificationSideChannel found in modules core-1.3.1-runtime(androidx.core:core:1.3.1) and support-compat-25.3.1-runtime(com.android.support:support-compat:25.3.1)

*/
