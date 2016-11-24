package com.example.sandeep.changepins;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by sandeep on 24/11/16.
 */

public class StoryFragment extends Fragment implements SelectDialog.SDInterface{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_story,container,false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectDialog sd = new SelectDialog();
                sd.setTargetFragment(StoryFragment.this,0);
                sd.show(getFragmentManager(),"Select Dialog");
            }
        });
        return view;
    }


    //Select Action Dialog methods
    @Override
    public void onClickPlace() {
        Toast.makeText(getActivity(),"Place",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickCampaign() {
        Toast.makeText(getActivity(),"Campaign",Toast.LENGTH_SHORT).show();

    }
}
