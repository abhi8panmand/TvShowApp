package com.gravity.tvshows.Search.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.databinding.ItemTvShowBinding;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> implements Constant {

    private Activity activity;
    private List<MTvShow> tvShowList;
    private ItemTvShowBinding binding;
    private float avgrating;
    private CallBack callback;


    public TvShowAdapter(Activity activity, List<MTvShow> tvShowList, CallBack callback) {
        this.activity = activity;
        this.tvShowList = tvShowList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_tv_show, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MTvShow tvShow = this.tvShowList.get(position);
//        holder.binding.ivTvShow.

        if (tvShow.getShow().getImage() != null && tvShow.getShow().getImage().getMedium() != null) {

            Glide.with(activity)
                    .load(tvShow.getShow().getImage().getOriginal())
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(holder.binding.ivTvShow);
        }else {


            Glide.with(activity)
                    .load(default_image)
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(holder.binding.ivTvShow);
        }

        holder.binding.tvTvShowName.setText(tvShow.getShow().getName());
        avgrating = tvShow.getShow().getRating().getAverage();

        holder.binding.tvAvgRating.setText("Avg. Rating : "+avgrating+"/10");
        holder.binding.rbTvShowRating.setRating(avgrating);

        holder.binding.cvTvShow.setOnClickListener(view -> {
            callback.onCardClick(tvShow, position);
        });
    }

    @Override
    public int getItemCount() {
        return tvShowList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemTvShowBinding binding;

        public ViewHolder(@NonNull ItemTvShowBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    public interface CallBack{

        void onCardClick(MTvShow show, int position);
    }
}
