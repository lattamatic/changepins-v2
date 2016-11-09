package com.example.sandeep.changepins;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandeep on 9/11/16.
 */

public class FbLoginActivity extends AppCompatActivity {

    FbLoginFragment fbFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_fb_login);

        fbFragment = new FbLoginFragment();

        FragmentTransaction fragTrans = getFragmentManager().beginTransaction().add(R.id.loginLayout,fbFragment);
        fragTrans.commit();
    }
}
