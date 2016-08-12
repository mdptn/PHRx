package com.example.symphony.phrx;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Immunization;

/**
 * Created by Megan on 8/11/2016.
 */

// helps put the List Array into the ListView


public class ImmArrayAdapter extends ArrayAdapter<Immunization>{

    public ImmArrayAdapter(Context context, List<Immunization> imm){
        super(context, 0, imm);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Immunization imm = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.immuneinfo, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.textName);
        TextView date = (TextView) view.findViewById(R.id.textDate);
        TextView dose = (TextView) view.findViewById(R.id.textDose);


        name.setText("Name: " + imm.getName());
        date.setText("Date: " + imm.getDate());
        dose.setText("Dose: " + imm.getDose());

        view.setId(imm.getId());

        return view;


    }
}
