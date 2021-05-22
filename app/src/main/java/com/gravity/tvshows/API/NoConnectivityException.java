package com.gravity.tvshows.API;

import java.io.IOException;

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "please check your internet connection";
    }

}
