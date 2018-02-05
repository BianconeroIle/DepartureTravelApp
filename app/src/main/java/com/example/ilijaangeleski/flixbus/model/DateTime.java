package com.example.ilijaangeleski.flixbus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class DateTime implements Serializable {
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("tz")
    private String timeZone;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
