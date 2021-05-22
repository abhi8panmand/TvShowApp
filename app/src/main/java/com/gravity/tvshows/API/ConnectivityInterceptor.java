package com.gravity.tvshows.API;

import android.app.Activity;
import android.widget.Toast;

import com.gravity.tvshows.Support.Utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.Request;

//public class ConnectivityInterceptor {
public class ConnectivityInterceptor implements Interceptor {

    private Activity activity;

    public ConnectivityInterceptor(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        if (!Utils.isConnectingToInternet(activity)) {
            throw new NoConnectivityException();
        }else {
            Request request = chain.request();
            Response response = chain.proceed(request);

            if (response.code() == 500) {
                activity.runOnUiThread(() -> Toast.makeText(activity, "500 error", Toast.LENGTH_SHORT).show());
                return response;
            }

            return response;
        }
    }
}
