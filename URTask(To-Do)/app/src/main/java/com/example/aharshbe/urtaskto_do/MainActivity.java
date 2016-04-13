package com.example.aharshbe.urtaskto_do;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    //Createing a new variable for a linked list and array adapter

    LinkedList<String> mtoDOLists;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mtoDOLists.add("Hello List");
        mtoDOLists.add("Goodbye List");
        mtoDOLists.add("Welcome List");
        mtoDOLists.add("Opening Tasks");
        mtoDOLists.add("Closing Task");




        //Creating an Array Adapter

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mtoDOLists);








        FloatingActionButton addButton1 = (FloatingActionButton) findViewById(R.id.addButton);

        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if


                Snackbar.make(view, "Your new list was added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        FloatingActionButton removeButton1 = (FloatingActionButton) findViewById(R.id.removeButton);

        removeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "List was removed!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



    public static final String ACIONT_VIEW() {


        return ACIONT_VIEW();
    }


    public void seeToDosHelloList(View view) {
        getIntent();
    }

    public void seeToDosGoodbyeList(View view) {
        getIntent();
    }

    public void seeToDosWelcomeList(View view) {
        getIntent();
    }

    public void seeToDosOpeningList(View view) {
        getIntent();
    }

    public void seeToDosClosingTaskList(View view) {
        getIntent();
    }
}
