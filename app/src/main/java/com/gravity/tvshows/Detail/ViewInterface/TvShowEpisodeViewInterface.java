package com.gravity.tvshows.Detail.ViewInterface;

import com.gravity.tvshows.Detail.Model.MShowEpisode;

import java.util.List;

public interface TvShowEpisodeViewInterface {

    void onSuccessfullyGetEpisodeList(List<MShowEpisode> episodeList);

    void onFailedToGetEpisodeList(String errorMessage);
}
