package com.example.chandan.weatherappintermediate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chandan on 22-06-2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    Context c;

    public FragmentAdapter(FragmentManager fm,Context c) {
        super(fm);
        this.c=c;

        Log.d("Inside frgadptrcons","context is"+c.toString());
    }




    @Override
    public Fragment getItem(int position) {
       Fragment fragment=null;
        if(position==0)
        {
            Log.d("Inside frgadapter","1pagereturning");

            fragment=new MainPage();
        }
        if(position==1)
        {
            Log.d("Inside frgadapter","2pagereturning");
            fragment=new WeatherInfo();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
