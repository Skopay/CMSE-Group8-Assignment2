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

public class Palm_Tree extends AppCompatActivity {

    //Variable declaration
    static String quantity;
    ElegantNumberButton quantityButton;
    static int q = 0;
    static int price = 30;
    static boolean purchased;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palm);

        //Sets variable purchased to false
        purchased = false;

        /*defines imageveiw palmtree and links the veiw palmtree
         * sets image veiw palm tree to have the image palmtree.jpg*/
        ImageView palmtree = findViewById(R.id.palmtree);
        int imageResource = getResources().getIdentifier("@drawable/palmtree", null, this.getPackageName());
        palmtree.setImageResource(imageResource);

        //defines textveiw and sets the text value
        TextView facts = findViewById(R.id.Facts);
        facts.setText("Facts");

        //defines textveiw facts and sets the text value
        TextView commonname = findViewById(R.id.common_name);
        commonname.setText("Common Name: Palm");

        //defines textveiw facts and sets the text value
        TextView tree_info = findViewById(R.id.Tree_info);
        tree_info.setText("Palms are one of the best known and most widely planted tree families." + "They have held an important role for humans throughout much of history." + "Many common products and foods come from palms." + "They are often used in parks and gardens that are in areas that do not have heavy frosts." + "In the past palms were symbols of victory, peace, and fertility." + "Today palms are a popular symbol for the tropics and for vacations.");

        //defines textveiw facts and sets the text value
        TextView price_title = findViewById(R.id.Price_Title);
        price_title.setText("Price");

        //defines textveiw facts and sets the text value
        final TextView price = findViewById(R.id.Price);
        price.setText("$30.00 Each");

        /*Defines the ElegantnumberButton and links to the veiw quantity_button*/
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
                Intent start_delivery = new Intent(Palm_Tree.this, Delivery.class);
                startActivity(start_delivery);
            }
        });
    }
}
