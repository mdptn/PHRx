package com.example.symphony.phrx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Condition;

/**
 * Created by Megan on 8/12/2016.
 */
public class EditConditionActivity extends AppCompatActivity{


    DatabaseHandler dh;
    Condition c;
    int cId;
    private EditText nameT, descT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcondition);
        cId = MainActivity.cId;
        dh = new DatabaseHandler(this);
        c = dh.getCondition(cId);
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
        TextView desc = (TextView) findViewById(R.id.editTextDescription);

        name.setText( c.getName());
        desc.setText(c.getDescription());

        nameT = (EditText) findViewById(R.id.editTextName);
        descT = (EditText) findViewById(R.id.editTextDescription);

    }



    public void onClickDeleteButton(View v) {
        dh.deleteCondition(cId);
        finish();
    }


    public void onClickUpdateButton(View v){
        String n = nameT.getText().toString();
        String d = descT.getText().toString();
        c.setName(n);
        c.setDescription(d);
        dh.editCondition(c, cId);
        finish();

    }

}
