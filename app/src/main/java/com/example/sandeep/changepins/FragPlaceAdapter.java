package com.example.sandeep.changepins;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class FragPlaceAdapter extends FragmentStatePagerAdapter {

    public FragPlaceAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PlacesFragment();
        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }
}