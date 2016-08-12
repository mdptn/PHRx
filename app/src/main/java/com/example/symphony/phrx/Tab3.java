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


import com.example.symphony.phrx.db_classes.Medication;


public class Tab3 extends Fragment{

    DatabaseHandler dh;
    List<Medication> med;

    public Tab3() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        dh = new DatabaseHandler(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.actionbar_tab_3, container, false);
        return rootView;

    }

    public void onResume() {
        super.onResume();
        displayMed();
    }

    public void displayMed(){
        med = dh.getAllMedication();
        ListView listview = (ListView) getView().findViewById(R.id.medic_list);
        MedArrayAdapter ad = new MedArrayAdapter(getActivity(), med);
        listview.setAdapter(ad);
    }


}

