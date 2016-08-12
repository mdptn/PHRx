package com.example.symphony.phrx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.symphony.phrx.db_classes.Allergy;
import com.example.symphony.phrx.db_classes.Condition;
import com.example.symphony.phrx.db_classes.Immunization;
import com.example.symphony.phrx.db_classes.Medication;
import com.example.symphony.phrx.db_classes.PersonalHealth;

import java.util.ArrayList;
import java.util.List;

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
    private static final String MED_ID = "id";
    private static final String MED_NAME = "name";
    private static final String MED_DOSE = "dose";
    private static final String MED_DOSE_UNIT = "dose_unit";
    private static final String MED_DOSAGE = "dosage";
    private static final String MED_DOSAGE_UNIT = "dosage_unit";
    private static final String MED_FREQ = "frequency";
    private static final String MED_FREQ_INV = "frequency_interval";
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
            MED_FREQ_INV + " TEXT," +
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
    public DatabaseHandler(Context context) {
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
        values.put(PH_DIA, ph.getDiastolic());
        values.put(PH_HR, ph.getHeartRate());

        long PersonalHealth_return = db.insert(TABLE_PERSONAL_HEALTH, null, values); //row id returned //-1 if error
    }
    //untested edit method, please check
    public void editPersonalHealth(PersonalHealth ph, int id) {
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

        db.delete(TABLE_PERSONAL_HEALTH, PH_ID + " = ?", new String[]{String.valueOf(id)});
    }
    public PersonalHealth getPersonalHealth(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_PERSONAL_HEALTH + " WHERE" + PH_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        PersonalHealth ph = new PersonalHealth();
        ph.setId(c.getInt(c.getColumnIndex(PH_ID)));
        ph.setHeight(c.getDouble(c.getColumnIndex(PH_HEIGHT)));
        ph.setWeight(c.getDouble(c.getColumnIndex(PH_WEIGHT)));
        ph.setSystolic(c.getInt(c.getColumnIndex(PH_SYS)));
        ph.setDiastolic(c.getInt(c.getColumnIndex(PH_DIA)));
        ph.setHeartRate(c.getInt(c.getColumnIndex(PH_HR)));

        return ph;
    }
    public List<PersonalHealth> getAllPersonalHealth() {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_PERSONAL_HEALTH;
        Cursor c = db.rawQuery(selectQuery, null);

        List<PersonalHealth> phl = new ArrayList<PersonalHealth>();
        if (c.moveToFirst()) {
            do {
                PersonalHealth ph = new PersonalHealth();
                ph.setId(c.getInt(c.getColumnIndex(PH_ID)));
                ph.setHeight(c.getDouble(c.getColumnIndex(PH_HEIGHT)));
                ph.setWeight(c.getDouble(c.getColumnIndex(PH_WEIGHT)));
                ph.setSystolic(c.getInt(c.getColumnIndex(PH_SYS)));
                ph.setDiastolic(c.getInt(c.getColumnIndex(PH_DIA)));
                ph.setHeartRate(c.getInt(c.getColumnIndex(PH_HR)));
                phl.add(ph);
            } while (c.moveToNext());
        }

        return phl;
    }
    public void clearPersonalHealth() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_PERSONAL_HEALTH, null, null);
    }

    //medication
    public void createMedication(Medication m) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MED_NAME, m.getName());
        values.put(MED_DOSE, m.getDose());
        values.put(MED_DOSE_UNIT, m.getDoseUnit());
        values.put(MED_DOSAGE, m.getDosage());
        values.put(MED_DOSAGE_UNIT, m.getDosageUnit());
        values.put(MED_FREQ, m.getFrequency());
        values.put(MED_FREQ_INV, m.getFrequencyInterval());
        values.put(MED_ADMIN, m.getAdministration());
        values.put(MED_REASON, m.getReason());

        long Medicatoin_returns = db.insert(TABLE_MEDICATION, null, values);
    }
    public void editMedication(Medication m, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MED_NAME, m.getName());
        values.put(MED_DOSE, m.getDose());
        values.put(MED_DOSE_UNIT, m.getDoseUnit());
        values.put(MED_DOSAGE, m.getDosage());
        values.put(MED_DOSAGE_UNIT, m.getDosageUnit());
        values.put(MED_FREQ, m.getFrequency());
        values.put(MED_FREQ_INV, m.getFrequencyInterval());
        values.put(MED_ADMIN, m.getAdministration());
        values.put(MED_REASON, m.getReason());

        long Medication_returns = db.update(TABLE_MEDICATION, values, "_id=" + id, null);
    }
    public void deleteMedication(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_MEDICATION, MED_ID + " = ?", new String[]{String.valueOf(id)});
    }
    public Medication getMedication(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_MEDICATION + " WHERE" + MED_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Medication m = new Medication();
        m.setId(c.getInt(c.getColumnIndex(MED_ID)));
        m.setName(c.getString(c.getColumnIndex(MED_NAME)));
        m.setDose(c.getDouble(c.getColumnIndex(MED_DOSE)));
        m.setDoseUnit(c.getString(c.getColumnIndex(MED_DOSE_UNIT)));
        m.setDosage(c.getDouble(c.getColumnIndex(MED_DOSAGE)));
        m.setDosageUnit(c.getString(c.getColumnIndex(MED_DOSAGE_UNIT)));
        m.setFrequency(c.getDouble(c.getColumnIndex(MED_FREQ)));
        m.setFrequency_interval(c.getString(c.getColumnIndex(MED_FREQ_INV)));
        m.setAdministration(c.getString(c.getColumnIndex(MED_ADMIN)));
        m.setReason(c.getString(c.getColumnIndex(MED_REASON)));

        return m;
    }
    public List<Medication> getAllMedication() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_MEDICATION;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Medication> ml = new ArrayList<Medication>();
        if (c.moveToFirst()) {
            do {
                Medication m = new Medication();
                m.setId(c.getInt(c.getColumnIndex(MED_ID)));
                m.setName(c.getString(c.getColumnIndex(MED_NAME)));
                m.setDose(c.getDouble(c.getColumnIndex(MED_DOSE)));
                m.setDoseUnit(c.getString(c.getColumnIndex(MED_DOSE_UNIT)));
                m.setDosage(c.getDouble(c.getColumnIndex(MED_DOSAGE)));
                m.setDosageUnit(c.getString(c.getColumnIndex(MED_DOSAGE_UNIT)));
                m.setFrequency(c.getDouble(c.getColumnIndex(MED_FREQ)));
                m.setFrequency_interval(c.getString(c.getColumnIndex(MED_FREQ_INV)));
                m.setAdministration(c.getString(c.getColumnIndex(MED_ADMIN)));
                m.setReason(c.getString(c.getColumnIndex(MED_REASON)));
                ml.add(m);
            } while (c.moveToNext());
        }

        return ml;
    }
    public void clearMedication() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_MEDICATION, null, null);
    }

    //immunization
    public void createImmunization(Immunization i) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(IMM_ID, i.getId());
        values.put(IMM_NAME, i.getName());
        values.put(IMM_DATE, i.getDate());
        values.put(IMM_DOSE, i.getDose());

        long Immunization_return = db.insert(TABLE_IMMUNIZATION, null, values);
    }
    public void editImmunization(Immunization i, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(IMM_ID, i.getId());
        values.put(IMM_NAME, i.getName());
        values.put(IMM_DATE, i.getDate());
        values.put(IMM_DOSE, i.getDose());

        long Immunization_returns = db.update(TABLE_IMMUNIZATION, values, "_id=" + id, null);
    }
    public void deleteImmunization(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_IMMUNIZATION, IMM_ID + " = ?", new String[] {String.valueOf(id)});
    }
    public Immunization getImmunization(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_IMMUNIZATION + " WHERE " + IMM_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Immunization i = new Immunization();
        i.setId(c.getInt(c.getColumnIndex(IMM_ID)));
        i.setName(c.getString(c.getColumnIndex(IMM_NAME)));
        i.setDate(c.getString(c.getColumnIndex(IMM_DATE)));
        i.setDose(c.getInt(c.getColumnIndex(IMM_DOSE)));

        return i;
    }
    public List<Immunization> getAllImmunization() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_IMMUNIZATION;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Immunization> il = new ArrayList<Immunization>();
        if (c.moveToFirst()) {
            do {
                Immunization i = new Immunization();
                i.setId(c.getInt(c.getColumnIndex(IMM_ID)));
                i.setName(c.getString(c.getColumnIndex(IMM_NAME)));
                i.setDate(c.getString(c.getColumnIndex(IMM_DATE)));
                i.setDose(c.getInt(c.getColumnIndex(IMM_DOSE)));
                il.add(i);
            } while (c.moveToNext());
        }

        return il;
    }
    public void clearImmunization() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_IMMUNIZATION, null, null);
    }

    //allergy
    public void createAllergy(Allergy a) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ALL_NAME, a.getName());
        values.put(ALL_SYM, a.getSymptom());
        values.put(ALL_MEDI, a.getMedication());

        long Allergy_return = db.insert(TABLE_ALLERGY, null, values);
    }
    public void editAllergy(Allergy a, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ALL_NAME, a.getName());
        values.put(ALL_SYM, a.getSymptom());
        values.put(ALL_MEDI, a.getMedication());

        long Allergy_return = db.update(TABLE_ALLERGY, values, "_id=" + id, null);
    }
    public void deleteAllergy(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ALLERGY, ALL_ID + " = ?", new String[]{String.valueOf(id)});
    }
    public Allergy getAllergy(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_ALLERGY + " WHERE " + ALL_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Allergy a = new Allergy();
        a.setId(c.getInt(c.getColumnIndex(ALL_ID)));
        a.setName(c.getString(c.getColumnIndex(ALL_NAME)));
        a.setSymptom(c.getString(c.getColumnIndex(ALL_SYM)));
        a.setMedication(c.getString(c.getColumnIndex(ALL_MEDI)));

        return a;
    }
    public List<Allergy> getAllAlergy() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_ALLERGY;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Allergy> al = new ArrayList<Allergy>();
        if (c.moveToFirst()) {
            do {
                Allergy a = new Allergy();
                a.setId(c.getInt(c.getColumnIndex(ALL_ID)));
                a.setName(c.getString(c.getColumnIndex(ALL_NAME)));
                a.setSymptom(c.getString(c.getColumnIndex(ALL_SYM)));
                a.setMedication(c.getString(c.getColumnIndex(ALL_MEDI)));
                al.add(a);
            } while (c.moveToNext());
        }

        return al;
    }
    public void clearAllergy() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ALLERGY, null, null);
    }

    //condition
    public void createCondition(Condition c) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CON_NAME, c.getName());
        values.put(CON_DESC, c.getDescription());

        long Condition_return = db.insert(TABLE_CONDITION, null, values);
    }
    public void editCondition(Condition c, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CON_NAME, c.getName());
        values.put(CON_DESC, c.getDescription());

        long Condition_return = db.update(TABLE_CONDITION, values, "_id=" + id, null);
    }
    public void deleteCondition(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONDITION, ALL_ID + " = ?", new String[] {String.valueOf(id)});
    }
    public Condition getCondition(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_CONDITION + " WHERE " + ALL_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Condition co = new Condition();
        co.setId(c.getInt(c.getColumnIndex(CON_ID)));
        co.setName(c.getString(c.getColumnIndex(CON_NAME)));
        co.setDescription(c.getString(c.getColumnIndex(CON_DESC)));

        return co;
    }
    public List<Condition> getAllCondition() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_CONDITION;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Condition> col = new ArrayList<Condition>();
        if (c.moveToFirst()) {
            do {
                Condition co = new Condition();
                co.setId(c.getInt(c.getColumnIndex(CON_ID)));
                co.setName(c.getString(c.getColumnIndex(CON_NAME)));
                co.setDescription(c.getString(c.getColumnIndex(CON_DESC)));
                col.add(co);
            } while (c.moveToNext());
        }

        return col;
    }
    public void clearCondition() {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_CONDITION, null, null);
    }
}
