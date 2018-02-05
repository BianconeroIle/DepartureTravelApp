package com.example.ilijaangeleski.flixbus.callback;

import com.example.ilijaangeleski.flixbus.model.DeparturesResults;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public interface DepartureCallback {
    void onSuccess(DeparturesResults response);

    void onFailure(Throwable t);
}
