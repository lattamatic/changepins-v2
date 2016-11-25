package com.example.sandeep.changepins;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class FragStoryAdapter extends FragmentStatePagerAdapter {

    public FragStoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new StoriesFragment();
        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }
}