package com.example.symphony.phrx.db_classes;

/**
 * Created by Megan on 8/10/2016.
 */
public class Allergy {

    private int id;
    private String name;
    private String symptom;
    private String medication;

    //set values
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name;}

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    //get
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getMedication() {
        return medication;
    }
}
