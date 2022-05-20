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
    public static final String BODY_TYPE = "Body";
    public static final String FUEL_TYPE = "Fuel";
    public static final String DRIVE_TYPE = "Drive";
    public static final String TYPE_OF_GEARBOX = "Type";
    public static final String COUNTRY_OF_ORIGIN = "Country";
    public static final String YEAR = "Year";
    public static final String COST = "Cost";



    // Database Information
    static final String DB_NAME = "avto.db";

    // database version
    static final int DB_VERSION = 1;



    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VENDOR + " varchar(255), " + MODEL + " varchar(255), " + COLOR + " varchar(255), " + BODY_TYPE + " varchar(255), " + FUEL_TYPE + " varchar(255), " + DRIVE_TYPE + " varchar(255), " + TYPE_OF_GEARBOX + " varchar(255), " + COUNTRY_OF_ORIGIN + " varchar(255), " + YEAR + " year(4),  " + COST + " int(11) );";


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
