package com.gravity.tvshows.API;

import org.json.JSONObject;

public interface ApiResponse {

    public void onSuccess(JSONObject genericResponse, String msg, int ResponseOf);

    public void onFailed(GenericResponse genericResponse, String msg, int ResponseOf);

    public void onException(boolean type, String msg, int ResponseOf);
}
