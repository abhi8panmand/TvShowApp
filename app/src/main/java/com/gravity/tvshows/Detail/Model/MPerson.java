package com.gravity.tvshows.Detail.Model;

import com.gravity.tvshows.Search.Model.MCountry;
import com.gravity.tvshows.Search.Model.MImage;
import com.gravity.tvshows.Search.Model.MLink;

import java.io.Serializable;

public class MPerson implements Serializable {

    private int id;
    private String url;
    private String name;
    private MCountry country;
    private String birthday;
    private String deathday;
    private String gender;
    private MImage image;
    private MLink _links;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MImage getImage() {
        return image;
    }

    public void setImage(MImage image) {
        this.image = image;
    }

    public MLink get_links() {
        return _links;
    }

    public void set_links(MLink _links) {
        this._links = _links;
    }
}

/*

        "id":24483,
        "url":"https://www.tvmaze.com/people/24483/jennifer-aniston",
        "name":"Jennifer Aniston",
        "country":
            {
            "name":"United States",
            "code":"US",
            "timezone":"America/New_York"
            },
        "birthday":"1969-02-11",
        "deathday":null,
        "gender":"Female",
        "image":
            {
            "medium":"https://static.tvmaze.com/uploads/images/medium_portrait/217/544237.jpg",
            "original":"https://static.tvmaze.com/uploads/images/original_untouched/217/544237.jpg"
            },
        "_links":
            {
            "self":
            {
            "href":"https://api.tvmaze.com/people/24483"
            }
            }


            */
