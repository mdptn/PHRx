package com.example.symphony.phrx;

/**
 * Created by Megan on 8/10/2016.
 */

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;


import com.example.symphony.phrx.db_classes.Allergy;


public class Tab5 extends Fragment{

    DatabaseHandler dh;
    List<Allergy> a;

    public Tab5() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        dh = new DatabaseHandler(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.actionbar_tab_5, container, false);
        return rootView;

    }

    public void onResume() {
        super.onResume();
        displayAllergy();
    }

    public void displayAllergy(){
        a = dh.getAllAlergy();
        ListView listview = (ListView) getView().findViewById(R.id.allergy_list);
        AllergyArrayAdapter ad = new AllergyArrayAdapter(getActivity(), a);
        listview.setAdapter(ad);
    }



}

