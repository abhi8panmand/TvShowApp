package com.gravity.tvshows.Detail.Model;


import java.io.Serializable;

public class MResolution implements Serializable {

    private MImages original;
    private MImages medium;

    public MImages getOriginal() {
        return original;
    }

    public void setOriginal(MImages original) {
        this.original = original;
    }

    public MImages getMedium() {
        return medium;
    }

    public void setMedium(MImages medium) {
        this.medium = medium;
    }


}

/*

        "original":
        {
        "url":"https://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg",
        "width":680,
        "height":1000
        },
        "medium":
        {
        "url":"https://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg",
        "width":210,
        "height":295
        }*/
