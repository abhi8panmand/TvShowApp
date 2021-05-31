package com.gravity.tvshows.Search.Presenter;

import android.app.Activity;

import com.gravity.tvshows.API.ApiClient;
import com.gravity.tvshows.API.ApiInterface;
import com.gravity.tvshows.API.ResponseData;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Search.Model.MTvShow;
import com.gravity.tvshows.Search.PresenterInterface.SerachTvShowPresenterInterface;
import com.gravity.tvshows.Search.ViewInterface.SerachTvShowViewInterface;
import com.gravity.tvshows.Support.Utils;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SerachTvShowPresenter implements SerachTvShowPresenterInterface {

    private Activity activity;
    private SerachTvShowViewInterface viewInterface;

    public SerachTvShowPresenter(Activity activity, SerachTvShowViewInterface viewInterface) {
        this.activity = activity;
        this.viewInterface = viewInterface;
    }

    private DisposableObserver<List<MTvShow>> getObserverSearchTvShow() {
        return new DisposableObserver<List<MTvShow>>() {
            @Override
            public void onNext(@NonNull List<MTvShow> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSucessfullyGetTvShow(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailToGetTvShow(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }


    private <T> Observable getObservableSearchTvShow(Map<String, String> map) {
        return ApiClient.getClient(activity).create(ApiInterface.class).searchTvShowlisting(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getTvShow(Map<String, String> map) {
        getObservableSearchTvShow(map).subscribeWith(getObserverSearchTvShow());
    }

    private DisposableObserver<MShow> getObserverSearchSingleTvShow() {
        return new DisposableObserver<MShow>() {
            @Override
            public void onNext(@NonNull MShow response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSucessfullyGetSingleTvShow(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailToGetSingleTvShow(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }


    private <T> Observable getObservableSearchSingleTvShow(Map<String, String> map) {
        return ApiClient.getClient(activity).create(ApiInterface.class).searchTvShow(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getSingleShow(Map<String, String> map) {
        getObservableSearchSingleTvShow(map).subscribeWith(getObserverSearchSingleTvShow());
    }
}
