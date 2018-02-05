package com.example.ilijaangeleski.flixbus.di;

import android.content.Context;

import com.example.ilijaangeleski.flixbus.api.NetworkApi;

import dagger.Component;

@Component(modules = {AppModule.class, NetworkModule.class})
public interface BaseComponent {
    Context getContext();

    NetworkApi getNetworkApi();
}
