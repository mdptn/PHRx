package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.symphony.phrx.db_classes.Immunization;

/**
 * Created by Megan on 8/12/2016.
 */
public class ImmFormActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immuneform);
    }

    public void onClickAdd(View v){
        DatabaseHandler dh = new DatabaseHandler(this);
        Immunization imm = new Immunization();

        // form fields
        EditText editName = (EditText) findViewById(R.id.editTextName);
        EditText editDate = (EditText) findViewById(R.id.editTextDate);
        EditText editDose = (EditText) findViewById(R.id.editTextDose);


        // convert to strings to use for set
        String name = editName.getText().toString();
        String date = editName.getText().toString();
        int d = Integer.parseInt(editDose.getText().toString());


        // set in the database
        imm.setName(name);
        imm.setDose(d);
        imm.setDate(date);

        dh.createImmunization(imm);
        finish();
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
