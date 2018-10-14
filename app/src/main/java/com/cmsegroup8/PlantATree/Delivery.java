package com.cmsegroup8.PlantATree;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Delivery extends AppCompatActivity {

    String firstName, lastName;
    Button submitButton;
    RadioGroup radioGroup;
    RadioButton pickupRadioButton, deliveryRadioButton;
    EditText firstNameInput;
    EditText lastNameInput;
    static int delivery_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_options);

        firstNameInput = findViewById(R.id.firstName);
        firstNameInput.setHint("e.g Bob");
        lastNameInput = findViewById(R.id.lastName);
        lastNameInput.setHint("e.g Smith");

        radioGroup = findViewById(R.id.radioGroup);
        pickupRadioButton = findViewById(R.id.pickupRadioButton);
        pickupRadioButton.setChecked(true);
        deliveryRadioButton = findViewById(R.id.deliveryRadioButton);
        deliveryRadioButton.setChecked(false);


        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstName = firstNameInput.getText().toString();
                lastName = lastNameInput.getText().toString();

                if (firstName.isEmpty() | lastName.isEmpty()) {
                    showToast("Please enter your name.");
                } else {
                    Intent start_purchase = new Intent(Delivery.this, Payment.class);
                    startActivity(start_purchase);
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.pickupRadioButton:
                if (checked) delivery_price = 0;
                Toast.makeText(Delivery.this, "Pickup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.deliveryRadioButton:
                if (checked) delivery_price = 5;
                showAlertDialog();
                break;
        }
    }

    private void showToast(String text) {
        Toast.makeText(Delivery.this, text, Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Delivery.this);
        alertDialog.setTitle("One more step!");
        alertDialog.setMessage("Enter your address: ");

        final EditText editAddress = new EditText(Delivery.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        editAddress.setLayoutParams(lp);
        alertDialog.setView(editAddress);
        //alertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Delivery.this, "Address Confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }
}