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

public class TvShowSeasonAdapter extends RecyclerView.Adapter<TvShowSeasonAdapter.ViewHolder> {

    private Activity activity;
    private List<MShowSeason> seasonList;
    private ItemShowSeasonBinding binding;

    public TvShowSeasonAdapter(Activity activity, List<MShowSeason> seasonList) {
        this.activity = activity;
        this.seasonList = seasonList;
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
}
