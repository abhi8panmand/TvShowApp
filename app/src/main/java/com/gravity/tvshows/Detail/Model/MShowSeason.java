package com.gravity.tvshows.Detail.Model;

import com.gravity.tvshows.Search.Model.MImage;
import com.gravity.tvshows.Search.Model.MLink;
import com.gravity.tvshows.Search.Model.MNetwork;

import java.io.Serializable;

public class MShowSeason implements Serializable {

    private int id;
    private String url;
    private int number;
    private String name;
    private int episodeOrder;
    private String premiereDate;
    private String endDate;
    private MNetwork network;
    private MNetwork webChannel;
    private MImage image;
    private String summary;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodeOrder() {
        return episodeOrder;
    }

    public void setEpisodeOrder(int episodeOrder) {
        this.episodeOrder = episodeOrder;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public MNetwork getNetwork() {
        return network;
    }

    public void setNetwork(MNetwork network) {
        this.network = network;
    }

    public MNetwork getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(MNetwork webChannel) {
        this.webChannel = webChannel;
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

    public MLink get_links() {
        return _links;
    }

    public void set_links(MLink _links) {
        this._links = _links;
    }
}

//
//
//[
//        {
//        "id":546,
//        "url":"https://www.tvmaze.com/seasons/546/the-mentalist-season-1",
//        "number":1,
//        "name":"",
//        "episodeOrder":23,
//        "premiereDate":"2008-09-23",
//        "endDate":"2009-05-19",
//        "network":{},
//        "webChannel":null,
//        "image":null,
//        "summary":null,
//        "_links":{}
//        },