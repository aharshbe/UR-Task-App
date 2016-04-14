package com.example.aharshbe.to_dolist2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> mToDoList;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mToDoList = new LinkedList<>();
        mToDoList.add("Hello List");
        mToDoList.add("Welcome List");
        mToDoList.add("Goodbye List");
        mToDoList.add("Opening List");
        mToDoList.add("Closing List");


        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mToDoList);
        ListView listView = (ListView) findViewById(R.id.ToDoLists1);
        listView.setAdapter(mAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mToDoList.size() <=0){
                    //mToDoList.add(0);
                    mAdapter.notifyDataSetChanged();
                }

                Snackbar.make(view, "List Added", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.removeButton);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mToDoList.size() >=1) {
                    mToDoList.remove(0);
                    mAdapter.notifyDataSetChanged();
                }

                Snackbar.make(view, "List Removed", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
