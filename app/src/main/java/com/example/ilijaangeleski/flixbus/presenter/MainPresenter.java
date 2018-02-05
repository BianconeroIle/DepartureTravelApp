package com.example.ilijaangeleski.flixbus.presenter;

import com.example.ilijaangeleski.flixbus.callback.DepartureCallback;
import com.example.ilijaangeleski.flixbus.manager.MainManager;
import com.example.ilijaangeleski.flixbus.model.Departures;
import com.example.ilijaangeleski.flixbus.model.DeparturesResults;
import com.example.ilijaangeleski.flixbus.view.MainView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class MainPresenter {
    private MainManager manager;
    private WeakReference<MainView> mainViewWeakReference;
    private List<Departures> departures = new ArrayList<>();

    public MainPresenter(MainManager manager, WeakReference<MainView> view) {
        this.manager = manager;
        this.mainViewWeakReference = view;
    }

    public void fetchDepartures() {
        manager.fetchDepartures(new DepartureCallback() {
            @Override
            public void onSuccess(DeparturesResults response) {
                MainView view = mainViewWeakReference.get();
                if (view != null) {
                    if (response != null &&
                            response.getTimeTable().getDepartures() != null &&
                            !response.getTimeTable().getDepartures().isEmpty()) {
                        departures.addAll(response.getTimeTable().getDepartures());
                        view.notifyChange();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                MainView view = mainViewWeakReference.get();
                if (view != null) {
                    view.showErrorGettingDataFromServer();
                }
            }
        });
    }

    public List<Departures> getDepartures() {
        return departures;
    }
}
