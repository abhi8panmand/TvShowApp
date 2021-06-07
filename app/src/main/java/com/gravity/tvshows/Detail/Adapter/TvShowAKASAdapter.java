package com.gravity.tvshows.Detail.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gravity.tvshows.Detail.Model.MTvShowAKAS;
import com.gravity.tvshows.R;
import com.gravity.tvshows.databinding.ItemShowAkasBinding;

import java.util.List;
import java.util.Objects;

public class TvShowAKASAdapter extends RecyclerView.Adapter<TvShowAKASAdapter.ViewHolder> {

    private Activity activity;
    private List<MTvShowAKAS> showAKAS;
    private ItemShowAkasBinding binding;

    public TvShowAKASAdapter(Activity activity, List<MTvShowAKAS> showAKAS) {
        this.activity = activity;
        this.showAKAS = showAKAS;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_show_akas, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setIsRecyclable(false);
        MTvShowAKAS akas = showAKAS.get(position);

        holder.binding.tvShowName.setText(akas.getName());
        try {
            holder.binding.tvShowCountry.setText(akas.getCountry().getName());
        }catch (NullPointerException e){
            holder.binding.tvShowCountry.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return showAKAS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemShowAkasBinding binding;

        public ViewHolder(@NonNull ItemShowAkasBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
