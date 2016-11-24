package com.example.sandeep.changepins;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SelectDialog.SDInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabStories);
        final ViewPager storyPager = (ViewPager) findViewById(R.id.pagerStories);

        tabLayout.setupWithViewPager(storyPager);
        tabLayout.getTabAt(0).setText("MY LIST");
        tabLayout.getTabAt(1).setText("RECOMMENDED");

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        storyPager.setAdapter(adapter);
        storyPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                storyPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectDialog sd = new SelectDialog();
                sd.show(getFragmentManager(),"Select Dialog");
            }
        });

        //Getting profile details and publishing
        Bundle extras = getIntent().getExtras();
        View headerLayout =
                navigationView.inflateHeaderView(R.layout.nav_header_main);
        ImageView profilepic = (ImageView) headerLayout.findViewById(R.id.ivProfilePic);
        TextView profileName = (TextView) headerLayout.findViewById(R.id.tvProfileName);
        TextView profileEmail = (TextView) headerLayout.findViewById(R.id.tvProfileEmail);

        profilepic.setImageBitmap((Bitmap) getIntent().getParcelableExtra("image"));
        profileName.setText(extras.getString("name"));
        profileEmail.setText(extras.getString("email"));
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

        } else if (id == R.id.nav_invite) {
            startActivity(new Intent(this,InviteFriendsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClickPlace() {
        Toast.makeText(this,"Place",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickCampaign() {
        Toast.makeText(this,"Place",Toast.LENGTH_SHORT).show();
    }

    public class FragAdapter extends FragmentStatePagerAdapter{

        public FragAdapter(FragmentManager fm) {
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
}
