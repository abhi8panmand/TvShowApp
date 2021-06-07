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
//        {
//            "name":"A mentalista",
//            "country":
//                {
//                    "name":"Hungary",
//                    "code":"HU",
//                    "timezone":"Europe/Budapest"
//                }
//        },
//        {
//            "name":"În mintea criminalului",
//            "country":
//                {
//                    "name":"Romania",
//                    "code":"RO",
//                    "timezone":"Europe/Bucharest"
//                }
//        },
//        {
//            "name":"El Mentalista",
//            "country":
//                {
//                    "name":"Mexico",
//                    "code":"MX",
//                    "timezone":"America/Monterrey"
//                }
//        },
//        {
//            "name":"Mentalist",
//            "country":
//                {
//                    "name":"France",
//                    "code":"FR",
//                    "timezone":"Europe/Paris"
//                }
//        }
//]