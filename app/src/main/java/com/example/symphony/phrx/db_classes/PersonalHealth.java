package com.example.symphony.phrx.db_classes;

/**
 * Created by Andrew on 8/10/2016.
 */
public class PersonalHealth {
    private int id;
    private double weight;
    private double height;
    private int systolic;
    private int diastolic;
    private int heartRate;

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setHeight(double height) {
        this.height = height;
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

    //get
    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
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
}
