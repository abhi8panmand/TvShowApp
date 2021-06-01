package com.gravity.tvshows.Detail.Model;

import java.io.Serializable;

public class MShowCrew implements Serializable {

    private String type;
    private MPerson person;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MPerson getPerson() {
        return person;
    }

    public void setPerson(MPerson person) {
        this.person = person;
    }
}


//[
//        {
//            "type":"Creator",
//            "person":
//                {
//                    "id":2193,
//                    "url":"https://www.tvmaze.com/people/2193/bruno-heller",
//                    "name":"Bruno Heller",
//                    "country":
//                        {
//                            "name":"United Kingdom",
//                            "code":"GB",
//                            "timezone":"Europe/London"
//                        },
//                    "birthday":null,
//                    "deathday":null,
//                    "gender":"Male",
//                    "image":
//                        {
//                            "medium":"https://static.tvmaze.com/uploads/images/medium_portrait/182/455182.jpg",
//                            "original":"https://static.tvmaze.com/uploads/images/original_untouched/182/455182.jpg"
//                        },
//                    "_links":
//                        {
//                            "self":
//                                {
//                                    "href":"https://api.tvmaze.com/people/2193"
//                                }
//                        }
//                }
//        }
//]