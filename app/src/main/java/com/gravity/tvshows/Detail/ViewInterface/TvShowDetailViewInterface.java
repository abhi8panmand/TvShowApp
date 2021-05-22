package com.gravity.tvshows.Detail.ViewInterface;

import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.Detail.Model.MShowSeason;

import java.util.List;

public interface TvShowDetailViewInterface {

    void onSucessfullyGetImage(List<MDetailImage> tvShow);
    void onFailToGetImage(String errorMessage);

    void onSuccessfullyGetTvShowCast(List<MShowCast> cast);
    void onFailedToGetTvShowCast(String errorMessage);

    void onSuccessfullyGetTvShowSeason(List<MShowSeason> seasons);
    void onFailedToGetTvShowSeason(String errorMessage);
}
