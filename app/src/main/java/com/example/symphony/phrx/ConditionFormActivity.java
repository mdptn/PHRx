package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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


        // convert to strings to use for set
        String name = editName.getText().toString();
        String desc = editDesc.getText().toString();


        // set in the database
        c.setName(name);
        c.setDescription(desc);

        dh.createCondition(c);
        finish();
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
