package com.gravity.tvshows.Detail.Presenter;

import android.app.Activity;

import com.gravity.tvshows.API.ApiClient;
import com.gravity.tvshows.API.ApiInterface;
import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.Detail.Model.MShowCrew;
import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.Detail.Model.MTvShowAKAS;
import com.gravity.tvshows.Detail.PresenterInterface.TvShowDetailPresenterInterface;
import com.gravity.tvshows.Detail.ViewInterface.TvShowDetailViewInterface;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Support.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TvShowDetailPresenter implements TvShowDetailPresenterInterface {

    private Activity activity;
    private TvShowDetailViewInterface viewInterface;

    public TvShowDetailPresenter(Activity activity, TvShowDetailViewInterface viewInterface) {
        this.activity = activity;
        this.viewInterface = viewInterface;
    }

    private DisposableObserver<List<MDetailImage>> getObserverTvShowImage() {
        return new DisposableObserver<List<MDetailImage>>() {
            @Override
            public void onNext(@NonNull List<MDetailImage> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSucessfullyGetImage(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailToGetImage(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowImage(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowImage(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getImages(int id) {
        getObservableTvShowImage(id).subscribeWith(getObserverTvShowImage());
    }

    private DisposableObserver<List<MShowCast>> getObserverTvShowCast() {
        return new DisposableObserver<List<MShowCast>>() {
            @Override
            public void onNext(@NonNull List<MShowCast> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSuccessfullyGetTvShowCast(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailedToGetTvShowCast(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowCast(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowCast(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getCast(int id) {
        getObservableTvShowCast(id).subscribeWith(getObserverTvShowCast());
    }

    @Override
    public void getMain(int id) {

    }

    private DisposableObserver<List<MShowSeason>> getObserverTvShowSeason() {
        return new DisposableObserver<List<MShowSeason>>() {
            @Override
            public void onNext(@NonNull List<MShowSeason> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSuccessfullyGetTvShowSeason(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailedToGetTvShowSeason(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowSeason(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowSeason(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getSeason(int id) {
        getObservableTvShowSeason(id).subscribeWith(getObserverTvShowSeason());
    }

    private DisposableObserver<List<MShowCrew>> getObserverTvShowCrew() {
        return new DisposableObserver<List<MShowCrew>>() {
            @Override
            public void onNext(@NonNull List<MShowCrew> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSucessfullyGetShowCrew(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailToGetShowCrew(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowCrew(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowCrew(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getCrew(int id) {
        getObservableTvShowCrew(id).subscribeWith(getObserverTvShowCrew());
    }

    private DisposableObserver<List<MTvShowAKAS>> getObserverTvShowAKAS() {
        return new DisposableObserver<List<MTvShowAKAS>>() {
            @Override
            public void onNext(@NonNull List<MTvShowAKAS> response) {
                Utils.logthis(null, "responce "+response);
                viewInterface.onSucessfullyGetShowAKAS(response);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.onFailToGetShowAKAS(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private <T> Observable getObservableTvShowAKAS(int id) {
        return ApiClient.getClient(activity).create(ApiInterface.class).getTvShowAKAS(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getAKA(int id) {
        getObservableTvShowAKAS(id).subscribeWith(getObserverTvShowAKAS());
    }
}
