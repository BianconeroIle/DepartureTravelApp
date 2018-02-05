package com.example.ilijaangeleski.flixbus;

import android.app.Application;

import com.example.ilijaangeleski.flixbus.di.AppModule;
import com.example.ilijaangeleski.flixbus.di.BaseComponent;
import com.example.ilijaangeleski.flixbus.di.DaggerBaseComponent;
import com.example.ilijaangeleski.flixbus.di.NetworkModule;

public class MyApp extends Application {
    private BaseComponent baseComponent;
    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        baseComponent = DaggerBaseComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public BaseComponent getBaseComponent(){
        return baseComponent;
    }

    public static MyApp getMyApp(){
        return myApp;
    }
}