package com.example.mac.whoseturntopay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddMealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        Spinner spinner = (Spinner) findViewById(R.id.who_paid_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.who_paid_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        EditText date = (EditText) findViewById(R.id.date_text);
        date.setText(new StringBuilder()
                .append(mDay).append("/")
                // Month is 0 based so add 1
                .append(mMonth + 1).append("/")
                .append(mYear));
    }

    public void AddNewMeal(View view)
    {
        EditText restaurant = (EditText)findViewById(R.id.restaurant_text);
        EditText amount = (EditText)findViewById(R.id.amount_text);
        EditText date = (EditText)findViewById(R.id.date_text);

        if( restaurant.getText().toString().length() == 0 )
            restaurant.setError( "Restaurant name is required!" );
        else if (amount.getText().toString().length() == 0)
            amount.setError( "Amount paid is required!" );
        else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}


