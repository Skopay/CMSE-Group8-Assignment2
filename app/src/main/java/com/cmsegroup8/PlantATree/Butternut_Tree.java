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

        //sets boolean purchased to false
        purchased = false;

        /*defines imageveiw butter_tree and links the veiw Butternuttree
         * sets image veiw butter_tree to have the image butternuttree.jpg*/
        ImageView butter_tree = findViewById(R.id.Butternuttree);
        int imageResource = getResources().getIdentifier("@drawable/butternuttree", null, this.getPackageName());
        butter_tree.setImageResource(imageResource);

        //defines textveiw and sets the text value
        TextView facts = findViewById(R.id.Facts);
        facts.setText("Facts");

        //defines textveiw and sets the text value
        TextView commonname = findViewById(R.id.common_name);
        commonname.setText("Common Name: Butternut");

        //defines textveiw and sets the text value
        TextView tree_info = findViewById(R.id.Tree_info);
        tree_info.setText("Butternut is a close kind of the black walnut. Although it is not as valuable. It produces attractive wood, edible nuts, but branches freely and seldom reaches a large size. Common in moist soils, esspecially along fences and roads.");

        //defines textveiw and sets the text value
        TextView price_title = findViewById(R.id.Price_Title);
        price_title.setText("Price");

        //defines textveiw and sets the text value
        final TextView price = findViewById(R.id.Price);
        price.setText("$60.00 Each");

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
                Intent start_delivery = new Intent(Butternut_Tree.this, Delivery.class);
                startActivity(start_delivery);
            }
        });
    }
}
