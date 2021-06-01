package com.gravity.tvshows.Detail.Model;

import com.gravity.tvshows.Search.Model.MImage;
import com.gravity.tvshows.Search.Model.MLink;

import java.io.Serializable;

public class MShowEpisode implements Serializable {

    private int id;
    private String name;
    private String url;
    private int season;
    private int number;
    private String type;
    private String airdate;
    private String airtime;
    private String airstamp;
    private int runtime;
    private MImage image;
    private String summary;
    private MLink _link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getAirstamp() {
        return airstamp;
    }

    public void setAirstamp(String airstamp) {
        this.airstamp = airstamp;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public MImage getImage() {
        return image;
    }

    public void setImage(MImage image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MLink get_link() {
        return _link;
    }

    public void set_link(MLink _link) {
        this._link = _link;
    }

}


//
//[
//        {
//            "id":1,
//            "url":"https://www.tvmaze.com/episodes/1/under-the-dome-1x01-pilot","name":"Pilot",
//            "season":1,
//            "number":1,
//            "type":"regular",
//            "airdate":"2013-06-24",
//            "airtime":"22:00",
//            "airstamp":"2013-06-25T02:00:00+00:00",
//            "runtime":60,
//            "image":
//                {
//                    "medium":"https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
//                    "original":"https://static.tvmaze.com/uploads/images/original_untouched/1/4388.jpg"
//                },
//            "summary":"<p>When the residents of Chester's Mill find themselves trapped under a massive transparent dome with no way out, they struggle to survive as resources rapidly dwindle and panic quickly escalates.</p>",
//            "_links":
//                {
//                    "self":
//                        {
//                            "href":"https://api.tvmaze.com/episodes/1"
//                        }
//                }
//        }
//]



//[
//        {
//            "id":8878,
//            "url":"https://www.tvmaze.com/episodes/8878/the-mentalist-1x01-pilot",
//            "name":"Pilot",
//            "season":1,
//            "number":1,
//            "type":"regular",
//            "airdate":"2008-09-23",
//            "airtime":"21:00",
//            "airstamp":"2008-09-24T01:00:00+00:00",
//            "runtime":60,
//            "image":
//                {
//                    "medium":"https://static.tvmaze.com/uploads/images/medium_landscape/182/455203.jpg",
//                    "original":"https://static.tvmaze.com/uploads/images/original_untouched/182/455203.jpg"
//                },
//            "summary":"<p>Consultant Patrick Jane, Senior Agent Teresa Lisbon and her team investigate the double murder in Palm Springs of a pro golfer's wife and her doctor, which has the hallmarks of a serial killer with a personal connection to Jane.</p>",
//            "_links":
//                {
//                    "self":
//                        {
//                            "href":"https://api.tvmaze.com/episodes/8878"
//                        }
//                }
//        }
//]