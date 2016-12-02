package com.example.sandeep.changepins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class PlacesActivity extends ChangePinsActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabPlaces);
        ViewPager storyPager = (ViewPager) findViewById(R.id.pagerPlaces);

        tabLayout.setupWithViewPager(storyPager);
        tabLayout.getTabAt(0).setText("HISTORY");
        tabLayout.getTabAt(1).setText("PLACES");

        FragPlaceAdapter adapter = new FragPlaceAdapter(getSupportFragmentManager());
        storyPager.setAdapter(adapter);

    }

    @Override
    protected int getTitleText() {
        return R.string.places;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_places;
    }
}
