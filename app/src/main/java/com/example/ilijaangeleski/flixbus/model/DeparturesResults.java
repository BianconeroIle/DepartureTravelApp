package com.example.ilijaangeleski.flixbus.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class DeparturesResults {
    @SerializedName("timetable")
    private TimeTable timeTable;

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}

