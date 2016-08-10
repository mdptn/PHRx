package com.example.symphony.phrx;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.symphony.phrx.db_classes.PersonalHealth;

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
    //medication fields
    private static final String MED_ID ="id";
    private static final String MED_NAME = "name";
    private static final String MED_DOSE = "dose";
    private static final String MED_DOSE_UNIT = "dose_unit";
    private static final String MED_DOSAGE = "dosage";
    private static final String MED_DOSAGE_UNIT = "dosage_unit";
    private static final String MED_FREQ = "frequency";
    private static final String MED_FREG_INV = "frequency_interval";
    private static final String MED_ADMIN = "administration";
    private static final String MED_REASON = "reason";
    //immunization fields
    private static final String IMM_ID = "id";
    private static final String IMM_NAME = "name";
    private static final String IMM_DATE = "date";
    private static final String IMM_DOSE = "dose"; //dose number, calculate updates somewhere else
    //allergy fields
    private static final String ALL_ID = "id";
    private static final String ALL_NAME = "name";
    private static final String ALL_SYM = "symptom";
    private static final String ALL_MEDI = "medication";
    //condition fields
    private static final String CON_ID = "id";
    private static final String CON_NAME = "name";
    private static final String CON_DESC = "description";

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
    private static final String CREATE_TABLE_MEDICATION = "CREATE TABLE " + TABLE_MEDICATION +
            "(" +
            MED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MED_NAME + " TEXT," +
            MED_DOSE + " REAL," +
            MED_DOSE_UNIT + " TEXT," +
            MED_DOSAGE + " REAL," +
            MED_DOSAGE_UNIT + " TEXT," +
            MED_FREQ + " REAL," +
            MED_FREG_INV + " TEXT," +
            MED_ADMIN + " TEXT," +
            MED_REASON + " TEXT" +
            ")";
    private static final String CREATE_TABLE_IMMUNIZATION = "CREATE TABLE " + TABLE_IMMUNIZATION +
            "(" +
            IMM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            IMM_NAME + " TEXT," +
            IMM_DATE + " TEXT," +
            IMM_DOSE + " INT" +
            ")";
    private static final String CREATE_TABLE_ALLERGY = "CREATE TABLE " + TABLE_ALLERGY +
            "(" +
            ALL_ID + " INTEGER PRIMATE KEY AUTOINCREMENT," +
            ALL_NAME + " TEXT," +
            ALL_SYM + " TEXT," +
            ALL_MEDI + " TEXT" +
            ")";
    private static final String CREATE_TABLE_CONDITION = "CREATE TABLE " + TABLE_CONDITION +
            "(" +
            CON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CON_NAME + " TEXT," +
            CON_DESC + " TEXT" +
            ")";

    //constructor
    public  DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERSONAL_HEALTH);
        db.execSQL(CREATE_TABLE_MEDICATION);
        db.execSQL(CREATE_TABLE_IMMUNIZATION);
        db.execSQL(CREATE_TABLE_ALLERGY);
        db.execSQL(CREATE_TABLE_CONDITION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerseion) {
        if (oldVersion != newVerseion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL_HEALTH);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICATION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMMUNIZATION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALLERGY);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONDITION);
            onCreate(db);
        }
    }

    //methods

    //personal health
    public void createPersonalHealth(PersonalHealth ph) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PH_WEIGHT, ph.getWeight());
        values.put(PH_HEIGHT, ph.getHeight());
        values.put(PH_SYS, ph.getSystolic());
        values.put(PH_DIA, ph.getSystolic());
        values.put(PH_HR, ph.getHeartRate());

        long PersonalHealth_return = db.insert(TABLE_PERSONAL_HEALTH, null, values); //row id returned //-1 if error
    }
    //untested edit method, please check
    public void editPersonalHealth (PersonalHealth ph, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PH_WEIGHT, ph.getWeight());
        values.put(PH_HEIGHT, ph.getHeight());
        values.put(PH_SYS, ph.getSystolic());
        values.put(PH_DIA, ph.getSystolic());
        values.put(PH_HR, ph.getHeartRate());

        long PersonalHealth_returns = db.update(TABLE_PERSONAL_HEALTH, values, "_id=" + id, null);
    }
    public void deletePersonalHealth(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_PERSONAL_HEALTH, PH_ID + " = ?", new String[] {String.valueOf(id)});
    }
}
