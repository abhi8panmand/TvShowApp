package com.gravity.tvshows.Detail.Presenter;

import android.app.Activity;

import com.gravity.tvshows.API.ApiClient;
import com.gravity.tvshows.API.ApiInterface;
import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowEpisode;
import com.gravity.tvshows.Detail.PresenterInterface.TvShowEpisodePresenterInterface;
import com.gravity.tvshows.Detail.ViewInterface.TvShowEpisodeViewInterface;
import com.gravity.tvshows.Support.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TvShowEpisodePresenter implements TvShowEpisodePresenterInterface {

    private Activity activity;
    private TvShowEpisodeViewInterface viewInterface;

    public TvShowEpisodePresenter(Activity activity, TvShowEpisodeViewInterface viewInterface) {
        this.activity = activity;
        this.viewInterface = viewInterface;
    }


    private DisposableObserver<List<MShowEpisode>> getObserverTvShowEpisode() {
        return new DisposableObserver<List<MShowEpisode>>() {
            @Override
            public void onNext(@NonNull List<MShowEpisode> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSuccessfullyGetEpisodeList(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailedToGetEpisodeList(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowEpisode(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowEpisode(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void ToGetEpisodeList(int id) {
        getObservableTvShowEpisode(id).subscribeWith(getObserverTvShowEpisode());
    }
}
