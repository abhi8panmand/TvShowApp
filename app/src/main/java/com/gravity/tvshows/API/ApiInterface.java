package com.gravity.tvshows.API;

import com.gravity.tvshows.Detail.Model.MDetailImage;
import com.gravity.tvshows.Detail.Model.MShowCast;
import com.gravity.tvshows.Detail.Model.MShowSeason;
import com.gravity.tvshows.Search.Model.MShow;
import com.gravity.tvshows.Search.Model.MTvShow;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiInterface {


//    @GET("supplier/logout")
//    Observable<Response<Void>> logout(@Header("Authorization") String token);


//    @GET("product/getlistseller")
//    Observable<ResponseData<List<MTvShow>>> filterTvShowlisting(@Header("Authorization") String token,
//                                                                 @QueryMap Map<String, String> map);

    @GET("singlesearch/shows")
    Observable<MShow> searchTvShow(@QueryMap Map<String, String> map);

    @GET("search/shows")
    Observable<List<MTvShow>> searchTvShowlisting(@QueryMap Map<String, String> map);

    @GET("shows/{id}/images")
    Observable<List<MDetailImage>> getTvShowImage(@Path("id") int id);

    @GET("shows/{id}/cast")
    Observable<List<MShowCast>> getTvShowCast(@Path("id") int id);

    @GET("shows/{id}/seasons")
    Observable<List<MShowSeason>> getTvShowSeason(@Path("id") int id);

//    @GET("search/shows/{id}")
//    Observable<Response<ResponseData<MTvShow>>> TvShowdetail(@Header("Authorization") String token,
//                                                                   @Path("id") int id);
}


//    public static String BASE_URL = "http://api.tvmaze.com/search/shows?q=big%20bang%20theory";