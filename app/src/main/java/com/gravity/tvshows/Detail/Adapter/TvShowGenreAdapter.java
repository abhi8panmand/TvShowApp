package com.gravity.tvshows.Detail.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gravity.tvshows.R;
import com.gravity.tvshows.databinding.ItemShowGenreBinding;

import java.util.ArrayList;

public class TvShowGenreAdapter extends RecyclerView.Adapter<TvShowGenreAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<String> genres;
    private ItemShowGenreBinding binding;

    public TvShowGenreAdapter(Activity activity, ArrayList<String> genres) {
        this.activity = activity;
        this.genres = genres;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_show_genre, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setIsRecyclable(false);

        holder.binding.showGenre.setText(genres.get(position));

        if ((position+1) == genres.size())
            holder.binding.view.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemShowGenreBinding binding;

        public ViewHolder(@NonNull ItemShowGenreBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
