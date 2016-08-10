package com.example.symphony.phrx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


// used this tutorial to help with creating tab navigation:
// http://www.viralandroid.com/2015/09/android-actionbar-tabs-example.html

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Displays the tabs in the action bar
        ab.addTab(ab.newTab().setText("Tab 1").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 2").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 3").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 4").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 5").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 6").setTabListener(this));
    }


    // when a tab is selected :
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        int nTabSelected = tab.getPosition();
        switch (nTabSelected) {
            // cases are determined when a particular tab is selected in order to show the
            // corresponding view
            case 0:
                setContentView(R.layout.actionbar_tab_1);
                break;
            case 1:
                setContentView(R.layout.actionbar_tab_2);
                break;
            case 2:
                setContentView(R.layout.actionbar_tab_3);
                break;
            case 3:
                setContentView(R.layout.actionbar_tab_4);
                break;
            case 4:
                setContentView(R.layout.actionbar_tab_5);
                break;
            case 5:
                setContentView(R.layout.actionbar_tab_6);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Called when a tab unselected.
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        // Called when a tab is selected again.
    }

    // not using this yet
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
