package com.sqlite;

// This is importing the necessary libraries for the code to work.
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


// This is the class that is being created.
public class WelcomeActivity extends AppCompatActivity {
    // This is declaring the buttons that are being used in the code.
    private Button main_btn;
    private Button sup_btn;


    @Override
    // This is the method that is being called when the activity is created.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This is setting the layout of the activity to the welcome layout.
        setContentView(R.layout.welcome);

        // This is setting the button to the button that is in the layout.
        main_btn = findViewById(R.id.main_btn);
        main_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            // This is the code that is being called when the button is clicked.
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), CarListActivity.class));
            }
        });

        // This is setting the button to the button that is in the layout.
        sup_btn = findViewById(R.id.sup_btn);
        sup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            // This is the code that is being called when the button is clicked.
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CarListActivity.class));
            }
        });

    }
}
