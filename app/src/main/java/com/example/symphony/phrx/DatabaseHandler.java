package com.example.symphony.phrx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrew on 8/9/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //db info
    private static final String DATABASE_NAME = "phrxDatabase";
    private static final int DATABASE_VERSION = 1;
    //tables
    private static final String TABLE_PERSONAL_HEALTH = "personal_health";
    private static final String TABLE_MEDICATION = "medication";
    private static final String TABLE_IMMUNIZATION = "immunization";
    private static final String TABLE_ALLERGY = "allergy";
    private static final String TABLE_CONDITION = "condition";
    //personal health fields
    private static final String PH_ID = "id";
    private static final String PH_WEIGHT = "weight";
    private static final String PH_HEIGHT = "height";
    private static final String PH_SYS = "systolic";
    private static final String PH_DIA = "diastolic";
    private static final String PH_HR = "heart_rate";
    //


    //create table statements
    private static final String CREATE_TABLE_PERSONAL_HEALTH = "CREATE TABLE " + TABLE_PERSONAL_HEALTH +
            "(" +
            PH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PH_WEIGHT + " REAL," +
            PH_HEIGHT + " REAL," +
            PH_SYS + " INT," +
            PH_DIA + " INT," +
            PH_HR + " INT" +
            ")";

    public  DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERSONAL_HEALTH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerseion) {
        if (oldVersion != newVerseion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL_HEALTH);
            onCreate(db);
        }
    }
}
