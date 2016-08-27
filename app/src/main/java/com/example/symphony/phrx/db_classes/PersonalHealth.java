package com.example.symphony.phrx.db_classes;

import java.security.Timestamp;

/**
 * Created by Andrew on 8/10/2016.
 */
public class PersonalHealth {
    private int id;
    private double weight;
    private String weight_unit;
    private double height;
    private String height_unit;
    private int systolic;
    private int diastolic;
    private int heartRate;
    private long time; //in milliseconds

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setWeightUnit(String weight_unit) {
        this.weight_unit = weight_unit;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setHeightUnit(String height_unit) {
        this.height_unit = height_unit;
    }
    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }
    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
    public void setTime(long time) {
        this.time = time;
    }

    //get
    public int getId() {
        return id;
    }
    public double getWeight() {
        return weight;
    }
    public String getWeightUnit() {
        return weight_unit;
    }
    public double getHeight() {
        return height;
    }
    public String getHeightUnit() {
        return height_unit;
    }
    public int getSystolic() {
        return systolic;
    }
    public int getDiastolic() {
        return diastolic;
    }
    public int getHeartRate() {
        return heartRate;
    }
    public long getTime() {
        return time;
    }
}
