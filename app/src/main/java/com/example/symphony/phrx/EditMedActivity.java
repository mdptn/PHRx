package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Medication;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditMedActivity extends AppCompatActivity{


    DatabaseHandler dh;
    Medication m;
    int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editmedic);
        mId = MainActivity.mId;
        dh = new DatabaseHandler(this);
        m = dh.getMedication(mId);
    }

    public void onResume() {
        super.onResume();
        editRecord();
    }

    public void onPause() {
        super.onPause();
        finish();
    }

    public void editRecord(){
        TextView name = (TextView) findViewById(R.id.editTextName);
        TextView dose = (TextView) findViewById(R.id.editTextDose);
        TextView doseunit = (TextView) findViewById(R.id.editTextDoseUnit);
        TextView dosage = (TextView) findViewById(R.id.editTextDosage);
        TextView dosageunit = (TextView) findViewById(R.id.editTextDosageUnit);
        TextView frequency = (TextView) findViewById(R.id.editTextFrequency);
        TextView frequencyint = (TextView) findViewById(R.id.editTextFrequencyInt);
        TextView admin = (TextView) findViewById(R.id.editTextAdmin);
        TextView reason = (TextView) findViewById(R.id.editTextReason);



        name.setText("Name: " + m.getName());
        dose.setText("Dose: " + m.getDose());
        doseunit.setText("Dose Unit: " + m.getDoseUnit());
        dosage.setText("Dosage: " + m.getDosage());
        dosageunit.setText("Dosage Unit: " + m.getDosageUnit());
        frequency.setText("Frequency: " + m.getFrequency());
        frequencyint.setText("Frequency Interval: " + m.getFrequencyInterval());
        admin.setText("Route of Administration: " + m.getAdministration());
        reason.setText("Reason for Taking: " + m.getReason());


    }



    public void onClickDeleteButton(View v) {
        dh.deleteMedication(mId);
        finish();
    }

    /*
    public void onClickUpdateButton(View v){
        dh.editPersonalHealth(ph, phId);
        finish();

    } */

}
