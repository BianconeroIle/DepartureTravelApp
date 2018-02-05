package com.example.ilijaangeleski.flixbus.di;

import com.example.ilijaangeleski.flixbus.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */
@Component(modules = MainActivityModule.class, dependencies = BaseComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
