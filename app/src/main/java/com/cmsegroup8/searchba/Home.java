package com.cmsegroup8.searchba;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import java.util.Arrays;

public class Home extends AppCompatActivity implements RatingDialogListener {

    FloatingActionButton ratingButton;
    RatingBar ratingBar;

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
                    Intent search = new Intent(Home.this, Search.class);
                    startActivity(search);
                    break;

            }
                return false;
            }
        });

        ratingButton = findViewById(R.id.rating_button);
        ratingBar = findViewById(R.id.ratingBar);

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog();
            }
        });

    }

/*    @Override
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
    }*/

    private void showRatingDialog() {
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNoteDescriptions(Arrays.asList("Very Bad", "Not Good", "Average", "Good", "Great"))
                .setDefaultRating(1)
                .setTitle("Rate your experience")
                .setDescription("Give us feedback about your experience with PlantATree")
                .setTitleTextColor(R.color.colorPrimary)
                .setDescriptionTextColor(R.color.colorPrimary)
                .setHint("Write your comments here...")
                .setHintTextColor(R.color.white)
                .setCommentTextColor(android.R.color.white)
                .setCommentBackgroundColor(android.R.color.black)
                .setWindowAnimation(R.style.RatingDialogFadeAnim)
                .create(Home.this)
                .show();
    }

    public void onPositiveButtonClicked(int rating, String comments) {
        ratingBar.setRating(rating);
        Toast.makeText(Home.this, "Thank you for the feedback!", Toast.LENGTH_SHORT).show();
    }

    public void onNegativeButtonClicked() {
        //Nothing is done
    }
}
