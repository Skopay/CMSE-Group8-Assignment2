package com.cmsegroup8.searchba.Matt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cmsegroup8.searchba.R;
import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form);

        CardForm cardForm = findViewById(R.id.cardForm);
        TextView amount = findViewById(R.id.payment_amount);
        Button payButton = findViewById(R.id.btn_pay);

        amount.setText("Order amount");
        payButton.setText("Pay Now");

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(Payment.this, "Payment Succeessful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
