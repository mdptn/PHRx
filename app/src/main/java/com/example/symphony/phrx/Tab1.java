package com.example.symphony.phrx;

/**
 * Created by Megan on 8/10/2016.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Allergy;
import com.example.symphony.phrx.db_classes.Condition;
import com.example.symphony.phrx.db_classes.Immunization;
import com.example.symphony.phrx.db_classes.Medication;
import com.example.symphony.phrx.db_classes.PersonalHealth;

import java.util.List;


public class Tab1 extends Fragment{
    DatabaseHandler dh;
    List<PersonalHealth> phl;
    List<Medication> ml;
    List<Immunization> il;
    List<Allergy> al;
    List<Condition> cl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.actionbar_tab_1, container, false);
        return rootView;

    }

    public void onResume() {
        super.onResume();
        displaySummary();
    }

    public void displaySummary(){
        ListView listview = (ListView) getView().findViewById(R.id.summary_list);
        listview.setEmptyView(getView().findViewById(R.id.prompt));
    }

}
