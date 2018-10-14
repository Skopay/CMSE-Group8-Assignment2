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

public class Arborvitae extends AppCompatActivity {

    static String quantity;
    ElegantNumberButton quantityButton;
    static int q = 0;
    static int price = 25;
    static boolean purchased;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arborvitae);

        //sets boolean purchased to false
        purchased = false;

        /*defines imageveiw arbotree and links the veiw Arbo_tree
         * sets image veiw arbotree to have the image arbotree.jpg.jpg*/
        ImageView arbotree = findViewById(R.id.Arbo_tree);
        int imageResource = getResources().getIdentifier("@drawable/arbortree", null, this.getPackageName());
        arbotree.setImageResource(imageResource);

        //defines textveiw and sets the text value
        TextView facts = findViewById(R.id.Facts);
        facts.setText("Facts");

        //defines textveiw and sets the text value
        TextView commonname = findViewById(R.id.common_name);
        commonname.setText("Common Name: Arborvitae");

        //defines textveiw and sets the text value
        TextView tree_info = findViewById(R.id.Tree_info);
        tree_info.setText("Arborvitae is a medium sized, slow growing, forest tree. The wood is light, soft, brittle, coarse grained, light yellowish and brown in colour, and is durable in contact with soil. Used in small poles and fence posts.");

        //defines textveiw and sets the text value
        TextView price_title = findViewById(R.id.Price_Title);
        price_title.setText("Price");

        //defines textveiw and sets the text value
        final TextView price = findViewById(R.id.Price);
        price.setText("$25.00 Each");

        /*defines imageveiw palmtree and links the veiw palmtree
         * sets image veiw palm tree to have the image palmtree.jpg*/
        quantityButton = findViewById(R.id.quantity_button);
        quantityButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                quantity = quantityButton.getNumber();
                q = Integer.parseInt(quantity);

            }
        });

        /*Defines the button and links with the veiw purchase
         * once the button is clicked boolean purchased is set to true
         * and the user is directed to the delivery activity*/
        Button purch = findViewById(R.id.purchase);
        purch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                purchased = true;
                Intent start_delivery = new Intent(Arborvitae.this, Delivery.class);
                startActivity(start_delivery);
            }
        });
    }
}