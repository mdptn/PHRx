package com.example.symphony.phrx;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Allergy;

/**
 * Created by Megan on 8/12/2016.
 */

// helps put the List Array into the ListView


public class AllergyArrayAdapter extends ArrayAdapter<Allergy>{

    public AllergyArrayAdapter(Context context, List<Allergy> a){
        super(context, 0, a);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Allergy a = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.allergyinfo, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.textName);
        TextView symptom = (TextView) view.findViewById(R.id.textSymptom);
        TextView meds = (TextView) view.findViewById(R.id.textMed);


        name.setText("Name: " + a.getName());
        symptom.setText("Date: " + a.getSymptom());
        meds.setText("Dose: " + a.getMedication());

        view.setId(a.getId());

        return view;


    }
}
