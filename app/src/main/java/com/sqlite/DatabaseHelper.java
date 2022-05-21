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
    public static final String KEY_IMG_URL = "ImgFavourite";


    // Database Information
    static final String DB_NAME = "avto1.db";

    // database version
    static final int DB_VERSION = 1;


    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VENDOR + " varchar(255), " + MODEL + " varchar(255), " + COLOR + " varchar(255), " + BODY_TYPE + " varchar(255), " + FUEL_TYPE + " varchar(255), " + DRIVE_TYPE + " varchar(255), " + TYPE_OF_GEARBOX + " varchar(255), " + COUNTRY_OF_ORIGIN + " varchar(255), " + YEAR + " year(4),  " + COST + " int(11) ," + KEY_IMG_URL+ " BLOB );";
    private static final String INSERT_TABLE = "insert into 'avto1d' ('Body', 'Color', 'Cost', 'Country', 'Drive', 'Fuel', 'Model', 'Type', 'Vendor', 'Year', '_id') values" +
            "('Хетчбек', 'Grey', 40000, 'Germany', 'AWD', 'Бензин', 'Golf', 'manual transmission', 'Volkswagen', 2020, 0),\n" +
            " ('Universal', 'Narda Grey', 70000, 'Germany', 'AWD', 'Бензин', 'RS6', 'automatic transmission', 'Audi', 2015, 1),\n" +
            " ('Седан', 'Yellow', 180000, 'Germany', 'AWD', 'Бензин', 'M8', 'automatic transmission', 'BMW', 2020, 2),\n" +
            " ('Купе', 'Red', 21000, 'Italy', 'RWD', 'Бензин', '124 ', 'manual transmission', 'Fiat', 2016, 3),\n" +
            " ('Седан', 'Blue', 30000, 'Czhech', 'FWD', 'Бензин', 'Octavia RS', 'manual transmission', 'Skoda', 2022, 4),\n" +
            " ('Pickup', 'Black', 60000, 'USA', 'AWD', 'Бензин', 'F150', 'automatic transmission', 'Ford', 2018, 5),\n" +
            " ('SSUV', 'Yellow', 390000, 'Italy', 'AWD', 'Бензин', 'URUS', 'automatic transmission', 'Lamborghini', 2008, 6),\n" +
            " ('Купе', 'Black', 60000, 'USA', 'RWD', 'Бензин', 'Charger', 'manual transmission', 'Dodge', 2016, 7),\n" +
            "('Купе', 'Green', 480000, 'Italy', 'AWD', 'Бензин', 'Huracan', 'automatic transmission', 'Lamborghini', 2016, 8),\n" +
            " ('Кросовер', 'White', 75000, 'USA', 'AWD', 'Електро', 'Model X', 'automatic transmission', 'Tesla', 2021, 9),\n" +
            " ('Купе', 'Red', 340000, 'Italy', 'RWD', 'Бензин', '488 Spider', 'automatic transmission', 'Ferrari ', 2020, 10),\n" +
            " ('SUV', 'Grey', 54000, 'USA', 'AWD', 'Бензин', 'Explorer', 'automatic transmission', 'Ford', 2022, 11),\n" +
            " ('Купе', 'Grey', 45000, 'Japan', 'RWD', 'Бензин', 'Supra', 'manual transmission', 'Toyota', 2021, 12),\n" +
            " ('Седан', 'Black', 20000, 'Japan', 'AWD', 'Бензин', 'WRX', 'manual transmission', 'Subaru', 2020, 13),\n" +
            " ('Купе', 'Red', 790000, 'Italy', 'AWD', 'Бензин', 'Aventador LP 700-4', 'automatic transmission', 'Lamborghini', 2015, 14),\n" +
            " ('Купе', 'Orange-Black', 1900000, 'France', 'AWD', 'Бензин', 'Veyron', 'automatic transmission', 'Bugatti', 2018, 15),\n" +
            " ('Купе', 'Red', 1627000, 'Italy', 'RWD', 'Бензин', 'F40', 'manual transmission', 'Ferrari', 2018, 16),\n" +
            " ('Купе', 'Grey', 20500000, 'United Kingdom', 'RWD', 'Бензин', 'F1', 'automatic transmission', 'McLaren', 1986, 17),\n" +
            " ('Купе', 'Green', 1900000, 'USA', 'RWD', 'Бензин', 'GT40', 'automatic transmission', 'Ford', 2020, 18),\n" +
            " ('Купе', 'Grey', 514000, 'United Kingdom', 'RWD', 'Бензин', 'XJ220', 'manual transmission', 'Jaguar', 1981, 19),\n" +
            " ('Купе', 'Black', 9000, 'Germany', 'RWD', 'Бензин', 'E36', 'manual transmission', 'BMW', 1996, 20),\n" +
            " ('Cabrio', 'Light green', 27000, 'Canada', 'RWD', 'Бензин', 'Slingshot SL', 'manual transmission', 'Polaris', 2020, 21),\n" +
            " ('Купе', 'Blue', 84000, 'Germany', 'AWD', 'Електро', 'Taycan', 'automatic transmission', 'Porshe', 2021, 22),\n" +
            " ('SUV', 'Black', 130000, 'Germany', 'AWD', 'Бензин', 'G500', 'automatic transmission', 'Mercedes', 1998, 23),\n" +
            " ('Купе', 'Khaki', 1900000, 'France', 'RWD', 'Бензин', 'Venom F5', 'automatic transmission', 'Hennessey', 2021, 24);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
/*допилить!!!
    public Bitmap getTheImage(){
        Cursor cursor = (Cursor) DB_NAME.execSQL(" SELECT * FROM "+TABLE_NAME,null,null);
        if (cursor.moveToFirst()){
            byte[] imgByte =  cursor.getBlob(cursor.getColumnIndex(KEY_IMG_URL));
            cursor.close();
            return BitmapFactory.decodeByteArray(imgByte,0,imgByte.length);
        }
        return null;
    }*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERT_TABLE);
        System.out.println("Created table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
