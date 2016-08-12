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


import com.example.symphony.phrx.db_classes.PersonalHealth;


public class Tab2 extends Fragment{

    DatabaseHandler dh;
    List<PersonalHealth> phl;

    public Tab2() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        dh = new DatabaseHandler(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.actionbar_tab_2, container, false);
        return rootView;

    }

    public void onResume() {
        super.onResume();
        displayPH();
    }

    public void displayPH(){
        phl = dh.getAllPersonalHealth();
        ListView listview = (ListView) getView().findViewById(R.id.health_list);
        PHArrayAdapter ad = new PHArrayAdapter(getActivity(), phl);
        listview.setAdapter(ad);
    }

    public void onClickNewRecordButton(View v){
        Intent intent = new Intent(v.getContext(), PHformActivity.class);
        startActivity(intent);

    }


}

