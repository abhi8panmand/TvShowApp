package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MCountry implements Serializable {

    private String name;
    private String code;
    private String timezone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }


    //                "name":"United States",
//                "code":"US",
//                "timezone":"America/New_York"
}