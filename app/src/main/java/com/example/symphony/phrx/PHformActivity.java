package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.symphony.phrx.db_classes.PersonalHealth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Megan on 8/12/2016.
 */
public class PHformActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthform);
    }

    public void onClickAdd(View v){
        DatabaseHandler dh = new DatabaseHandler(this);
        PersonalHealth ph = new PersonalHealth();

        Spinner wspin = (Spinner) findViewById(R.id.weightUnit);
        String wunit = wspin.getSelectedItem().toString();
        Spinner hspin = (Spinner) findViewById(R.id.heightUnit);
        String hunit = hspin.getSelectedItem().toString();

        // form fields
        EditText editWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
        EditText editSystolic = (EditText) findViewById(R.id.editTextSys);
        EditText editDiastolic = (EditText) findViewById(R.id.editTextDia);
        EditText editHeartRate = (EditText) findViewById(R.id.editTextHR);

        //validate
        EditText[] x = {editWeight, editHeight, editSystolic, editDiastolic, editHeartRate};
        if (!validate(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please fill in at least one field", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (!validateBP(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please fill in a complete heart rate", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        // set a field value to 0 if nothing was entered
        for (int i = 0; i < x.length; i++) {
            if (x[i].getText().toString().isEmpty()) {
                x[i].setText("0");
            }
        }

        // convert to strings to use for set
        double w = Double.parseDouble(editWeight.getText().toString());
        double h = Double.parseDouble(editHeight.getText().toString());
        int s = Integer.parseInt(editSystolic.getText().toString());
        int d = Integer.parseInt(editDiastolic.getText().toString());
        int hr = Integer.parseInt(editHeartRate.getText().toString());

        // set in the database
        ph.setWeight(w);
        ph.setWeightUnit(wunit);
        ph.setHeight(h);
        ph.setHeightUnit(hunit);
        ph.setSystolic(s);
        ph.setDiastolic(d);
        ph.setHeartRate(hr);
        ph.setTime(Calendar.getInstance().getTimeInMillis());

        dh.createPersonalHealth(ph);
        finish();
    }

    // validate if at least one field was filled in
    public boolean validate(EditText[] x) {
        for (int i = 0; i < x.length; i++) {
            if (!x[i].getText().toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // this makes sure that both systolic and diastolic bp are entered, or both not entered.
    public boolean validateBP(EditText[] x) {
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

    public void onPause() {
        super.onPause();
        finish();
    }
}
