package com.example.ilijaangeleski.flixbus.api;

import com.example.ilijaangeleski.flixbus.model.DeparturesResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public interface NetworkApi {

    String BASE_URL = "http://api.mobile.staging.mfb.io/";

    @Headers("X-Api-Authentication: intervIEW_TOK3n")
    @GET("mobile/v1/network/station/10/timetable")
    Call<DeparturesResults> fetchBus();
}
