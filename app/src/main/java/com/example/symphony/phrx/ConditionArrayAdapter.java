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

        String n = c.getName();
        String d = c.getDescription();
        String blank = "";
        String zerop = "0.0";
        String zero = "0";

        // if description was left completely blank, it is not shown in listview.
        if (!d.equals(blank)&& !d.equals(zero) && !d.equals(zerop)) {
            desc.setVisibility(View.VISIBLE);
            desc.setText("Description: " + c.getDescription());
        } else{
            desc.setVisibility(View.GONE);
        }

        name.setText("Name: " + c.getName());

        view.setId(c.getId());

        return view;


    }
}
