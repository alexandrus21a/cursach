/**
 * It's a class that manages the database
 */
package com.sqlite;

// Importing the necessary libraries for the database.
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * It manages the database.
 */
public class DBManager {

    // It creates a new instance of the DatabaseHelper class.
    private DatabaseHelper dbHelper;

    // It's a variable that stores the context of the application.
    private Context context;

    // It's a variable that stores the database.
    private SQLiteDatabase database;

    // It's a constructor that initializes the context.
    public DBManager(Context c) {
        context = c;
    }

    // It creates a new instance of the DatabaseHelper class.
    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        // It's a method that returns a database object that can be used to read and write data.
        database = dbHelper.getWritableDatabase();
        // It returns the current object.
        return this;
    }

    /**
     * The close() function closes the database
     */
    public void close() {
        dbHelper.close();
    }

    // It inserts the values into the database.
    public void insert(String name, String desc, String txtcolor, String txtbodytype, String txtcountry, String txtdrive, String txtfuel, String txtgearbox, String txtyear, String txtcost) {
        // It's a class that is used to store a set of values that the ContentResolver can process.
        ContentValues contentValue = new ContentValues();
        // It's a method that inserts the values into the database.
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
        // It inserts the values into the database.
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }


    public Cursor fetch() {/*Записать а*/
        // It's a string array that contains the columns of the database.
        String[] columns = new String[] { DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR, DatabaseHelper.COST};
        // It's a query that returns all the rows of the database.
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        // It's a check that the cursor is not empty.
        if (cursor != null) {
            cursor.moveToFirst();
        }
        // It returns the cursor.
        return cursor;
    }

    // It updates the database.
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

    /**
     * Delete the row with the given id from the database.
     *
     * @param _id The id of the row you want to delete.
     */
    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.CAR_ID + "=" + _id, null);
    }

}
