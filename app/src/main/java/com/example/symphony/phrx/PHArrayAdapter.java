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
        String s = String.valueOf(ph.getSystolic());
        String d = String.valueOf(ph.getDiastolic());
        String r = String.valueOf(ph.getHeartRate());
        String blank = "";
        String zero = "0";
        String zerop = "0.0";

        // if weight was left completely blank, it is not shown in listview.
        if (!w.equals(blank)&& !w.equals(zero) && !w.equals(zerop)) {
            weight.setVisibility(View.VISIBLE);
            weight.setText("Weight: " + w + " " + ph.getWeightUnit());
        } else{
            weight.setVisibility(View.GONE);
        }

        // if height was left completely blank, it is not shown in listview.
        if (!h.equals(blank)&& !h.equals(zero) && !h.equals(zerop)) {
            height.setVisibility(View.VISIBLE);
            height.setText("Height: " + h + " " + ph.getHeightUnit());
        } else{
            height.setVisibility(View.GONE);
        }

        // if bp was left completely blank, it is not shown in listview.
        if (!s.equals(blank)&& !s.equals(zero) && !s.equals(zerop)) {
            blood.setVisibility(View.VISIBLE);
            blood.setText("Blood Pressure: " + ph.getSystolic() + "/" + ph.getDiastolic() + " mm Hg");
        } else{
            blood.setVisibility(View.GONE);
        }

        // if hr was left completely blank, it is not shown in listview.
        if (!r.equals(blank)&& !r.equals(zero) && !r.equals(zerop)) {
            heartrate.setVisibility(View.VISIBLE);
            heartrate.setText("Heart Rate: " + ph.getHeartRate() + " bpm");
        } else{
            heartrate.setVisibility(View.GONE);
        }

        view.setId(ph.getId());

        return view;


    }
}
