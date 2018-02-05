package com.example.ilijaangeleski.flixbus.di;

import com.example.ilijaangeleski.flixbus.api.NetworkApi;
import com.example.ilijaangeleski.flixbus.manager.MainManager;
import com.example.ilijaangeleski.flixbus.presenter.MainPresenter;
import com.example.ilijaangeleski.flixbus.view.MainView;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */
@Module
public class MainActivityModule {
    WeakReference<MainView> view;

    public MainActivityModule(MainView view) {
        this.view = new WeakReference<>(view);
    }

    @Provides
    MainPresenter provideMainPresenter(MainManager mainManager) {
        return new MainPresenter(mainManager, view);
    }

    @Provides
    MainManager provideMainManager(NetworkApi networkApi) {
        return new MainManager(networkApi);
    }
}
