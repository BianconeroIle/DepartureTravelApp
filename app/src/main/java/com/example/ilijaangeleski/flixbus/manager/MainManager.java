package com.example.ilijaangeleski.flixbus.manager;

import com.example.ilijaangeleski.flixbus.api.NetworkApi;
import com.example.ilijaangeleski.flixbus.callback.DepartureCallback;
import com.example.ilijaangeleski.flixbus.model.DeparturesResults;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class MainManager {
    private NetworkApi networkApi;

    public MainManager(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public void fetchDepartures(final DepartureCallback callback){
        networkApi.fetchBus().enqueue(new Callback<DeparturesResults>() {
            @Override
            public void onResponse(Call<DeparturesResults> call, Response<DeparturesResults> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DeparturesResults> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
