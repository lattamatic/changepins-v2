package com.example.sandeep.changepins;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandeep on 24/11/16.
 */
public class NotificationsActivity extends ChangePinsActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getTitleText() {
        return R.string.notifications;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_notifications;
    }
}
