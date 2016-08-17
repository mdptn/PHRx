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
        TextView blood = (TextView) view.findViewById(R.id.textBlood);
        TextView heartrate = (TextView) view.findViewById(R.id.textHR);

        // convert weight and height to string to use for setText
        String w = String.valueOf(ph.getWeight());
        String h = String.valueOf(ph.getHeight());

        weight.setText("Weight: " + w + " " + ph.getWeightUnit());
        height.setText("Height: " + h + " " + ph.getHeightUnit());
        blood.setText("Blood Pressure: " + ph.getSystolic() + "/" + ph.getDiastolic() + " mm Hg");
        heartrate.setText("Heart Rate: " + ph.getHeartRate() + " bpm");
        view.setId(ph.getId());

        return view;


    }
}
