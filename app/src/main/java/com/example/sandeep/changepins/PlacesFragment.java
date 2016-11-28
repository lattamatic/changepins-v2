package com.example.sandeep.changepins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sandeep_chi on 11/25/2016.
 */
public class PlacesFragment extends Fragment {
    RecyclerView rcvPlaces;
    RecyclerView.Adapter rcvAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Place> placesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_stories,container,false);
        rcvPlaces = (RecyclerView) view.findViewById(R.id.rcv_stories);

        layoutManager = new LinearLayoutManager(getActivity());
        rcvPlaces.setLayoutManager(layoutManager);

        rcvAdapter = new RCVPlaceAdapter(getActivity(),placesList);
        rcvPlaces.setAdapter(rcvAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        placesList = new ArrayList<Place>();
        for(int i=1;i<6;i++){
            placesList.add(new Place("ACTION " + i,i + ":00 PM"));
        }
    }
}
