package com.sqlite;

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


public class CountryListActivity extends AppCompatActivity {


    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{DatabaseHelper.CAR_ID, DatabaseHelper.VENDOR, DatabaseHelper.MODEL, DatabaseHelper.COLOR, DatabaseHelper.FUEL_TYPE, DatabaseHelper.YEAR};

    final int[] to = new int[]{R.id.id, R.id.title, R.id.desc, R.id.txtcolor, R.id.txtfuel, R.id.txtxyear};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.string.app_name+R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.string.app_name+R.id.title);
                TextView descTextView = (TextView) view.findViewById(R.string.app_name+R.id.desc);
                TextView Colortxt = (TextView) view.findViewById(R.id.txtcolor);
                TextView fueltext = (TextView) view.findViewById(R.id.txtfuel);
                TextView yeartext =(TextView) view.findViewById(R.id.txtxyear);


                String id = idTextView.getText().toString();
                String title ="Vendor:"+ titleTextView.getText().toString();
                String desc = "Vendor:"+descTextView.getText().toString();
                String txtcolor ="Color:" +Colortxt.getText().toString();
                String txtfuel = "Fuel:"+fueltext.getText().toString();
                String txtxyear ="Year:"+ yeartext.getText().toString();


                Intent modify_intent = new Intent(getApplicationContext(), ModifyCountryActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("txtcolor", txtcolor);
                modify_intent.putExtra("txtfuel", txtfuel);
                modify_intent.putExtra("txtxyear", txtxyear);
                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddCountryActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}