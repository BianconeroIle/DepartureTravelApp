package com.example.ilijaangeleski.flixbus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilijaangeleski.flixbus.R;
import com.example.ilijaangeleski.flixbus.model.Departures;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 2/1/2018.
 */

public class DeparturesRecyclerViewAdapter extends RecyclerView.Adapter<DeparturesRecyclerViewAdapter.MyViewHolder> {
    private List<Departures> items;
    private String simpleDateFormat;

    public DeparturesRecyclerViewAdapter(List<Departures> items) {
        this.items = items;
    }

    @Override
    public DeparturesRecyclerViewAdapter.MyViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_travel_description, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DeparturesRecyclerViewAdapter.MyViewHolder holder, int position) {
        final Departures current = items.get(position);
        holder.direction.setText(current.getDirection());
        holder.lineNumber.setText(current.getLine_code());
        simpleDateFormat = new SimpleDateFormat("HH:mm")
                .format(new Date(current.getDateTime().getTimestamp()));
        holder.departureTime.setText(simpleDateFormat);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.direction)
        TextView direction;
        @BindView(R.id.lineNumber)
        TextView lineNumber;
        @BindView(R.id.departureTime)
        TextView departureTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
