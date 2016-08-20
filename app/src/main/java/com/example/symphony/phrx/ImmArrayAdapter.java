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

        String n = imm.getName();
        String da = imm.getDate();
        String d = String.valueOf(imm.getDose());
        String du = imm.getDoseUnit();
        String blank = "";
        String zerop = "0.0";
        String zero = "0";

        // if date was left completely blank, it is not shown in listview.
        if (!da.equals(blank)&& !da.equals(zero) && !da.equals(zerop)) {
            date.setVisibility(View.VISIBLE);
            date.setText("Date: " + imm.getDate());
        } else{
            date.setVisibility(View.GONE);
        }

        // if dose was left completely blank, it is not shown in listview.
        if (!d.equals(blank)&& !d.equals(zero) && !d.equals(zerop)) {
            dose.setVisibility(View.VISIBLE);
            dose.setText("Dose: " + imm.getDose() + " " + imm.getDoseUnit());
        } else{
            dose.setVisibility(View.GONE);
        }


        name.setText("Name: " + imm.getName());

        view.setId(imm.getId());

        return view;


    }
}
