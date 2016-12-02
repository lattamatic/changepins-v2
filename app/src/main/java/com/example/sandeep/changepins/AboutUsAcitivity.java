package com.example.sandeep.changepins;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandeep on 24/11/16.
 */

public class AboutUsAcitivity extends ChangePinsActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getTitleText() {
        return R.string.about_us;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_aboutus;
    }
}
