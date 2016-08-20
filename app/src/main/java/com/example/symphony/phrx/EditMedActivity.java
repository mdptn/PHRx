package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.symphony.phrx.db_classes.Medication;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditMedActivity extends AppCompatActivity{


    private EditText nameT, doseT, doseuT, dosageT, dosageuT, freqT, freqiT, adminT, reasonT;
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

        String d = String.valueOf(m.getDose());
        String d2 = String.valueOf(m.getDosage());
        String f = String.valueOf(m.getFrequency());

        name.setText(m.getName());
        dose.setText(d);
        doseunit.setText(m.getDoseUnit());
        dosage.setText(d2);
        dosageunit.setText(m.getDosageUnit());
        frequency.setText(f);
        frequencyint.setText(m.getFrequencyInterval());
        admin.setText(m.getAdministration());
        reason.setText(m.getReason());

        nameT = (EditText) findViewById(R.id.editTextName);
        doseT = (EditText) findViewById(R.id.editTextDose);
        doseuT = (EditText) findViewById(R.id.editTextDoseUnit);
        dosageT = (EditText) findViewById(R.id.editTextDosage);
        dosageuT = (EditText) findViewById(R.id.editTextDosageUnit);
        freqT = (EditText) findViewById(R.id.editTextFrequency);
        freqiT = (EditText) findViewById(R.id.editTextFrequencyInt);
        adminT = (EditText) findViewById(R.id.editTextAdmin);
        reasonT = (EditText) findViewById(R.id.editTextReason);


    }



    public void onClickDeleteButton(View v) {
        dh.deleteMedication(mId);
        finish();
    }


    public void onClickUpdateButton(View v){

        EditText[] x = {nameT, doseT, doseuT, dosageT, dosageuT, freqT, freqiT, adminT, reasonT};

        if (!validateName(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter a medication name", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (!validateDose(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter both a dose and unit", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (!validateDosage(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter both a dosage and unit", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (!validateFrequency(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter both a frequency and unit", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        // set a field value to 0 if nothing was entered
        for (int i = 0; i < x.length; i++) {
            if (x[i].getText().toString().isEmpty()) {
                x[i].setText("0");
            }
        }

        String n = nameT.getText().toString();
        String du = doseuT.getText().toString();
        String du2 = dosageuT.getText().toString();
        String f2 = freqiT.getText().toString();
        String a = adminT.getText().toString();
        String r = reasonT.getText().toString();
        double d = Double.parseDouble(doseT.getText().toString());
        double d2 = Double.parseDouble(dosageT.getText().toString());
        double f = Double.parseDouble(freqT.getText().toString());



        m.setName(n);
        m.setDose(d);
        m.setDoseUnit(du);
        m.setDosage(d2);
        m.setDosageUnit(du2);
        m.setFrequency(f);
        m.setFrequency_interval(f2);
        m.setAdministration(a);
        m.setReason(r);
        dh.editMedication(m, mId);
        finish();

    }


    public boolean validateName(EditText[] x) {
        if (x[0].getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    // this makes sure that both Dose and Dose Unit are entered, or both not entered.
    public boolean validateDose(EditText[] x) {
        if (x[1].getText().toString().isEmpty()) {
            if (x[2].getText().toString().isEmpty()) {
                return true;
            } else{
                return false;
            }
        } else{
            if (x[2].getText().toString().isEmpty()) {
                return false;
            } else{
                return true;
            }
        }
    }

    // this makes sure that both Dosage and Dosage Unit are entered, or both not entered.
    public boolean validateDosage(EditText[] x) {
        if (x[3].getText().toString().isEmpty()) {
            if (x[4].getText().toString().isEmpty()) {
                return true;
            } else{
                return false;
            }
        } else{
            if (x[4].getText().toString().isEmpty()) {
                return false;
            } else{
                return true;
            }
        }
    }

    // this makes sure that both Frequency and interval Unit are entered, or both not entered.
    public boolean validateFrequency(EditText[] x) {
        if (x[5].getText().toString().isEmpty()) {
            if (x[6].getText().toString().isEmpty()) {
                return true;
            } else{
                return false;
            }
        } else{
            if (x[6].getText().toString().isEmpty()) {
                return false;
            } else{
                return true;
            }
        }
    }


}
