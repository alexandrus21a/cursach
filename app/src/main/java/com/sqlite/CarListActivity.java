package com.sqlite;

// The above code is importing the necessary libraries for the application to run.
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
 * This class is a subclass of the AppCompatActivity class.
 */
public class CarListActivity extends AppCompatActivity {


    // Creating a new instance of the DBManager class.
    private DBManager dbManager;

    // Creating a new instance of the ListView class.
    private ListView listView;

    // This is a method that is used to notify the adapter that the data has changed.
    private SimpleCursorAdapter adapter;

    // This is a string array that is used to store the column names of the database.
    final String[] from = new String[]{DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR, DatabaseHelper.COST};
    final int[] to = new int[]{R.id.id, R.id.title, R.id.desc, R.id.txtcolor, R.id.txtfuel, R.id.txtxyear, R.id.txtcost};
    // This is a variable that is used to store the view.
    private View v;

    // This is a method that is used to create the activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This is a method that is used to set the content view of the activity.
        setContentView(R.layout.fragment_emp_list);

        // This is creating a new instance of the DBManager class.
        dbManager = new DBManager(this);
        // Opening the database.
        dbManager.open();
        // This is a method that is used to fetch the data from the database.
        Cursor cursor = dbManager.fetch();

        // This is a method that is used to find the view by its id.
        listView = (ListView) findViewById(R.id.list_view);
        // This is a method that is used to set the empty view of the list.
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        // This is a method that is used to notify the adapter that the data has changed.
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // This is a method that is used to set the on click listener for the list view.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                // This is a method that is used to find the view by its id.
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);
                TextView Colortxt = (TextView) view.findViewById(R.id.txtcolor);
                TextView fueltext = (TextView) view.findViewById(R.id.txtfuel);
                TextView yeartext =(TextView) view.findViewById(R.id.txtxyear);
                TextView costtext =(TextView) view.findViewById(R.id.txtcost);


                // This is a method that is used to get the text from the text view.
                String id = idTextView.getText().toString();
                String title =titleTextView.getText().toString();
                String desc = descTextView.getText().toString();
                String txtcolor =Colortxt.getText().toString();
                String txtfuel = fueltext.getText().toString();
                String txtxyear = yeartext.getText().toString();
                String txtcost = costtext.getText().toString();

                // This is creating a new intent that is used to start the ModifyCarActivity class.
                Intent modify_intent = new Intent(getApplicationContext(), ModifyCarActivity.class);
                // This is a method that is used to put the extra data into the intent.
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("txtcolor", txtcolor);
                modify_intent.putExtra("txtfuel", txtfuel);
                modify_intent.putExtra("txtxyear", txtxyear);
                modify_intent.putExtra("txtcost",txtcost);
                // This is a method that is used to start the activity.
                startActivity(modify_intent);
            }
        });

    }


    // This is a method that is used to create the options menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // This is a method that is used to create the options menu.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // This is a method that is used to get the id of the item.
        int id = item.getItemId();
        if (id == R.id.add_record) {

            // This is creating a new intent that is used to start the AddCarActivity class.
            Intent add_mem = new Intent(this, AddCarActivity.class);
            startActivity(add_mem);
        }
        // This is a method that is used to return the item that is selected.
        return super.onOptionsItemSelected(item);
    }

}