package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.symphony.phrx.db_classes.Medication;

/**
 * Created by Megan on 8/12/2016.
 */
public class MedFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medform);
    }

    public void onClickAdd(View v){
        DatabaseHandler dh = new DatabaseHandler(this);
        Medication m = new Medication();

        // form fields
        EditText editName = (EditText) findViewById(R.id.editTextName);
        EditText editDose = (EditText) findViewById(R.id.editTextDose);
        EditText editDoseUnit = (EditText) findViewById(R.id.editTextDoseUnit);
        EditText editDosage = (EditText) findViewById(R.id.editTextDosage);
        EditText editDosageUnit = (EditText) findViewById(R.id.editTextDosageUnit);
        EditText editFrequency = (EditText) findViewById(R.id.editTextFrequency);
        EditText editFrequencyInt = (EditText) findViewById(R.id.editTextFrequencyInt);
        EditText editAdmin = (EditText) findViewById(R.id.editTextAdmin);
        EditText editReason = (EditText) findViewById(R.id.editTextReason);

        //validate
        EditText[] x = {editName, editDoseUnit, editDosageUnit, editFrequencyInt, editAdmin, editReason, editDose, editDosage, editFrequency};
        if (!validate(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please fill out all fields", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        // convert to strings to use for set
        String name = editName.getText().toString();
        String dose_unit = editDoseUnit.getText().toString();
        String dosage_unit = editDosageUnit.getText().toString();
        String frequencyint = editFrequencyInt.getText().toString();
        String admin = editAdmin.getText().toString();
        String reason = editReason.getText().toString();
        double d = Double.parseDouble(editDose.getText().toString());
        double d2 = Double.parseDouble(editDosage.getText().toString());
        double f = Double.parseDouble(editFrequency.getText().toString());

        // set in the database
        m.setName(name);
        m.setDose(d);
        m.setDoseUnit(dose_unit);
        m.setDosage(d2);
        m.setDosageUnit(dosage_unit);
        m.setFrequency(f);
        m.setFrequency_interval(frequencyint);
        m.setAdministration(admin);
        m.setReason(reason);

        dh.createMedication(m);
        finish();
    }

    public boolean validate(EditText[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i].getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
