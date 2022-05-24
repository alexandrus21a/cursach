package com.sqlite;

// Наведений вище код імпортує необхідні бібліотеки для запуску програми.
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;



/**
 * Цей клас є підкласом класу AppCompatActivity.
 */
public class CarListActivity extends AppCompatActivity {


    // Створення нового екземпляра класу DBManager.
    private DBManager dbManager;

    // Створення нового екземпляра класу ListView.
    private ListView listView;

    // Це метод, який використовується для повідомлення адаптера про зміну даних.
    private SimpleCursorAdapter adapter;

    // Це масив рядків, який використовується для зберігання імен стовпців бази даних.
    final String[] from = new String[]{DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR, DatabaseHelper.COST};
    final int[] to = new int[]{R.id.id, R.id.title, R.id.desc, R.id.txtcolor, R.id.txtfuel, R.id.txtxyear, R.id.txtcost};
    // Це змінна, яка використовується для зберігання представлення.
    private View v;
    // Це метод, який використовується для створення діяльності.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Це метод, який використовується для встановлення перегляду вмісту діяльності.
        setContentView(R.layout.fragment_emp_list);
        // Це створює новий екземпляр класу DBManager.
        dbManager = new DBManager(this);
        // Відкриття бази даних.
        dbManager.open();
        // Це метод, який використовується для отримання даних з бази даних.
        Cursor cursor = dbManager.fetch();
        // Це метод, який використовується для пошуку представлення за його ідентифікатором.
        listView = (ListView) findViewById(R.id.list_view);
        // Це метод, який використовується для встановлення пустого перегляду списку.
        listView.setEmptyView(findViewById(R.id.empty));
        // Це метод, який використовується для повідомлення адаптера про зміну даних.
        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        // OnCLickListiner для елементів списку
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // Це метод, який використовується для встановлення прослуховування при натисканні для перегляду списку.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                // Це метод, який використовується для пошуку представлення за його ідентифікатором.
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);
                TextView Colortxt = (TextView) view.findViewById(R.id.txtcolor);
                TextView fueltext = (TextView) view.findViewById(R.id.txtfuel);
                TextView yeartext =(TextView) view.findViewById(R.id.txtxyear);
                TextView costtext =(TextView) view.findViewById(R.id.txtcost);
                // Це метод, який використовується для отримання тексту з текстового перегляду.
                String id = idTextView.getText().toString();
                String title =titleTextView.getText().toString();
                String desc = descTextView.getText().toString();
                String txtcolor =Colortxt.getText().toString();
                String txtfuel = fueltext.getText().toString();
                String txtxyear = yeartext.getText().toString();
                String txtcost = costtext.getText().toString();
                // Це створює новий намір, який використовується для запуску класу ModifyCarActivity.
                Intent modify_intent = new Intent(getApplicationContext(), ModifyCarActivity.class);
                // Це метод, який використовується для розміщення додаткових даних у intent.
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("txtcolor", txtcolor);
                modify_intent.putExtra("txtfuel", txtfuel);
                modify_intent.putExtra("txtxyear", txtxyear);
                modify_intent.putExtra("txtcost",txtcost);
                // Це метод, який використовується для початку дії.
                startActivity(modify_intent);
            }
        });

    }


    // Це метод, який використовується для створення меню параметрів.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Це метод, який використовується для створення меню параметрів.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Це метод, який використовується для отримання ідентифікатора елемента.
        int id = item.getItemId();
        if (id == R.id.add_record) {

            // Це створює новий намір, який використовується для запуску класу AddCarActivity.
            Intent add_mem = new Intent(this, AddCarActivity.class);
            startActivity(add_mem);
        }
        // Це метод, який використовується для повернення вибраного елемента.
        return super.onOptionsItemSelected(item);
    }

}