package com.example.sandeep.changepins.FbLoginPackage;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.sandeep.changepins.MainActivity;
import com.example.sandeep.changepins.R;
import com.facebook.Profile;

/**
 * Created by sandeep on 9/11/16.
 */

public class FbLoginActivity extends AppCompatActivity implements FbLoginFragment.MyFbLoginInterface {

    FbLoginFragment fbFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_fb_login);

        fbFragment = new FbLoginFragment();

        FragmentTransaction fragTrans = getFragmentManager().beginTransaction().add(R.id.loginFrame,fbFragment);
        fragTrans.commit();
    }

    @Override
    public void onLoggedIn(Profile profile) {
        Intent i = new Intent(this, MainActivity.class);
        Bundle userDetails = new Bundle();
        userDetails.putString("name", profile.getName());
        userDetails.putString("uid", profile.getId());
        Log.d("image",profile.getProfilePictureUri(100,100).toString());
        userDetails.putString("image",profile.getProfilePictureUri(100,100).toString());
        i.putExtras(userDetails);
        startActivity(i);
        finish();
    }

    @Override
    public void onFailedLogin() {
        Toast.makeText(this,"There was an error while login. Try again", Toast.LENGTH_SHORT).show();
    }


}
