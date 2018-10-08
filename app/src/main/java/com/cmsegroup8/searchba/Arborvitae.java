package com.cmsegroup8.searchba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Arborvitae extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arborvitae);

        ImageView arbotree = (ImageView) findViewById(R.id.Arbo_tree);
        TextView arboname = (TextView) findViewById(R.id.common_name);
        TextView arboinfo = (TextView) findViewById(R.id.arbo_info);

        Button purchase = (Button) findViewById(R.id.purchase);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_purchase = new Intent(Arborvitae.this, Delivery.class);
                startActivity(start_purchase);

            }
        });

    }
}
