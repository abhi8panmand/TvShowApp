package com.gravity.tvshows.Detail.Model;

import java.io.Serializable;

public class MShowCast implements Serializable {

    private MPerson person;
    private MPerson character;
    private boolean self;
    private boolean voice;

    public MPerson getPerson() {
        return person;
    }

    public void setPerson(MPerson person) {
        this.person = person;
    }

    public MPerson getCharacter() {
        return character;
    }

    public void setCharacter(MPerson character) {
        this.character = character;
    }

    public boolean isSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public boolean isVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }
}

//////////////Cast

/*

[
    {
     "person":
        {
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
        },
    "character":
        {
            "id":78218,
            "url":"https://www.tvmaze.com/characters/78218/friends-rachel-green",
            "name":"Rachel Green",
            "image":
                {
                    "medium":"https://static.tvmaze.com/uploads/images/medium_portrait/3/7875.jpg",
                    "original":"https://static.tvmaze.com/uploads/images/original_untouched/3/7875.jpg"
                },
            "_links":
                {
                    "self":
                        {
                            "href":"https://api.tvmaze.com/characters/78218"
                        }
                }
        },
    "self":false,
    "voice":false
    }
]

*/
