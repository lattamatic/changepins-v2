package com.example.sandeep.changepins;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandeep on 24/11/16.
 */

public class InviteFriendsActivity extends ChangePinsActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getTitleText() {
        return R.string.invite_friends;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_invite_friends;
    }
}
