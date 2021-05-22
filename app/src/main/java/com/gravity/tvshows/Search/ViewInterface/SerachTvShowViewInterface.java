package com.gravity.tvshows.Search.ViewInterface;

import com.gravity.tvshows.Search.Model.MTvShow;

import java.util.List;

public interface SerachTvShowViewInterface {

    void onSucessfullyGetTvShow(List<MTvShow> tvShow);

    void onFailToGetTvShow(String errorMessage);
}
