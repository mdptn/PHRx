package com.example.symphony.phrx.db_classes;

/**
 * Created by Megan on 8/10/2016.
 */
public class Condition {

    private int id;
    private String name;
    private String description;

    //set values
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name;}

    public void setDescription(String description) {
        this.description = description;
    }


    //get
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}


