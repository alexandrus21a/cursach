package com.sqlite;

// Це імпорт необхідних бібліотек для роботи діяльності.
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
// Це клас, який створюється. Він розширює клас Activity та реалізує
// OnClickListener.
public class AddCarActivity extends Activity implements OnClickListener {
    // Оголошення змінних, які використовуються в дії.
    private Button addTodoBtn;
    private EditText subjectEditText, descEditText, colorEdit, bodytypeEdit, countryEdit, driveEdit, fuelEdit, gearboxEdit, yearEdit, costEdit;
    private DBManager dbManager;
    // Це метод, який викликається під час створення дії. Це викликає суперклас
    // метод onCreate і передача savedInstanceState.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Установлення назви діяльності на «Додати запис».
        setTitle("Add Record");
        // Налаштування макета діяльності у файлі activity_add_record.xml.
        setContentView(R.layout.activity_add_record);
        // Це оголошення змінних, які використовуються в дії.
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
        // Створення нового екземпляра класу DBManager.
        dbManager = new DBManager(this);
        // Відкриття бази даних.
        dbManager.open();
        // Налаштування onClickListener на кнопку addTodoBtn.
        addTodoBtn.setOnClickListener(this);
    }
    // Це метод, який викликається при натисканні кнопки. Він перевіряє ідентифікатор
    // кнопка, яку клацають, а потім виконують відповідну дію.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Перевірка ідентифікатора кнопки, яку було натиснуто, а потім виконання відповідного
            // дія.
            case R.id.add_record:
                // Отримання тексту з полів EditText і перетворення їх у рядки.
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
                // Вставка даних у базу даних.
                dbManager.insert( name, desc, txtcolor, txtbodytype, txtcountry, txtdrive, txtfuel, txtgearbox, txtyear, txtcost);
                // Створення нового наміру та встановлення прапорів для очищення верхньої частини.
                Intent main = new Intent(AddCarActivity.this, CarListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Початок діяльності.
                startActivity(main);
                break;
        }
    }

}