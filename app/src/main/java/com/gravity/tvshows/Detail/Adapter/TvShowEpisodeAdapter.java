package com.gravity.tvshows.Detail.Adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.Detail.Model.MShowEpisode;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.databinding.ItemTvShowEpisodeBinding;

import java.util.List;

public class TvShowEpisodeAdapter extends RecyclerView.Adapter<TvShowEpisodeAdapter.ViewHolder> {

    private Activity activity;
    private List<MShowEpisode> episodeList;
    private ItemTvShowEpisodeBinding binding;

    public TvShowEpisodeAdapter(Activity activity, List<MShowEpisode> episodeList) {
        this.activity = activity;
        this.episodeList = episodeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_tv_show_episode, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowEpisodeAdapter.ViewHolder holder, int position) {

        holder.setIsRecyclable(false);

        MShowEpisode episode = episodeList.get(position);

        try {
            holder.binding.tvEpisodeName.setText(episode.getName());
        }catch (NullPointerException e){
//            return;
        }

        Resources res = activity.getResources();

        if (episode.getAirdate() != null){
            holder.binding.tvShowAirDate.setText(res.getString(R.string.air_date, episode.getAirdate()));
        }else {
            holder.binding.tvShowAirDate.setVisibility(View.GONE);
        }
        if (episode.getAirtime() != null){
            holder.binding.tvShowAirTime.setText(res.getString(R.string.air_time, episode.getAirtime()));
        }else {
            holder.binding.tvShowAirTime.setVisibility(View.GONE);
        }
        if (episode.getRuntime() != 0){
            holder.binding.tvEpisodeDuration.setText(res.getString(R.string.duration, episode.getRuntime()));
        }else {
            holder.binding.tvEpisodeDuration.setVisibility(View.GONE);
        }


        holder.binding.tvShowEpisodeNo.setText(res.getString(R.string.episode, episode.getNumber()));
        holder.binding.tvShowSeasonNo.setText(res.getString(R.string.seasons, episode.getSeason()));

        if (episode.getImage() != null)
        {
            Glide.with(activity)
                    .load(episode.getImage().getOriginal())
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(binding.ivEpisode);

        }
        else {
            Glide.with(activity)
                    .load(Constant.default_image)
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(binding.ivEpisode);
        }

        try {
            holder.binding.showEpisodeDescrption.setHtml(episode.getSummary());
        }catch (NullPointerException e){
//            return;
        }
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemTvShowEpisodeBinding binding;

        public ViewHolder(@NonNull ItemTvShowEpisodeBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
