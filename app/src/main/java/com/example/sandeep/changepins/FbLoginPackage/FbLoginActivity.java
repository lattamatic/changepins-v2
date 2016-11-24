package com.example.sandeep.changepins.FbLoginPackage;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sandeep.changepins.MainActivity;
import com.example.sandeep.changepins.R;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sandeep on 9/11/16.
 */

public class FbLoginActivity extends AppCompatActivity implements FbLoginFragment.MyFbLoginInterface {

    FbLoginFragment fbFragment;
    ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_fb_login);

        fbFragment = new FbLoginFragment();

        FragmentTransaction fragTrans = getFragmentManager().beginTransaction().add(R.id.loginFrame, fbFragment);
        fragTrans.commit();

        pb = (ProgressBar) findViewById(R.id.pbDpLoading);
    }

    @Override
    public void onLoggedIn(Profile profile) {

        if (profile == null) { //User logged out comes here

        } else { //user logged in comes here

            GraphRequest request = GraphRequest.newMeRequest(
                    AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            Log.v("LoginActivity", response.toString());

                            String email = null,gender = null, dpUrl = null, name = null;

                            // Application code
                            try {
                               email = object.getString("email");
                               gender = object.getString("gender");
                               dpUrl = object.getJSONObject("picture").getJSONObject("data").getString("url");
                               name = object.getString("name");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            DpAsyncTask dpAsyncTask = new DpAsyncTask();
                            dpAsyncTask.execute(email,gender, dpUrl,name);
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "picture.width(80).height(80),email,name,gender");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }

    @Override
    public void onFailedLogin() {
        Toast.makeText(this, "There was an error while login. Try again", Toast.LENGTH_SHORT).show();
    }


    class DpAsyncTask extends AsyncTask<String, Void, Bitmap> {

        Intent i = new Intent(FbLoginActivity.this, MainActivity.class);
        Bundle userDetails = new Bundle();

        @Override
        protected void onPreExecute() {
            if (pb.getVisibility() == View.INVISIBLE) {
                pb.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            userDetails.putString("email",params[0]);
            userDetails.putString("gender", params[1]);
            userDetails.putString("dpUrl", params[2]);
            userDetails.putString("name",params[3]);

            URL dpurl = null;
            try {
                dpurl = new URL(params[2]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Bitmap bmp = null;
            try {
                bmp = BitmapFactory.decodeStream(dpurl.openConnection().getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bmp) {
            i.putExtras(userDetails);
            i.putExtra("image",bmp);
            startActivity(i);
            finish();
        }
    }
}