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
        TextView dosage = (TextView) view.findViewById(R.id.textDosage);
        TextView frequency = (TextView) view.findViewById(R.id.textFrequency);
        TextView administration = (TextView) view.findViewById(R.id.textAdmin);
        TextView reason = (TextView) view.findViewById(R.id.textReason);

        // convert to string to use for setText
        String n = m.getName();
        String d = String.valueOf(m.getDose());
        String du = m.getDoseUnit();
        String d2 = String.valueOf(m.getDosage());
        String d2u = m.getDosageUnit();
        String f = String.valueOf(m.getFrequency());
        String fi = m.getFrequencyInterval();
        String a = m.getAdministration();
        String r = m.getReason();
        String blank = "";
        String zero = "0";
        String zerop = "0.0";


        // if dose & dose unit were left completely blank, it is not shown in listview.
        if (!d.equals(blank)&& !d.equals(zero) && !d.equals(zerop)&&
                !du.equals(blank)&& !du.equals(zero) && !du.equals(zerop)) {
            dose.setVisibility(View.VISIBLE);
            dose.setText("Dose: " + d + " " + du);
        } else{
            dose.setVisibility(View.GONE);
        }

        // if dosage & dosage unit were left completely blank, it is not shown in listview.
        if (!d2.equals(blank)&& !d2.equals(zero) && !d2.equals(zerop)&&
                !d2u.equals(blank)&& !d2u.equals(zero) && !d2u.equals(zerop)) {
            dosage.setVisibility(View.VISIBLE);
            dosage.setText("Dosage: " + d2 + " " + d2u);
        } else{
            dosage.setVisibility(View.GONE);
        }

        // if frequency & interval unit were left completely blank, it is not shown in listview.
        if (!f.equals(blank)&& !f.equals(zero) && !f.equals(zerop)&&
                !fi.equals(blank)&& !fi.equals(zero) && !fi.equals(zerop)) {
            frequency.setVisibility(View.VISIBLE);
            frequency.setText("Frequency: " + f + "/" + fi);
        } else{
            frequency.setVisibility(View.GONE);
        }

        // if administration was left completely blank, it is not shown in listview.
        if (!a.equals(blank)&& !a.equals(zero) && !a.equals(zerop)) {
            administration.setVisibility(View.VISIBLE);
            administration.setText("Route of Administration: " + a);
        } else{
            administration.setVisibility(View.GONE);
        }

        // if reason was left completely blank, it is not shown in listview.
        if (!r.equals(blank)&& !r.equals(zero) && !r.equals(zerop)) {
            reason.setVisibility(View.VISIBLE);
            reason.setText("Reason for Taking: " + r);
        } else{
            reason.setVisibility(View.GONE);
        }

        // there must always be a name for the med, so it's text is always shown.
        name.setText("Name: " + n);
        view.setId(m.getId());

        return view;


    }
}
