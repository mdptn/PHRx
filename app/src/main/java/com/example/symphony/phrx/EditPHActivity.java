package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.PersonalHealth;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditPHActivity extends AppCompatActivity{


    private EditText weighT, heighT, sysT, diaT, hrT;
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

        String w = String.valueOf(ph.getWeight());
        String h = String.valueOf(ph.getHeight());
        String s = String.valueOf(ph.getSystolic());
        String d = String.valueOf(ph.getDiastolic());
        String r = String.valueOf(ph.getHeartRate());

        weight.setText(w);
        height.setText(h);
        sys.setText(s);
        dia.setText(d);
        hr.setText(r);

        weighT = (EditText) findViewById(R.id.editTextWeight);
        heighT = (EditText) findViewById(R.id.editTextHeight);
        sysT = (EditText) findViewById(R.id.editTextSys);
        diaT = (EditText) findViewById(R.id.editTextDia);
        hrT = (EditText) findViewById(R.id.editTextHR);


    }



    public void onClickDeleteButton(View v) {
        dh.deletePersonalHealth(phId);
        finish();
    }


    public void onClickUpdateButton(View v){
        double w = Double.parseDouble(weighT.getText().toString());
        double h = Double.parseDouble(heighT.getText().toString());
        int s = Integer.parseInt(sysT.getText().toString());
        int d = Integer.parseInt(diaT.getText().toString());
        int hr = Integer.parseInt(hrT.getText().toString());

        ph.setWeight(w);
        ph.setHeight(h);
        ph.setSystolic(s);
        ph.setDiastolic(d);
        ph.setHeartRate(hr);
        dh.editPersonalHealth(ph, phId);
        finish();

    }

}
