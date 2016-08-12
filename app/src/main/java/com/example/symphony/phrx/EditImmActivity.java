package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Immunization;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditImmActivity extends AppCompatActivity{


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


        name.setText("Name: " + imm.getName());
        date.setText("Date: " + imm.getDate());
        dose.setText("Dose: " + imm.getDose());


    }



    public void onClickDeleteButton(View v) {
        dh.deleteImmunization(iId);
        finish();
    }

    /*
    public void onClickUpdateButton(View v){
        dh.editPersonalHealth(ph, phId);
        finish();

    } */

}
