package com.cmsegroup8.PlantATree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form);


        Palm_Tree palm_tree = new Palm_Tree();
        int Final_price = palm_tree.q * palm_tree.price;

        CardForm cardForm = findViewById(R.id.cardForm);
        TextView amount = findViewById(R.id.payment_amount);
        Button payButton = findViewById(R.id.btn_pay);

        amount.setTextSize(16);
        amount.setText("$" + palm_tree.quantity);
        payButton.setText("Pay Now");

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {

                Toast.makeText(Payment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                Intent start_home = new Intent(Payment.this, Home.class);
                startActivity(start_home);
            }
        });
    }

}
