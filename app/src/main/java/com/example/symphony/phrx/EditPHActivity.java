package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.PersonalHealth;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditPHActivity extends AppCompatActivity{


    DatabaseHandler dh;
    PersonalHealth ph;
    int phId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edithealth);
        phId = MainActivity.phId;
        dh = new DatabaseHandler(this);
        ph = dh.getPersonalHealth(phId);
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
        TextView weight = (TextView) findViewById(R.id.editTextWeight);
        TextView height = (TextView) findViewById(R.id.editTextHeight);
        TextView sys = (TextView) findViewById(R.id.editTextSys);
        TextView dia = (TextView) findViewById(R.id.editTextDia);
        TextView hr = (TextView) findViewById(R.id.editTextHR);


        weight.setText("Weight: " + ph.getWeight());
        height.setText("Height: " + ph.getHeight());
        sys.setText("Systolic Blood Pressure: " + ph.getSystolic());
        dia.setText("Diastolic Blood Pressure: " + ph.getDiastolic());
        hr.setText("Heart Rate: " + ph.getHeartRate());


    }



    public void onClickDeleteButton(View v) {
        dh.deletePersonalHealth(phId);
        finish();
    }

    /*
    public void onClickUpdateButton(View v){
        dh.editPersonalHealth(ph, phId);
        finish();

    } */

}
