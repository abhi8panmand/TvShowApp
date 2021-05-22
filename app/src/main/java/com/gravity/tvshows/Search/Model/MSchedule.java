package com.gravity.tvshows.Search.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MSchedule implements Serializable {

    private String time;
    private ArrayList<String> days;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }
}



//                    "time":"20:00",
//                    "days":["Thursday"]