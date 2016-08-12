package com.example.symphony.phrx;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Medication;
import com.example.symphony.phrx.db_classes.PersonalHealth;

/**
 * Created by Megan on 8/11/2016.
 */

// helps put the List Array into the ListView


public class MedArrayAdapter extends ArrayAdapter<Medication>{

    public MedArrayAdapter(Context context, List<Medication> med){
        super(context, 0, med);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Medication m = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.medinfo, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.textName);
        TextView dose = (TextView) view.findViewById(R.id.textDose);
        TextView dose_unit = (TextView) view.findViewById(R.id.textDoseUnit);
        TextView dosage = (TextView) view.findViewById(R.id.textDosage);
        TextView dosage_unit = (TextView) view.findViewById(R.id.textDosageUnit);
        TextView frequency = (TextView) view.findViewById(R.id.textFrequency);
        TextView frequency_int = (TextView) view.findViewById(R.id.textFrequencyInt);
        TextView administration = (TextView) view.findViewById(R.id.textAdmin);
        TextView reason = (TextView) view.findViewById(R.id.textReason);

        // convert weight and height to string to use for setText
        String d = String.valueOf(m.getDose());
        String d2 = String.valueOf(m.getDosage());
        String f = String.valueOf(m.getFrequency());

        name.setText("Name: " + m.getName());
        dose.setText("Dose: " + d);
        dose_unit.setText("Dose Unit: " + m.getDoseUnit());
        dosage.setText("Dosage: " + d2);
        dosage_unit.setText("Dosage Unit: " + m.getDosageUnit());
        frequency.setText("Frequency: " + f);
        frequency_int.setText("Frequency Interval: " + m.getFrequencyInterval());
        administration.setText("Route of Administration: " + m.getAdministration());
        reason.setText("Reason for Taking: " + m.getReason());

        view.setId(m.getId());

        return view;


    }
}
