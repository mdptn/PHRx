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
    List<PersonalHealth> p;
    List<Medication> ml;
    List<Immunization> il;
    List<Allergy> al;
    List<Condition> cl;
    boolean P, M, I, A, C;



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

    public boolean checkFill() { // check if any tabs have data
        boolean flag = false;
        p = dh.getAllPersonalHealth();
        ml = dh.getAllMedication();
        il = dh.getAllImmunization();
        al = dh.getAllAlergy();
        cl = dh.getAllCondition();


        List[] x = {p};
        List[] y = {ml};
        List[] z = {il};
        List[] q = {al};
        List[] r = {cl};
        for (int j = 0; j < x.length; j++) {
            if(x[j].size() != 0) {
                P = true;
                return true;
            }
        }
        for (int j = 0; j < y.length; j++) {
            if(y[j].size() != 0) {
                M = true;
                return true;
            }
        }
        for (int j = 0; j < z.length; j++) {
            if(z[j].size() != 0) {
                I = true;
                return true;
            }
        }
        for (int j = 0; j < q.length; j++) {
            if(q[j].size() != 0) {
                A = true;
                return true;
            }
        }
        for (int j = 0; j < r.length; j++) {
            if(r[j].size() != 0) {
                C = true;
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

            String psumm = "";

            if (P == true) { // if there is any personal health records

                String hsumm = "";
                boolean wflag = false;
                boolean hflag = false;
                String wsumm = "";
                String ybmi = "";
                String bpsumm = "";

                PersonalHealth pl = p.get(p.size() - 1);


                String wunit = pl.getWeightUnit();
                String hunit = pl.getHeightUnit();
                double theWeight = pl.getWeight();
                double theHeight = pl.getHeight();
                int dia = pl.getDiastolic();
                int sys = pl.getSystolic();

                if(theHeight == 0 || theHeight == 0.0){
                } else{
                    hflag = true;
                    hsumm = "\nHeight: " + theHeight + " " + hunit;
                }
                if(theWeight == 0 || theWeight == 0.0){
                } else{
                    wflag = true;
                    wsumm = "\nWeight: " + theWeight + " " + wunit;
                }

                if(hflag == true && wflag == true) {
                    double BMI;
                    DecimalFormat onePlace = new DecimalFormat("#,##0.0");
                    BMI = calcBMI(theWeight, wunit, theHeight, hunit);
                    ybmi = "\nYour BMI is " + onePlace.format(BMI) + ".";
                }

                if(dia != 0 && sys != 0){
                    bpsumm = "\nBlood Pressure: "  + sys + "/" + dia + " mm Hg";
                }


                psumm = wsumm + hsumm + ybmi + bpsumm;

            }




            x = "Here are your last Records\n" + psumm + "\nYou are taking: " + ml;
        }

        TextView display = (TextView) getView().findViewById(R.id.textViewSum);
        display.setText(x);

    }

    // BMI calculator
    public double calcBMI(double w, String wu, double h, String hu){
        double BMI;
        //check if weight unit is kg
        if(wu.equals("Kilograms") == true){
            if(hu.equals("Centimeters") == true){ // calc BMI for kg/cm
                h = h/100;
                h = h*h;
                BMI = w/h;
            } else { // calc BMI for kg/inch
                h = h * 2.54;
                h = h/100;
                h = h*h;
                BMI = w/h;
            }
        } else{
            if(hu.equals("Inches") == true){ // calc BMI for lb/inch
                h = h*h;
                BMI = w/h*703;

            } else{ // calc BMI for lb/cm
                w = w*0.45359237;
                h = h/100;
                h = h*h;
                BMI = w/h;

            }
        }
        return BMI;
    }

}
