package com.sqlite;

// Це імпорт необхідних бібліотек для роботи коду.
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
// Це клас, який створюється.
public class WelcomeActivity extends AppCompatActivity {
    // Це оголошує кнопки, які використовуються в коді.
    private Button main_btn;
    private Button sup_btn;

    @Override
    // Це метод, який викликається під час створення дії.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Це налаштування макета активності на привітальний макет.
        setContentView(R.layout.welcome);
        // Це встановлення кнопки на кнопку, яка є в макеті.
        main_btn = findViewById(R.id.main_btn);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            // Це код, який викликається при натисканні кнопки.
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CarListActivity.class));
            }
        });

        // Це встановлення кнопки на кнопку, яка є в макеті.
        sup_btn = findViewById(R.id.sup_btn);
        sup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            // Це код, який викликається при натисканні кнопки.
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CarListActivity.class));
            }
        });

    }
}
