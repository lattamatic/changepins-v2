package com.example.sandeep.changepins.FbLoginPackage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeep.changepins.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by sandeep on 9/11/16.
 */

public class FbLoginFragment extends Fragment {

    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    AccessToken accessToken;
    Profile profile;
    MyFbLoginInterface myFbLoginInterface;

    interface MyFbLoginInterface{
        void onLoggedIn(Profile profile);
        void onFailedLogin();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                profile = currentProfile;
                myFbLoginInterface.onLoggedIn(profile);
            }
        };

        accessToken = AccessToken.getCurrentAccessToken();
        myFbLoginInterface = (MyFbLoginInterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_fb_login,container,false);

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setFragment(this);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email", "user_birthday"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.d("FB","Success");
                myFbLoginInterface.onLoggedIn(profile);

            }

            @Override
            public void onCancel() {
                // App code
                Log.d("FB","Cancel");
                myFbLoginInterface.onFailedLogin();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d("FB",exception.toString());
                myFbLoginInterface.onFailedLogin();
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }
}
