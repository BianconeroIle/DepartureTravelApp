package com.example.ilijaangeleski.flixbus.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ilijaangeleski.flixbus.MyApp;
import com.example.ilijaangeleski.flixbus.R;
import com.example.ilijaangeleski.flixbus.adapter.DeparturesRecyclerViewAdapter;
import com.example.ilijaangeleski.flixbus.di.DaggerMainActivityComponent;
import com.example.ilijaangeleski.flixbus.di.MainActivityModule;
import com.example.ilijaangeleski.flixbus.presenter.MainPresenter;
import com.example.ilijaangeleski.flixbus.view.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.routeRecyclerView)
    RecyclerView routeRecyclerView;
    @Inject
    MainPresenter presenter;
    private DeparturesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createDependencies();
        initView();
        presenter.fetchDepartures();

    }

    private void initView() {
        adapter = new DeparturesRecyclerViewAdapter(presenter.getDepartures());
        routeRecyclerView.setAdapter(adapter);
    }

    private void createDependencies() {
        DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new MainActivityModule(this))
                .baseComponent(MyApp.getMyApp().getBaseComponent())
                .build()
                .inject(this);
    }

    @Override
    public void notifyChange() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorGettingDataFromServer() {
        Toast.makeText(this, R.string.show_error_getting_data, Toast.LENGTH_LONG).show();
    }
}
