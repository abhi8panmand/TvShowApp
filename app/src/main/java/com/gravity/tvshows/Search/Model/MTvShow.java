package com.gravity.tvshows.Search.Model;

import java.io.Serializable;

public class MTvShow implements Serializable {

    private double score;
    private MShow show;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public MShow getShow() {
        return show;
    }

    public void setShow(MShow show) {
        this.show = show;
    }
}

/*
[
    {
    "score":48.653053,
    "show":{
        "id":66,
        "url":"https://www.tvmaze.com/shows/66/the-big-bang-theory",
        "name":"The Big Bang Theory",
        "type":"Scripted",
        "language":"English",
        "genres":["Comedy"],
        "status":"Ended",
        "runtime":30,
        "premiered":"2007-09-24",
        "officialSite":"http://www.cbs.com/shows/big_bang_theory/",
        "schedule":{
            "time":"20:00",
            "days":["Thursday"]
                    },
        "rating":{"average":8},
        "weight":97,
        "network":{
            "id":2,
            "name":"CBS",
            "country":{
                "name":"United States",
                "code":"US",
                "timezone":"America/New_York"
                    }
                },
        "webChannel":null,
        "dvdCountry":null,
        "externals":{
            "tvrage":8511,
            "thetvdb":80379,
            "imdb":"tt0898266"},
            "image":{
                "medium":"https://static.tvmaze.com/uploads/images/medium_portrait/173/433868.jpg",
                "original":"https://static.tvmaze.com/uploads/images/original_untouched/173/433868.jpg"
                    },
            "summary":"<p><b>The Big Bang Theory</b> is a comedy about brilliant physicists, Leonard and Sheldon, who are the kind of \"beautiful minds\" that understand how the universe works. But none of that genius helps them interact with people, especially women. All this begins to change when a free-spirited beauty named Penny moves in next door. Sheldon, Leonard's roommate, is quite content spending his nights playing Klingon Boggle with their socially dysfunctional friends, fellow Cal Tech scientists Wolowitz and Koothrappali. However, Leonard sees in Penny a whole new universe of possibilities... including love.</p>",
            "updated":1616618140,
            "_links":{
                "self":{
                    "href":"https://api.tvmaze.com/shows/66"
                        },
                "previousepisode":{
                    "href":"https://api.tvmaze.com/episodes/1646220"
                                }
                    }
                    }
                    }
                    ]*/
