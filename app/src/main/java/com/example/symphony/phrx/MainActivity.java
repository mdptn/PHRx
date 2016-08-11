package com.example.symphony.phrx;

import android.app.Activity;
import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



// used this tutorial to help with creating tab navigation:
// http://javarticles.com/2015/09/android-sliding-tab-layout-example.html

public class MainActivity extends FragmentActivity{

    private ViewPager vp;
    private TabAdapter ta;
    private Tab_Layout tl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.viewpager_main);
        tl = (Tab_Layout) findViewById(R.id.tab_layout);

        ta = new TabAdapter(getSupportFragmentManager());
        vp.setAdapter(ta);

        // create tabs method
        tl.createTabs();

        tl.setOnTabSelectedListener(new Tab_Layout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }


}
