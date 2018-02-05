package com.example.ilijaangeleski.flixbus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class Departures implements Serializable{
    @SerializedName("direction")
    private String direction;
    @SerializedName("line_code")
    private String line_code;
    @SerializedName("datetime")
    private DateTime dateTime;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLine_code() {
        return line_code;
    }

    public void setLine_code(String line_code) {
        this.line_code = line_code;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
