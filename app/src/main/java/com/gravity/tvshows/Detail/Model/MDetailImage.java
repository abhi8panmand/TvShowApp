package com.gravity.tvshows.Detail.Model;

import java.io.Serializable;

public class MDetailImage implements Serializable {

    private int id;
    private String type;
    private boolean main;
    private MResolution resolutions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public MResolution getResolutions() {
        return resolutions;
    }

    public void setResolutions(MResolution resolutions) {
        this.resolutions = resolutions;
    }
}


/*
[
        {
            "id":1,
            "type":"poster",
            "main":false,
            "resolutions":
            {
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
                }
            }
        },
]*/
