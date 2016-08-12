package com.example.symphony.phrx;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.PersonalHealth;

/**
 * Created by Megan on 8/11/2016.
 */

// helps put the List Array into the ListView


public class PHArrayAdapter extends ArrayAdapter<PersonalHealth>{

    public PHArrayAdapter(Context context, List<PersonalHealth> phl){
        super(context, 0, phl);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        PersonalHealth ph = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.healthinfo, parent, false);
        }

        TextView weight = (TextView) view.findViewById(R.id.textWeight);
        TextView height = (TextView) view.findViewById(R.id.textHeight);
        TextView systolic = (TextView) view.findViewById(R.id.textSys);
        TextView diastolic = (TextView) view.findViewById(R.id.textDia);
        TextView heartrate = (TextView) view.findViewById(R.id.textHR);

        // convert weight and height to string to use for setText
        String w = String.valueOf(ph.getWeight());
        String h = String.valueOf(ph.getHeight());

        weight.setText("Weight: " + w);
        height.setText("Height: " + h);
        systolic.setText("Systolic Blood Pressure: " + ph.getSystolic());
        diastolic.setText("Diastolic Blood Pressure: " + ph.getDiastolic());
        heartrate.setText("Heart Rate: " + ph.getHeartRate());
        view.setId(ph.getId());

        return view;


    }
}
