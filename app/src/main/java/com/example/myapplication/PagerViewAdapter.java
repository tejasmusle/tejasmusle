package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

      Fragment fragment=null;
      switch (i){
          case 1:
              fragment=new fragmentchat();
              break;
          case 2:
              fragment=new fragmentcalllogs();
              break;
         case 3:
              fragment=new fragmentcamera();
             break;

      }


        return fragment;
      }

    @Override
    public int getCount() {
        return 3;
    }
}
