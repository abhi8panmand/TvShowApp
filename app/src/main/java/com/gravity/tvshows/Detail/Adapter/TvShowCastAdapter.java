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
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.R;
import com.gravity.tvshows.Support.Constant;
import com.gravity.tvshows.databinding.ItemShowCastBinding;
import com.gravity.tvshows.databinding.ItemTvShowBinding;

import java.util.List;

public class TvShowCastAdapter extends RecyclerView.Adapter<TvShowCastAdapter.ViewHolder> implements Constant {

    private Activity activity;
    private List<MShowCast> showCastList;
    private ItemShowCastBinding binding;

    public TvShowCastAdapter(Activity activity, List<MShowCast> showCastList) {
        this.activity = activity;
        this.showCastList = showCastList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_show_cast, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MShowCast showCast = showCastList.get(position);

        holder.setIsRecyclable(false);

        if (showCast.getCharacter().getImage() != null)
        {
            Glide.with(activity)
                    .load(showCast.getCharacter().getImage().getOriginal())
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(binding.ivCharacter);

        }else if (showCast.getPerson().getImage() != null)
        {
            Glide.with(activity)
                    .load(showCast.getPerson().getImage().getOriginal())
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(binding.ivCharacter);

        }
        else {
            Glide.with(activity)
                    .load(Constant.default_image)
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.default_image)
                            .error(R.mipmap.default_image))
                    .into(binding.ivCharacter);
        }

        holder.binding.tvPersonName.setText(showCast.getPerson().getName());
        if (showCast.isVoice())
            holder.binding.tvCharacterName.setText(showCast.getCharacter().getName()+"(Voice)");
        else
            holder.binding.tvCharacterName.setText(showCast.getCharacter().getName());

        if (showCast.getPerson().getCountry() != null)
            holder.binding.tvPersonCountry.setText(showCast.getPerson().getCountry().getName());
    }

    @Override
    public int getItemCount() {
        return showCastList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemShowCastBinding binding;

        public ViewHolder(@NonNull ItemShowCastBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
