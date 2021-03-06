package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.symphony.phrx.db_classes.Condition;

/**
 * Created by Megan on 8/12/2016.
 */
public class ConditionFormActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditionform);
    }

    public void onClickAdd(View v){
        DatabaseHandler dh = new DatabaseHandler(this);
        Condition c = new Condition();

        // form fields
        EditText editName = (EditText) findViewById(R.id.editTextName);
        EditText editDesc = (EditText) findViewById(R.id.editTextDescription);

        //validate
        EditText[] x = {editName, editDesc};
        if (!validateName(x)) {
            Toast toast = Toast.makeText(getApplication(), "Please enter the name of condition", Toast.LENGTH_SHORT);
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
        String desc = editDesc.getText().toString();


        // set in the database
        c.setName(name);
        c.setDescription(desc);

        dh.createCondition(c);
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
