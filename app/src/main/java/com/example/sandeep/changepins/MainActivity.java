package com.example.sandeep.changepins;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Getting profile details and publishing
        Bundle extras = getIntent().getExtras();
//        TextView textView = (TextView) findViewById(R.id.tvUserDetails);
//        String string =  extras.getString("name") + " " + extras.getString("uid");
//        textView.setText(string);
        View headerLayout =
                navigationView.inflateHeaderView(R.layout.nav_header_main);
        ImageView profilepic = (ImageView) headerLayout.findViewById(R.id.ivProfilePic);
        TextView profileName = (TextView) headerLayout.findViewById(R.id.tvProfileName);
        TextView profileEmail = (TextView) headerLayout.findViewById(R.id.tvProfileEmail);

        profilepic.setImageBitmap((Bitmap) getIntent().getParcelableExtra("image"));
        profileName.setText(extras.getString("name"));
        profileEmail.setText(extras.getString("email"));


        //Adding Stories fragment
        StoryFragment storyFragment = new StoryFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.flStory,storyFragment,"Story Fragment");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notifications) {
            return true;
        }

        if(id==R.id.action_report){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_places) {
            // Handle the camera action
        } else if (id == R.id.nav_aboutus) {
            startActivity(new Intent(this,AboutUsAcitivity.class));
        } else if (id == R.id.nav_contactus) {
            startActivity(new Intent(this,ContactUsActivity.class));
        } else if (id == R.id.nav_logout) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_invite) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
