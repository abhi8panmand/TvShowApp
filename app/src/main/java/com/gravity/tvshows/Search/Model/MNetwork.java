package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MNetwork implements Serializable {

    private int id;
    private String name;
    private MCountry country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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



//            "id":2,
//            "name":"CBS",
//            "country":{}