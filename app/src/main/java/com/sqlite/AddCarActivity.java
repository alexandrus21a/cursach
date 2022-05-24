package com.sqlite;

// This is importing the necessary libraries for the activity to work.
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


// This is the class that is being created. It is extending the Activity class and implementing the
// OnClickListener.
public class AddCarActivity extends Activity implements OnClickListener {

    // Declaring the variables that are used in the activity.
    private Button addTodoBtn;
    private EditText subjectEditText, descEditText, colorEdit, bodytypeEdit, countryEdit, driveEdit, fuelEdit, gearboxEdit, yearEdit, costEdit;
    private DBManager dbManager;

    // This is the method that is called when the activity is created. It is calling the super class
    //         onCreate method and passing the savedInstanceState.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setting the title of the activity to "Add Record".
        setTitle("Add Record");

        // Setting the layout of the activity to the activity_add_record.xml file.
        setContentView(R.layout.activity_add_record);
        // This is declaring the variables that are used in the activity.
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

        // Creating a new instance of the DBManager class.
        dbManager = new DBManager(this);
        // Opening the database.
        dbManager.open();
        // Setting the onClickListener to the addTodoBtn button.
        addTodoBtn.setOnClickListener(this);
    }

    // This is the method that is called when the button is clicked. It is checking the id of the
    //         button that is clicked and then performing the appropriate action.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Checking the id of the button that is clicked and then performing the appropriate
            // action.
            case R.id.add_record:
                // Getting the text from the EditText fields and converting them to strings.
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
                // Inserting the data into the database.
                dbManager.insert( name, desc, txtcolor, txtbodytype, txtcountry, txtdrive, txtfuel, txtgearbox, txtyear, txtcost);

                // Creating a new intent and setting the flags to clear the top.
                Intent main = new Intent(AddCarActivity.this, CarListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // Starting the activity.
                startActivity(main);
                break;
        }
    }

}