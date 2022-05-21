package com.sqlite;

/**
 * Created by anupamchugh on 19/10/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class ModifyCountryActivity extends Activity implements OnClickListener {

    private EditText descText, colorText, fuelText, yearText, costText;
    private TextView descTextView, colorTextView, fuelTextView, yearTextView,textsd;
    private Button updateBtn, deleteBtn;


    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setTitle("Modify Record");

        setContentView(R.layout.activity_modify_record);

        dbManager = new DBManager(this);
        dbManager.open();
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
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String txtcolor = intent.getStringExtra("txtcolor");
        String txtfuel = intent.getStringExtra("txtfuel");
        String txtyear = intent.getStringExtra("txtyear");
        String txtcost = intent.getStringExtra("txtcost");

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

    public void showToast(View view) {
        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.Success, Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.drawable.check);
        toastContainer.addView(catImageView, 0);
        toast3.show();
    }

    @Override
    public void onClick(View v) {
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

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), CountryListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
