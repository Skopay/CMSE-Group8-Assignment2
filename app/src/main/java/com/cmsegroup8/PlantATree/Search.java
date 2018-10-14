package com.cmsegroup8.PlantATree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Search extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Declares back item in top action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //Defines listview list
        ListView list = findViewById(R.id.thelist);

        //Defines edittext edittext
        EditText editText = findViewById(R.id.searchFilter);

        //defines arraylist of strings trees and populates
        final ArrayList<String> trees = new ArrayList<>();
        trees.add("Palm");
        trees.add("Arborvitae");
        trees.add("Butternut");

        //defines ArrayAdapter adapter and sets adapter
        adapter = new ArrayAdapter(this, R.layout.list_layout, trees);
        list.setAdapter(adapter);

        /*Depending on what item is clicked the user is redirected to the specified activity*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent start_palm = new Intent(Search.this, Palm_Tree.class);
                    //starttree.putExtra("Tree_Info", trees.get(parent));
                    startActivity(start_palm);
                } else if (position == 1) {
                    Intent start_Arborvitae = new Intent(Search.this, Arborvitae.class);
                    //starttree.putExtra("Tree_Info", trees.get(parent));
                    startActivity(start_Arborvitae);
                } else if (position == 2) {
                    Intent start_Butternut = new Intent(Search.this, Butternut_Tree.class);
                    //starttree.putExtra("Tree_Info", trees.get(parent));
                    startActivity(start_Butternut);
                }
            }
        });

        /*This method filters the listview so that the listview item displayed
         * matches the string in the edit text field*/
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Search.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
