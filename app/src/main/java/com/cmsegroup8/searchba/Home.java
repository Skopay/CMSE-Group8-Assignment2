package com.cmsegroup8.searchba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView deals = (ImageView) findViewById(R.id.dailydeals);

        int imageResource = getResources().getIdentifier("@drawable/dailydeals", null, this.getPackageName());
        deals.setImageResource(imageResource);
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

        if(id == R.id.navigation_Search) {

        Intent startsearch = new Intent(this, MainActivity.class);
        startActivity(startsearch);

        }

    if(id == R.id.navigation_home) {

            Intent starttree1 = new Intent(this, Tree1.class);
            startActivity(starttree1);

        }
        return super.onOptionsItemSelected(item);
    }
}
