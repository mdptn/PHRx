package com.example.symphony.phrx;

/**
 * Created by Megan on 8/10/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;


public class TabAdapter extends FragmentStatePagerAdapter {

    public TabAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int index){
        // returns the fragment that is associated with the position
        switch(index){
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();
            case 4:
                return new Tab5();
            case 5:
                return new Tab6();
            default:
                return null;
        }
    }

    public int getCount(){
        // returns the number of tabs
        return 6;
    }
}
