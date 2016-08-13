package com.example.symphony.phrx;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


// used this tutorial to help with creating tab navigation:
// http://javarticles.com/2015/09/android-sliding-tab-layout-example.html

public class MainActivity extends AppCompatActivity{

    public static int phId;
    public static int mId;
    public static int iId;
    public static int aId;
    public static int cId;
    private ViewPager vp;
    private TabAdapter ta;
    private Tab_Layout tl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.viewpager_main);
        tl = (Tab_Layout) findViewById(R.id.tab_layout);

        FragmentManager fragm = getSupportFragmentManager();
        TabAdapter taba = new TabAdapter(fragm);
        vp.setAdapter(taba);

        tl.setupWithViewPager(vp);
        vp.addOnPageChangeListener(new Tab_Layout.TabLayoutOnPageChangeListener(tl));
        //tl.setTabsFromPagerAdapter(taba);

        //set tab icons
        tl.getTabAt(0).setIcon(R.drawable.hometab);
        tl.getTabAt(1).setIcon(R.drawable.personaltab);
        tl.getTabAt(2).setIcon(R.drawable.medictab);
        tl.getTabAt(3).setIcon(R.drawable.immunetab);
        tl.getTabAt(4).setIcon(R.drawable.allergytab);
        tl.getTabAt(5).setIcon(R.drawable.conditiontab);


        tl.addOnTabSelectedListener(new Tab_Layout.OnTabSelectedListener(){
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


    // onClick for NEW RECORD buttons
    public void onClickNewRecord1Button(View v){
        Intent intent = new Intent(MainActivity.this, PHformActivity.class);
        startActivity(intent);
    }


    public void onClickNewRecord2Button(View v){
        Intent intent = new Intent(v.getContext(), MedFormActivity.class);
        startActivity(intent);

    }

    public void onClickNewRecord3Button(View v){
        Intent intent = new Intent(v.getContext(), ImmFormActivity.class);
        startActivity(intent);

    }

    public void onClickNewRecord4Button(View v){
        Intent intent = new Intent(v.getContext(), AllergyFormActivity.class);
        startActivity(intent);

    }

    public void onClickNewRecord5Button(View v){
        Intent intent = new Intent(v.getContext(), ConditionFormActivity.class);
        startActivity(intent);

    }

    // onClick for editing records
    public void onClickEdit1(View v) {
        phId = v.getId();
        Intent intent = new Intent(MainActivity.this, EditPHActivity.class);
        startActivity(intent);
    }

    public void onClickEdit2(View v) {
        mId = v.getId();
        Intent intent = new Intent(MainActivity.this, EditMedActivity.class);
        startActivity(intent);
    }

    public void onClickEdit3(View v) {
        iId = v.getId();
        Intent intent = new Intent(MainActivity.this, EditImmActivity.class);
        startActivity(intent);
    }

    public void onClickEdit4(View v) {
        aId = v.getId();
        Intent intent = new Intent(MainActivity.this, EditAllergyActivity.class);
        startActivity(intent);
    }

    public void onClickEdit5(View v) {
        cId = v.getId();
        Intent intent = new Intent(MainActivity.this, EditConditionActivity.class);
        startActivity(intent);
    }



}
