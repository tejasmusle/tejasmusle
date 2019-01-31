package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class welcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mtoggle;
    private TextView textView;
    private Toolbar toolbar;
    private View mheadview;
    private TextView chat, call, camera;
    private ViewPager viewPager;
    private PagerViewAdapter pagerViewAdapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mdrawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mtoggle = new ActionBarDrawerToggle(welcome.this, mdrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mdrawer.addDrawerListener(mtoggle);
        mtoggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));
        mtoggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        NavigationView navigationView = findViewById(R.id.nav_views);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();

            navigationView.setCheckedItem(R.id.nav_profile);
        }

        mheadview = navigationView.getHeaderView(0);
        textView = mheadview.findViewById(R.id.user_name);
        String usr = getIntent().getExtras().get("username").toString();
        textView.setText(usr);

       // Starting the tab part -->
       //   ----->
//
//        tabBar();
//        chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(1);
//            }
//        });
//        call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(2);
//            }
//        });
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(3);
//            }
//        });
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_profile:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
                Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_mail:
                Toast.makeText(getApplicationContext(), "mail", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contact:
                Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.send:
                Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_SHORT).show();
                break;
        }
        mdrawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void tabBar() {
//        chat = findViewById(R.id.chat);
//        call = findViewById(R.id.call_logs);
//        camera = findViewById(R.id.camera);
//        viewPager = findViewById(R.id.fragment_container2);
//        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(pagerViewAdapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//               // onChangeTab(i);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//

  //  }

//    private void onChangeTab(int i) {
//        if (i == 0) {
//            chat.setTextSize(20);
//            chat.setTextColor(getColor(R.color.brightColor));
//
//            call.setTextSize(20);
//            call.setTextColor(getColor(R.color.lightColor));
//
//            camera.setTextSize(20);
//            camera.setTextColor(getColor(R.color.lightColor));
//        }
//        if (i == 1) {
//            chat.setTextSize(20);
//            chat.setTextColor(getColor(R.color.lightColor));
//
//            call.setTextSize(20);
//            call.setTextColor(getColor(R.color.brightColor));
//
//            camera.setTextSize(20);
//            camera.setTextColor(getColor(R.color.lightColor));
//        }
//        if (i == 2) {
//            chat.setTextSize(20);
//            chat.setTextColor(getColor(R.color.lightColor));
//
//            call.setTextSize(20);
//            call.setTextColor(getColor(R.color.lightColor));
//
//            camera.setTextSize(20);
//            camera.setTextColor(getColor(R.color.brightColor));
//
//        }
//
//
//    }


}
