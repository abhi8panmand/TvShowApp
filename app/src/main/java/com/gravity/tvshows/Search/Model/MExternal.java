package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MExternal implements Serializable {

    private int tvrage;
    private int thetvdb;
    private String imdb;

    public int getTvrage() {
        return tvrage;
    }

    public void setTvrage(int tvrage) {
        this.tvrage = tvrage;
    }

    public int getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(int thetvdb) {
        this.thetvdb = thetvdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
}



//            "tvrage":8511,
//            "thetvdb":80379,
//            "imdb":"tt0898266"