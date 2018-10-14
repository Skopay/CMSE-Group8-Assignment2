package com.cmsegroup8.PlantATree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class Butternut_Tree extends AppCompatActivity {

    static String quantity;
    ElegantNumberButton quantityButton;
    static int q = 0;
    static int price = 60;
    static boolean purchased;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butternut__tree);

        purchased = false;

        ImageView butter_tree = findViewById(R.id.Butternuttree);
        int imageResource = getResources().getIdentifier("@drawable/butternuttree", null, this.getPackageName());
        butter_tree.setImageResource(imageResource);

        TextView facts = findViewById(R.id.Facts);
        facts.setText("Facts");

        TextView commonname = findViewById(R.id.common_name);
        commonname.setText("Common Name: Butternut");

        TextView tree_info = findViewById(R.id.Tree_info);
        tree_info.setText("Tree Info");

        TextView price_title = findViewById(R.id.Price_Title);
        price_title.setText("Price");

        final TextView price = findViewById(R.id.Price);
        price.setText("$60.00 Each");

        quantityButton = findViewById(R.id.quantity_button);
        quantityButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                quantity = quantityButton.getNumber();
                q = Integer.parseInt(quantity);

            }
        });

        Button purch = findViewById(R.id.purchase);
        purch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                purchased = false;
                Intent start_delivery = new Intent(Butternut_Tree.this, Delivery.class);
                startActivity(start_delivery);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.navigation_Search) {
            Intent startsearch = new Intent(this, SearchFilter.class);
            startActivity(startsearch);
        }

        if (id == R.id.navigation_home) {
            Intent starttree1 = new Intent(this, Home.class);
            startActivity(starttree1);
        }
        return super.onOptionsItemSelected(item);
    }
}
