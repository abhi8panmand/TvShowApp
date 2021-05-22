package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MImage implements Serializable {

    private String medium;
    private String original;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}



//            "medium":"https://static.tvmaze.com/uploads/images/medium_portrait/173/433868.jpg",
//            "original":"https://static.tvmaze.com/uploads/images/original_untouched/173/433868.jpg"