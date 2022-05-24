package com.sqlite;


// Це імпорт необхідних бібліотек для роботи діяльності.
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * Цей клас – це діяльність, яка дозволяє користувачеві модифікувати автомобіль
 */
public class ModifyCarActivity extends Activity implements OnClickListener {

    // Це оголошення змінних, які будуть використані в дії.
    private EditText descText, colorText, fuelText, yearText, costText;
    private TextView descTextView, colorTextView, fuelTextView, yearTextView,textsd;
    private Button updateBtn, deleteBtn;


    private long _id;

    private DBManager dbManager;

    @Override
    // Це метод, який викликається під час створення дії.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Це встановлення назви діяльності.
        setTitle("Modify Record");

        // Налаштування макета діяльності.
        setContentView(R.layout.activity_modify_record);

        // Це створює новий екземпляр класу DBManager.
        dbManager = new DBManager(this);
        // Відкриття бази даних.
        dbManager.open();
        // Це оголошення змінних, які будуть використані в дії.
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
        // Це отримання наміру, який був переданий діяльності.
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String txtcolor = intent.getStringExtra("txtcolor");
        String txtfuel = intent.getStringExtra("txtfuel");
        String txtyear = intent.getStringExtra("txtyear");
        String txtcost = intent.getStringExtra("txtcost");
        // Це отримання наміру, який був переданий діяльності.
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
     * Показує тост із зображенням.
     */

    public void showToast(View view) {
        // Створення тостового повідомлення.
        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.Success, Toast.LENGTH_LONG);
        // Це встановлення тяжкості повідомлення тосту в центрі екрана.
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        // Додавання зображення до повідомлення про тост.
        ImageView carImageView = new ImageView(getApplicationContext());
        carImageView.setImageResource(R.drawable.check);
        toastContainer.addView(carImageView, 0);
        // Показ повідомлення про тост.
        toast3.show();
    }

    // Це перевизначає метод onClick.
    @Override
    public void onClick(View v) {
        // Це оператор switch, який перевіряє ідентифікатор кнопки, яку було натиснуто. Якщо ідентифікатор
        // це кнопка оновлення, вона оновить автомобіль в базі даних. Якщо ідентифікатор - це видалення
        // кнопка видалить автомобіль з бази даних.
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

    // Цей метод повертає користувача на головний екран.
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), CarListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
