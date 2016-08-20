package com.example.symphony.phrx.db_classes;

/**
 * Created by Megan on 8/10/2016.
 */
public class Immunization {

    private int id;
    private String name;
    private String date; // temporary. will probably change type later to include datepicker
    private int dose;
    private String dose_unit;

    //set values
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name;}

    public void setDate(String date) {
        this.date = date;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setDoseUnit(String dose_unit) {
        this.dose_unit = dose_unit;
    }

    //get
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getDose() {
        return dose;
    }

    public String getDoseUnit() {
        return dose_unit;
    }

}
