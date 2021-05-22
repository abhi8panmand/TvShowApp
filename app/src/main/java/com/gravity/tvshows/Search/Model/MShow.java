package com.gravity.tvshows.Search.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MShow implements Serializable {

    private int id;
    private String url;
    private String name;
    private String type;
    private String language;
    private ArrayList<String> genres;
    private String status;
    private int runtime;
    private String premiered;
    private String officalSite;
    private MSchedule schedule;

    private MRating rating;

    private int weight;
    private MNetwork network;

    private MNetwork webChannel;
    private String dvdCountry;
    private MExternal external;

    private MImage image;

    private String summary;
    private int updated;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getOfficalSite() {
        return officalSite;
    }

    public void setOfficalSite(String officalSite) {
        this.officalSite = officalSite;
    }

    public MSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MSchedule schedule) {
        this.schedule = schedule;
    }

    public MRating getRating() {
        return rating;
    }

    public void setRating(MRating rating) {
        this.rating = rating;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public String getDvdCountry() {
        return dvdCountry;
    }

    public void setDvdCountry(String dvdCountry) {
        this.dvdCountry = dvdCountry;
    }

    public MExternal getExternal() {
        return external;
    }

    public void setExternal(MExternal external) {
        this.external = external;
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

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public MLink get_links() {
        return _links;
    }

    public void set_links(MLink _links) {
        this._links = _links;
    }
}


/*
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
        "schedule":{},
        "rating":{},
        "weight":97,
        "network":{},
        "webChannel":null,
        "dvdCountry":null,
        "externals":{},
        "image":{},
        "summary":"<p><b>The Big Bang Theory</b> is a comedy about brilliant physicists, Leonard and Sheldon, who are the kind of \"beautiful minds\" that understand how the universe works. But none of that genius helps them interact with people, especially women. All this begins to change when a free-spirited beauty named Penny moves in next door. Sheldon, Leonard's roommate, is quite content spending his nights playing Klingon Boggle with their socially dysfunctional friends, fellow Cal Tech scientists Wolowitz and Koothrappali. However, Leonard sees in Penny a whole new universe of possibilities... including love.</p>",
        "updated":1616618140,
        "_links":{}
*/
