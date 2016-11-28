package com.example.sandeep.changepins;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class Place {

    String action;
    String time;

    public Place(String action, String time){
        this.action = action;
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
