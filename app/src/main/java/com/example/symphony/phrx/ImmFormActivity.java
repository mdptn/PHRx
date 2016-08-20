package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText editDoseUnit = (EditText) findViewById(R.id.editTextDoseUnit);

        //validate
        EditText[] x = {editName, editDose, editDate, editDoseUnit};


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

        // convert to strings to use for set
        String name = editName.getText().toString();
        String date = editDate.getText().toString();
        int d = Integer.parseInt(editDose.getText().toString());
        String dunit = editDoseUnit.getText().toString();


        // set in the database
        imm.setName(name);
        imm.setDose(d);
        imm.setDate(date);
        imm.setDoseUnit(dunit);

        dh.createImmunization(imm);
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
        if (x[1].getText().toString().isEmpty()) {
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
