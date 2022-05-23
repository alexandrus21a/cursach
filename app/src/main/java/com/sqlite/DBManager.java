package com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc, String txtcolor, String txtbodytype, String txtcountry, String txtdrive, String txtfuel, String txtgearbox, String txtyear, String txtcost) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.VENDOR, name);
        contentValue.put(DatabaseHelper.MODEL, desc);
        contentValue.put(DatabaseHelper.COLOR, txtcolor);
        contentValue.put(DatabaseHelper.BODY_TYPE, txtbodytype);
        contentValue.put(DatabaseHelper.COUNTRY_OF_ORIGIN,txtcountry );
        contentValue.put(DatabaseHelper.DRIVE_TYPE, txtdrive);
        contentValue.put(DatabaseHelper.FUEL_TYPE, txtfuel);
        contentValue.put(DatabaseHelper.TYPE_OF_GEARBOX, txtgearbox);
        contentValue.put(DatabaseHelper.YEAR, txtyear);
        contentValue.put(DatabaseHelper.COST, txtcost);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {/*Записать а*/
        String[] columns = new String[] { DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR, DatabaseHelper.COST};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String desc, String txtcolor, String txtfuel, String txtyear, String txtcost) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.MODEL, desc);
        contentValues.put(DatabaseHelper.COLOR, txtcolor);
        contentValues.put(DatabaseHelper.FUEL_TYPE, txtfuel);
        contentValues.put(DatabaseHelper.YEAR, txtyear);
        contentValues.put(DatabaseHelper.COST, txtcost);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.CAR_ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.CAR_ID + "=" + _id, null);
    }

}
