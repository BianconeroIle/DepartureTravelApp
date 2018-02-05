package com.example.ilijaangeleski.flixbus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class TimeTable implements Serializable {
    @SerializedName("departures")
    List<Departures> departures;

    public List<Departures> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departures> departures) {
        this.departures = departures;
    }
}
