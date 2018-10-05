package com.cmsegroup8.searchba;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                case R.id.navigation_home:
                    Intent home = new Intent(Home.this, Home.class);
                    startActivity(home);
                    break;

                case R.id.navigation_Search:
                    Intent search = new Intent(Home.this, MainActivity.class);
                    startActivity(search);
                    break;

            }
                return false;
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

        if(id == R.id.navigation_Search) {

        Intent startsearch = new Intent(this, Search.class);
        startActivity(startsearch);

        }

    if(id == R.id.navigation_home) {

            Intent home = new Intent(this, Home.class);
            startActivity(home);

        }
        return super.onOptionsItemSelected(item);
    }
}
