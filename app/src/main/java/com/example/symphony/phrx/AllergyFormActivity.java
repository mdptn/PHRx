package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.symphony.phrx.db_classes.Allergy;

/**
 * Created by Megan on 8/12/2016.
 */
public class AllergyFormActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allergyform);
    }

    public void onClickAdd(View v){
        DatabaseHandler dh = new DatabaseHandler(this);
        Allergy a = new Allergy();

        // form fields
        EditText editName = (EditText) findViewById(R.id.editTextName);
        EditText editSymptom = (EditText) findViewById(R.id.editTextSymptom);
        EditText editMed = (EditText) findViewById(R.id.editTextMed);


        // convert to strings to use for set
        String name = editName.getText().toString();
        String sym = editSymptom.getText().toString();
        String med = editMed.getText().toString();



        // set in the database
        a.setName(name);
        a.setSymptom(sym);
        a.setMedication(med);

        dh.createAllergy(a);
        finish();
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
