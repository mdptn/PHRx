package com.example.symphony.phrx;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.symphony.phrx.db_classes.Condition;

/**
 * Created by Megan on 8/11/2016.
 */

// helps put the List Array into the ListView


public class ConditionArrayAdapter extends ArrayAdapter<Condition>{

    public ConditionArrayAdapter(Context context, List<Condition> c){
        super(context, 0, c);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Condition c = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.conditioninfo, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.textName);
        TextView desc = (TextView) view.findViewById(R.id.textDescription);

        name.setText("Name: " + c.getName());
        desc.setText("Description: " + c.getDescription());

        view.setId(c.getId());

        return view;


    }
}
