package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MLink implements Serializable {

    private MSelf self;
    private MSelf previousepisode;

    public MSelf getSelf() {
        return self;
    }

    public void setSelf(MSelf self) {
        this.self = self;
    }

    public MSelf getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(MSelf previousepisode) {
        this.previousepisode = previousepisode;
    }

    private class MSelf implements Serializable {

        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        //                "href":"https://api.tvmaze.com/shows/66"

    }

    /*private class MPreviousepisode {


//                "href":"https://api.tvmaze.com/episodes/1646220"

    }*/
}



//            "self":{},
//            "previousepisode":{}