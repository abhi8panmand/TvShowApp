package com.gravity.tvshows.Detail.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gravity.tvshows.Detail.Model.MShowCrew;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.databinding.ItemShowCrewBinding;

import java.util.List;

public class TvShowCrewAdapter extends RecyclerView.Adapter<TvShowCrewAdapter.ViewHolder> implements Constant {

    private Activity activity;
    private List<MShowCrew> showCrewList;
    private ItemShowCrewBinding binding;

    public TvShowCrewAdapter(Activity activity, List<MShowCrew> showCrewList) {
        this.activity = activity;
        this.showCrewList = showCrewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_show_crew, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MShowCrew showCrew = showCrewList.get(position);

        holder.setIsRecyclable(false);

        if (showCrew.getPerson().getImage() != null)
        {
            Glide.with(activity)
                    .load(showCrew.getPerson().getImage().getOriginal())
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image)
                            .circleCrop())
                    .into(binding.ivCharacter);

        }
        else {
            Glide.with(activity)
                    .load(Constant.default_image)
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image)
                            .circleCrop())
                    .into(binding.ivCharacter);
        }

        holder.binding.tvPersonName.setText(showCrew.getPerson().getName());

        if (showCrew.getPerson().getCountry() != null)
            holder.binding.tvPersonCountry.setText(showCrew.getPerson().getCountry().getName());
        else
            holder.binding.tvPersonCountry.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return showCrewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemShowCrewBinding binding;

        public ViewHolder(@NonNull ItemShowCrewBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}


