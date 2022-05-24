package com.sqlite;


// This is importing the necessary libraries for the activity to work.
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * This class is an activity that allows the user to modify a car
 */
public class ModifyCarActivity extends Activity implements OnClickListener {

    // This is declaring the variables that will be used in the activity.
    private EditText descText, colorText, fuelText, yearText, costText;
    private TextView descTextView, colorTextView, fuelTextView, yearTextView,textsd;
    private Button updateBtn, deleteBtn;


    private long _id;

    private DBManager dbManager;

    @Override
    // This is the method that is called when the activity is created.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // This is setting the title of the activity.
        setTitle("Modify Record");

        // Setting the layout of the activity.
        setContentView(R.layout.activity_modify_record);

        // This is creating a new instance of the DBManager class.
        dbManager = new DBManager(this);
        // Opening the database.
        dbManager.open();
        // This is declaring the variables that will be used in the activity.
        textsd= (TextView) findViewById(R.id.title);
        descText = (EditText) findViewById(R.id.description_edittext);
        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        colorText = (EditText) findViewById(R.id.color1);
        fuelText = (EditText) findViewById(R.id.Fuel_type1);
        yearText = (EditText) findViewById(R.id.Year1);
        costText = (EditText) findViewById(R.id.Cost1);
        descTextView = (TextView) findViewById(R.id.desc);
        colorTextView = (TextView) findViewById(R.id.txtcolor);
        fuelTextView = (TextView) findViewById(R.id.txtfuel);
        yearTextView = (TextView) findViewById(R.id.txtxyear);
        // This is getting the intent that was passed to the activity.
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String txtcolor = intent.getStringExtra("txtcolor");
        String txtfuel = intent.getStringExtra("txtfuel");
        String txtyear = intent.getStringExtra("txtyear");
        String txtcost = intent.getStringExtra("txtcost");

        // This is getting the intent that was passed to the activity.
        _id = Long.parseLong(id);
        textsd.setText(title);
        descText.setText(desc);
        colorText.setText(txtcolor);
        fuelText.setText(txtfuel);
        yearText.setText(txtyear);
        costText.setText(txtcost);
        descTextView.setText(desc);
        colorTextView.setText(txtcolor);
        fuelTextView.setText(txtfuel);
        yearTextView.setText(txtyear);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    /**
     * It shows a toast message with an image.
     *
     * @param view The view to find a parent from.
     */
    public void showToast(View view) {
        // Creating a toast message.
        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.Success, Toast.LENGTH_LONG);
        // This is setting the gravity of the toast message to the center of the screen.
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        // Adding an image to the toast message.
        ImageView carImageView = new ImageView(getApplicationContext());
        carImageView.setImageResource(R.drawable.check);
        toastContainer.addView(carImageView, 0);
        // Showing the toast message.
        toast3.show();
    }

    // This is overriding the onClick method.
    @Override
    public void onClick(View v) {
        // This is a switch statement that is checking the id of the button that was clicked. If the id
        // is the update button, it will update the car in the database. If the id is the delete
        // button, it will delete the car from the database.
        switch (v.getId()) {
            case R.id.btn_update:
                String desc = descText.getText().toString();
                String txtcolor = colorText.getText().toString();
                String txtfuel = fuelText.getText().toString();
                String txtyear = yearText.getText().toString();
                String txtcost = costText.getText().toString();

                dbManager.update(_id, desc, txtcolor, txtfuel, txtyear, txtcost);
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;
        }
    }

    // This method is returning the user to the home screen.
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), CarListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
