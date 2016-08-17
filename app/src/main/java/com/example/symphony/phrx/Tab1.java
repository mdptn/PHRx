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

import java.text.DecimalFormat;
import java.util.List;


public class Tab1 extends Fragment{
    DatabaseHandler dh;
    List<PersonalHealth> phl;
    List<Medication> ml;
    List<Immunization> il;
    List<Allergy> al;
    List<Condition> cl;

    List<PersonalHealth> p;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        dh = new DatabaseHandler((getActivity()));
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.actionbar_tab_1, container, false);
        return rootView;

    }

    public void onResume() {
        super.onResume();
        setDisplay(checkFill());
        displaySummary();
    }

    public boolean checkFill() {
        boolean flag = false;
        p = dh.getAllPersonalHealth();
        /*
        List<Medication> m = dh.getAllMedication();
        List<Immunization> i = dh.getAllImmunization();
        List<Allergy> a = dh.getAllAlergy();
        List<Condition> c = dh.getAllCondition();
        */
        List[] x = {p}; //List[] x = {p, m, i, a, c};
        for (int j = 0; j < x.length; j++) {
            if(x[j].size() != 0) {
                return true;
            }
        }
        return false;
    }

    public void setDisplay(boolean b) {
        View prompt = getView().findViewById(R.id.prompt);
        View summ = getView().findViewById(R.id.textViewSum);
        if (b) {
            prompt.setVisibility(View.INVISIBLE);
            summ.setVisibility(View.VISIBLE);
        } else {
            prompt.setVisibility(View.VISIBLE);
            summ.setVisibility(View.INVISIBLE);
        }
    }

    public void displaySummary(){
        /*
        ListView listview = (ListView) getView().findViewById(R.id.summary_list);
        listview.setEmptyView(getView().findViewById(R.id.prompt));
        */
        List<PersonalHealth> p = dh.getAllPersonalHealth();
        List<Medication> m = dh.getAllMedication();
        List<Immunization> i = dh.getAllImmunization();
        List<Allergy> a = dh.getAllAlergy();
        List<Condition> c = dh.getAllCondition();


        String ml = "";
        if (m.size() == 0) {
            ml = "no medication";
        } else {
            for(int j = 0; j < m.size(); j++) {
                String x = ", ";
                if (j == m.size() - 1) x = "";
                ml = ml.concat(m.get(j).getName() + x);
            }
        }

        String x = "";
        if (!checkFill()) {

        } else {
            PersonalHealth pl = p.get(p.size() - 1);

            //calculating BMI-----------------------------------------------------------------------
            String wunit = pl.getWeightUnit();
            String hunit = pl.getHeightUnit();
            double theHeight = pl.getHeight();
            double theWeight = pl.getWeight();
            double BMI;
            DecimalFormat onePlace = new DecimalFormat("#,##0.0");

            //check if weight unit is kg
            if(wunit.equals("Kilograms") == true){
                if(hunit.equals("Centimeters") == true){ // calc BMI for kg/cm
                    theHeight = theHeight/100;
                    theHeight = theHeight*theHeight;
                    BMI = theWeight/theHeight;
                } else { // calc BMI for kg/inch
                    theHeight = theHeight * 2.54;
                    theHeight = theHeight/100;
                    theHeight = theHeight*theHeight;
                    BMI = theWeight/theHeight;
                }
            } else{
                if(hunit.equals("Inches") == true){ // calc BMI for lb/inch
                    theHeight = theHeight*theHeight;
                    BMI = theWeight/theHeight*703;

                } else{ // calc BMI for lb/cm
                    theWeight = theWeight*0.45359237;
                    theHeight = theHeight/100;
                    theHeight = theHeight*theHeight;
                    BMI = theWeight/theHeight;

                }
            }
            //--------------------------------------------------------------------------------------


            x = "Here are your last Records\n\nWeight: " + pl.getWeight() + " " + pl.getWeightUnit() +
                    "\nHeight: " + pl.getHeight() + " " + pl.getHeightUnit() + "\nYour BMI is " + onePlace.format(BMI) + "." + "\nBlood Pressure: "  + pl.getSystolic() +
                    "/" + pl.getDiastolic() + " mm Hg" + "\nYou are also taking: " + ml;
        }

        TextView display = (TextView) getView().findViewById(R.id.textViewSum);
        display.setText(x);
    }

}
