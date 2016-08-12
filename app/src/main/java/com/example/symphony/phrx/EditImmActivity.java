package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Immunization;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditImmActivity extends AppCompatActivity{


    private EditText nameT, dateT, doseT;
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


        String d = String.valueOf(imm.getDose());

        name.setText(imm.getName());
        date.setText(imm.getDate());
        dose.setText(d);

        nameT = (EditText) findViewById(R.id.editTextName);
        dateT = (EditText) findViewById(R.id.editTextDate);
        doseT = (EditText) findViewById(R.id.editTextDose);

    }



    public void onClickDeleteButton(View v) {
        dh.deleteImmunization(iId);
        finish();
    }


    public void onClickUpdateButton(View v){
        String n = nameT.getText().toString();
        String d = dateT.getText().toString();
        int dos = Integer.parseInt(doseT.getText().toString());
        imm.setName(n);
        imm.setDate(d);
        imm.setDose(dos);
        dh.editImmunization(imm, iId);
        finish();

    }

}
