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
 * Created by sandeep on 25/11/16.
 */

public class StoriesFragment extends Fragment {

    RecyclerView rcvStories;
    RecyclerView.Adapter rcvAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Story> storyList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_stories,container,false);
        rcvStories = (RecyclerView) view.findViewById(R.id.rcv_stories);

        layoutManager = new LinearLayoutManager(getActivity());
        rcvStories.setLayoutManager(layoutManager);

        rcvAdapter = new RCVStoryAdapter(getActivity(),storyList);
        rcvStories.setAdapter(rcvAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Testing purpose written code..to be removed
        storyList = new ArrayList<Story>();
        for(int i=1;i<20;i++){
            if(i==1||i==5||i==10||i==16){
                storyList.add(new Story("Sai Tejo Kiran",i%2, "Cleanup Inside IIT Madras Campus on Sunday", "This is the content for story " + i + ". Kindly note that this story is of type " + i%2));
            }else{
                storyList.add(new Story("User "+i,i%2, "Title "+ i, "This is the content for story " + i + ". Kindly note that this story is of type " + i%2));
            }
        }
    }
}

