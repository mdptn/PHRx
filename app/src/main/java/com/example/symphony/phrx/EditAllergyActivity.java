package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Allergy;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditAllergyActivity extends AppCompatActivity{


    private EditText nameT, symT, medT;
    DatabaseHandler dh;
    Allergy a;
    int aId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editallergy);
        aId = MainActivity.aId;
        dh = new DatabaseHandler(this);
        a = dh.getAllergy(aId);
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
        TextView symptom = (TextView) findViewById(R.id.editTextSymptom);
        TextView meds = (TextView) findViewById(R.id.editTextMed);


        name.setText(a.getName());
        symptom.setText(a.getSymptom());
        meds.setText(a.getMedication());

        nameT = (EditText) findViewById(R.id.editTextName);
        symT = (EditText) findViewById(R.id.editTextSymptom);
        medT = (EditText) findViewById(R.id.editTextMed);

    }



    public void onClickDeleteButton(View v) {
        dh.deleteAllergy(aId);
        finish();
    }


    public void onClickUpdateButton(View v){
        String n = nameT.getText().toString();
        String s = symT.getText().toString();
        String m = medT.getText().toString();
        a.setName(n);
        a.setSymptom(s);
        a.setMedication(m);
        dh.editAllergy(a, aId);
        finish();

    }

}
