package com.cmsegroup8.PlantATree;

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

        ImageView arbotree = findViewById(R.id.Arbo_tree);

        int imageResource = getResources().getIdentifier("@drawable/arbotree", null, this.getPackageName());
        arbotree.setImageResource(imageResource);

        TextView arboname = findViewById(R.id.common_name);
        TextView arboinfo = findViewById(R.id.arbo_info);



        Button purchase = findViewById(R.id.purchase);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_purchase = new Intent(Arborvitae.this, Delivery.class);
                startActivity(start_purchase);

            }
        });

    }
}
