package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameEditText = (EditText) findViewById(R.id.name_EditText);

        int price = calculatePrice(chocolateCheckBox.isChecked(), whippedCreamCheckBox.isChecked());
        createOrderSummary(nameEditText.getText().toString(),
                whippedCreamCheckBox.isChecked(),
                chocolateCheckBox.isChecked(),
                price);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    @org.jetbrains.annotations.Contract(pure = true)
    private int calculatePrice(boolean addChocolate, boolean addWhippedCream) {

        int newPrice = pricePerCup;

        if (addChocolate) {
            newPrice += 1;
        }

        if (addWhippedCream) {
            newPrice += 1;
        }

        return quantity * newPrice;
    }

    private void createOrderSummary(String name, boolean whippedCream, boolean chocolate, int price) {
        
        String priceMessage = "Name: "+ name +
                "\nAdd shipped cream? " + whippedCream +
                "\nAdd chocolate? " + chocolate +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nThank You!";
        displayMessage(priceMessage);
    }
}