/**
 * Це клас, який керує базою даних
 */
package com.sqlite;

// Імпорт необхідних бібліотек для бази даних.
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {

    // Створює новий екземпляр класу DatabaseHelper.
    private DatabaseHelper dbHelper;

    // Це змінна, яка зберігає контекст програми.
    private Context context;

    // Це змінна, яка зберігає базу даних.
    private SQLiteDatabase database;

    // Це конструктор, який ініціалізує контекст.
    public DBManager(Context c) {
        context = c;
    }

    // Створює новий екземпляр класу DatabaseHelper.
    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        // Це метод, який повертає об'єкт бази даних, який можна використовувати для читання та запису даних.
        database = dbHelper.getWritableDatabase();
        // Повертає поточний об'єкт.
        return this;
    }

    /**
     * Функція close() закриває базу даних
     */
    public void close() {
        dbHelper.close();
    }

    // Вставляє значення в базу даних.
    public void insert(String name, String desc, String txtcolor, String txtbodytype, String txtcountry, String txtdrive, String txtfuel, String txtgearbox, String txtyear, String txtcost) {
        // Це клас, який використовується для зберігання набору значень, які може обробляти ContentResolver.
        ContentValues contentValue = new ContentValues();
        // Це метод, який вставляє значення в базу даних.
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
        // Вставляє значення в базу даних.
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }


    public Cursor fetch() {
        // Це масив рядків, який містить стовпці бази даних.
        String[] columns = new String[] { DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR, DatabaseHelper.COST};
        // Це запит, який повертає всі рядки бази даних.
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        // Це перевірка, що курсор не порожній.
        if (cursor != null) {
            cursor.moveToFirst();
        }
        // Повертає курсор.
        return cursor;
    }

    // Він оновлює базу даних.
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
     * Видалити з бази даних рядок із заданим ідентифікатором.
     *
     * @param _id Ідентифікатор рядка, який потрібно видалити.
     */
    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.CAR_ID + "=" + _id, null);
    }

}
