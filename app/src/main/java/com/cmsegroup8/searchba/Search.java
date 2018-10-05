package com.cmsegroup8.searchba;

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

public class Search extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView list = (ListView) findViewById(R.id.thelist);
        EditText editText = (EditText) findViewById(R.id.searchFilter);

        final ArrayList<String> trees = new ArrayList<>();
        trees.add("Palm");
        trees.add("Cherry");
        trees.add("Tomato");

        adapter = new ArrayAdapter(this, R.layout.list_layout, trees);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(id == 0) {
                    Intent starttree = new Intent(Search.this, Tree1.class);
                    //starttree.putExtra("Tree_Info", trees.get(parent));
                    startActivity(starttree);
                }
                else if(id == 1) {
                    Intent starthome = new Intent(Search.this, Home.class);
                    //starttree.putExtra("Tree_Info", trees.get(parent));
                    startActivity(starthome);
                }

            }
        });

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
