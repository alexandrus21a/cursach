package com.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AddCountryActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText, descEditText, colorEdit, bodytypeEdit, countryEdit, driveEdit, fuelEdit, gearboxEdit, yearEdit, costEdit;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_add_record);
        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);
        colorEdit = (EditText) findViewById(R.id.color1);
        bodytypeEdit = (EditText) findViewById(R.id.Body_type1);
        countryEdit = (EditText) findViewById(R.id.Country_of_origin1);
        driveEdit = (EditText) findViewById(R.id.Drive_type1);
        fuelEdit = (EditText) findViewById(R.id.Fuel_type1);
        gearboxEdit = (EditText) findViewById(R.id.Type_of_gearbox1);
        yearEdit = (EditText) findViewById(R.id.Year1);
        costEdit = (EditText) findViewById(R.id.Cost1);
        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:
                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();
                final String txtcolor =colorEdit.getText().toString();
                final String txtbodytype =bodytypeEdit.getText().toString();
                final String txtcountry =countryEdit.getText().toString();
                final String txtdrive =driveEdit.getText().toString();
                final String txtfuel =fuelEdit.getText().toString();
                final String txtgearbox =gearboxEdit.getText().toString();
                final String txtyear =yearEdit.getText().toString();
                final String txtcost =costEdit.getText().toString();
                dbManager.insert( name, desc, txtcolor, txtbodytype, txtcountry, txtdrive, txtfuel, txtgearbox, txtyear, txtcost);

                Intent main = new Intent(AddCountryActivity.this, CountryListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}