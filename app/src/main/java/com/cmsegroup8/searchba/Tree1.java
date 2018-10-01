package com.cmsegroup8.searchba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class Tree1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree1);

        ImageView palmtree;
        palmtree = (ImageView) findViewById(R.id.palmtree);

        int imageResource = getResources().getIdentifier("@drawable/palmtree", null, this.getPackageName());
        palmtree.setImageResource(imageResource);

        TextView info = (TextView) findViewById(R.id.info1);

        info.setText("Palms are one of the best known and most widely planted tree families." +
                " They have held an important role for humans throughout much of history." +
                " Many common products and foods come from palms." +
                " They are often used in parks and gardens that are in areas that do not have heavy frosts." +
                "In the past palms were symbols of victory, peace, and fertility." +
                " Today palms are a popular symbol for the tropics and for vacations.");

        TextView feature = (TextView) findViewById(R.id.features);

        feature.setText("List palm features here");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }
}
