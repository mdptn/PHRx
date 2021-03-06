package com.example.symphony.phrx.db_classes;

/**
 * Created by Megan on 8/10/2016.
 */
public class Medication {

    private int id;
    private String name;
    private double dose;
    private String dose_unit;
    private double dosage;
    private String dosage_unit;
    private double frequency;
    private String frequency_interval;
    private String administration;
    private String reason;

    //set value
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public void setDoseUnit(String dose_unit) {
        this.dose_unit = dose_unit;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public void setDosageUnit(String dosage_unit) {
        this.dosage_unit = dosage_unit;
    }

    public void setFrequency(double frequency){ this.frequency = frequency;}

    public void setFrequency_interval(String frequency_interval) {
        this.frequency_interval = frequency_interval;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    //get value
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDose() {
        return dose;
    }

    public String getDoseUnit() {
        return dose_unit;
    }

    public double getDosage() {
        return dosage;
    }

    public String getDosageUnit() {
        return dosage_unit;
    }

    public double getFrequency(){ return frequency;}

    public String getFrequencyInterval(){ return frequency_interval;}

    public String getAdministration(){ return administration;}

    public String getReason(){ return reason;}

}
