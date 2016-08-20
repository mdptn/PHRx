package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.symphony.phrx.db_classes.Immunization;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditImmActivity extends AppCompatActivity{


    private EditText nameT, dateT, doseT, doseUT;
    DatabaseHandler dh;
    Immunization imm;
    int iId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editimmune);
        iId = MainActivity.iId;
        dh = new DatabaseHandler(this);
        imm = dh.getImmunization(iId);
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
        TextView date = (TextView) findViewById(R.id.editTextDate);
        TextView dose = (TextView) findViewById(R.id.editTextDose);
        TextView dose_unit = (TextView) findViewById(R.id.editTextDoseUnit);


        String d = String.valueOf(imm.getDose());

        name.setText(imm.getName());
        date.setText(imm.getDate());
        dose.setText(d);
        dose_unit.setText(imm.getDoseUnit());

        nameT = (EditText) findViewById(R.id.editTextName);
        dateT = (EditText) findViewById(R.id.editTextDate);
        doseT = (EditText) findViewById(R.id.editTextDose);
        doseUT = (EditText) findViewById(R.id.editTextDoseUnit);

    }



    public void onClickDeleteButton(View v) {
        dh.deleteImmunization(iId);
        finish();
    }


    public void onClickUpdateButton(View v){

        EditText[] x = {nameT, dateT, doseT, doseUT};


        //check if name is entered. must enter a name.
        if (!validateName(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter the name of your immunization", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (!validateDose(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter both a dose and unit", Toast.LENGTH_SHORT);
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
        String d = dateT.getText().toString();
        int dos = Integer.parseInt(doseT.getText().toString());
        String du = doseUT.getText().toString();

        imm.setName(n);
        imm.setDate(d);
        imm.setDose(dos);
        imm.setDoseUnit(du);
        dh.editImmunization(imm, iId);
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
        if (x[2].getText().toString().isEmpty()) {
            if (x[3].getText().toString().isEmpty()) {
                return true;
            } else{
                return false;
            }
        } else{
            if (x[3].getText().toString().isEmpty()) {
                return false;
            } else{
                return true;
            }
        }
    }

}
