package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        //validate
        EditText[] x = {editName, editSymptom, editMed};

        //check if name is entered. must enter a name.
        if (!validateName(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter the name of allergy", Toast.LENGTH_SHORT);
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
        String sym = editSymptom.getText().toString();
        String med = editMed.getText().toString();



        // set in the database
        a.setName(name);
        a.setSymptom(sym);
        a.setMedication(med);

        dh.createAllergy(a);
        finish();
    }

    public boolean validateName(EditText[] x) {
        if (x[0].getText().toString().isEmpty()) {
                return false;
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
