package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.symphony.phrx.db_classes.PersonalHealth;

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

        // form fields
        EditText editWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
        EditText editSystolic = (EditText) findViewById(R.id.editTextSys);
        EditText editDiastolic = (EditText) findViewById(R.id.editTextDia);
        EditText editHeartRate = (EditText) findViewById(R.id.editTextHR);

        // convert to strings to use for set
        double w = Double.parseDouble(editWeight.getText().toString());
        double h = Double.parseDouble(editHeight.getText().toString());
        int s = Integer.parseInt(editSystolic.getText().toString());
        int d = Integer.parseInt(editDiastolic.getText().toString());
        int hr = Integer.parseInt(editHeartRate.getText().toString());

        // set in the database
        ph.setWeight(w);
        ph.setHeight(h);
        ph.setSystolic(s);
        ph.setDiastolic(d);
        ph.setHeartRate(hr);

        dh.createPersonalHealth(ph);
        finish();
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
