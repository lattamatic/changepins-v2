package com.example.sandeep.changepins;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class RCVPlaceAdapter extends RecyclerView.Adapter<RCVPlaceAdapter.ViewHolder> {

    Context context;
    ArrayList<Place> placesList;

    public RCVPlaceAdapter(Context context, ArrayList<Place> placesList) {
        this.context = context;
        this.placesList = placesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView action, time;

        public ViewHolder(View itemView) {
            super(itemView);
            action = (TextView) itemView.findViewById(R.id.tvCardAction);
            time = (TextView) itemView.findViewById(R.id.tvCardTime);
        }
    }

    @Override
    public RCVPlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_place, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RCVPlaceAdapter.ViewHolder holder, final int position) {
        holder.action.setText(placesList.get(position).getAction());
        holder.time.setText(placesList.get(position).getTime());
        }

    @Override
    public int getItemCount() {
        return 5;
    }
}