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

    int tree_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form);

        if (Palm_Tree.purchased == true && Arborvitae.purchased == false && Butternut_Tree.purchased == false) {

            tree_price = (Palm_Tree.q * Palm_Tree.price) + Delivery.delivery_price;

        } else if (Palm_Tree.purchased == true && Arborvitae.purchased == true && Butternut_Tree.purchased == false) {

            tree_price = (Palm_Tree.q * Palm_Tree.price) + (Arborvitae.q + Arborvitae.price) + Delivery.delivery_price;

        } else if (Palm_Tree.purchased == true && Arborvitae.purchased == true && Butternut_Tree.purchased == true) {

            tree_price = (Palm_Tree.q * Palm_Tree.price) + (Arborvitae.q + Arborvitae.price) + (Butternut_Tree.q + Butternut_Tree.price) + Delivery.delivery_price;

        } else if (Arborvitae.purchased == true && Palm_Tree.purchased == false && Butternut_Tree.purchased == false) {

            tree_price = (Arborvitae.q + Arborvitae.price) + Delivery.delivery_price;

        } else if (Palm_Tree.purchased == true && Arborvitae.purchased == true && Butternut_Tree.purchased == false) {

            tree_price = (Palm_Tree.q * Palm_Tree.price) + (Arborvitae.q + Arborvitae.price) + Delivery.delivery_price;

        } else if (Palm_Tree.purchased == false && Arborvitae.purchased == false && Butternut_Tree.purchased == true) {

            tree_price = (Butternut_Tree.q + Butternut_Tree.price) + Delivery.delivery_price;

        } else if (Palm_Tree.purchased == true && Arborvitae.purchased == false && Butternut_Tree.purchased == true) {

            tree_price = (Palm_Tree.q * Palm_Tree.price) + (Butternut_Tree.q + Butternut_Tree.price) + Delivery.delivery_price;

        }

        CardForm cardForm = findViewById(R.id.cardForm);
        TextView amount = findViewById(R.id.payment_amount);
        Button payButton = findViewById(R.id.btn_pay);

        amount.setTextSize(16);
        amount.setText("$" + tree_price);
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
