package com.example.sandeep.changepins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sandeep on 24/11/16.
 */

public class ContactUsActivity extends ChangePinsActivity {

    ImageView back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getTitleText() {
        return R.string.contact_us;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_contactus;
    }
}
