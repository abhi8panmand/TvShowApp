package com.gravity.tvshows.Detail.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.R;
import com.gravity.tvshows.databinding.ItemShowSeasonBinding;

import java.util.List;

import javax.security.auth.callback.Callback;

public class TvShowSeasonAdapter extends RecyclerView.Adapter<TvShowSeasonAdapter.ViewHolder> {

    private Activity activity;
    private List<MShowSeason> seasonList;
    private ItemShowSeasonBinding binding;
    private CallBack callBack;

    public TvShowSeasonAdapter(Activity activity, List<MShowSeason> seasonList) {
        this.activity = activity;
        this.seasonList = seasonList;
    }

    public TvShowSeasonAdapter(Activity activity, List<MShowSeason> seasonList, CallBack callBack) {
        this.activity = activity;
        this.seasonList = seasonList;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_show_season, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MShowSeason season = seasonList.get(position);

        holder.binding.btnSeason.setText("Season "+season.getNumber());

        holder.binding.btnSeason.setOnClickListener(view -> {
            callBack.onSeasonClick(season, position);
        });
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemShowSeasonBinding binding;

        public ViewHolder(@NonNull ItemShowSeasonBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    public interface CallBack {

        void onSeasonClick(MShowSeason showSeason, int position);
    }
}
