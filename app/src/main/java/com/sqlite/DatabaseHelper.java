package com.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anupamchugh on 19/10/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "avto1d";

    // Table columns
    public static final String CAR_ID = "_id";
    public static final String VENDOR = "Vendor";
    public static final String MODEL = "Model";
    public static final String COLOR = "Color";
    public static final String BODY_TYPE = "Body type";
    public static final String FUEL_TYPE = "Fuel type";
    public static final String DRIVE_TYPE = "Drive type";
    public static final String TYPE_OF_GEARBOX = "Type of gearbox";
    public static final String COUNTRY_OF_ORIGIN = "Country of origin";
    public static final String YEAR = "Year";
    public static final String COST = "Cost";



    // Database Information
    static final String DB_NAME = "avto.sql";

    // database version
    static final int DB_VERSION = 1;



    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VENDOR + " varchar(255) NOT NULL, " + MODEL + " varchar(255) NOT NULL, " + COLOR + " varchar(255) NOT NULL, " + BODY_TYPE + " varchar(255) NOT NULL, " + FUEL_TYPE + " varchar(255) NOT NULL, " + DRIVE_TYPE + " varchar(255) NOT NULL, " + TYPE_OF_GEARBOX + " varchar(255) NOT NULL, " + COUNTRY_OF_ORIGIN + " varchar(255) NOT NULL, " + YEAR + " year(4) NOT NULL, " + COST + " int(11) );";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
