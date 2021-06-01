package com.gravity.tvshows.Detail.Model;

import com.gravity.tvshows.Search.Model.MCountry;

import java.io.Serializable;

public class MTvShowAKAS implements Serializable {

    private String name;
    private MCountry country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MCountry getCountry() {
        return country;
    }

    public void setCountry(MCountry country) {
        this.country = country;
    }
}



//[
//        {
//            "name":"Менталист",
//            "country":
//                {
//                    "name":"Russian Federation",
//                    "code":"RU",
//                    "timezone":"Asia/Kamchatka"
//                }
//        },
//]