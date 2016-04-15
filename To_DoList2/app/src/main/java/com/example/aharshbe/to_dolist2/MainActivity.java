package com.example.aharshbe.to_dolist2;

import android.content.Intent;
import  android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> mToDoList;
    ArrayAdapter<String> mAdapter;
    //Reserving memeory for the edit text to be referenced later
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Referencing the XML location for the edit text..and calling after main method runs XML
        editText = (EditText) findViewById(R.id.editText);

        mToDoList = new LinkedList<>();
        mToDoList.add("Hello List");
        mToDoList.add("Welcome List");



        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mToDoList);
        ListView listView = (ListView) findViewById(R.id.ToDoLists1);

        listView.setAdapter(mAdapter);


        //Removes a object on the list based on a long press, subsitutes having to use the extra remove button

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Removed a list item at it's position as a parameter
                mToDoList.remove(position);
                //Notifying the adapter that the list did in fact change via removing from press @ position
                mAdapter.notifyDataSetChanged();
                //returning true..obyy. lol
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a new string reference edit text and changing it to a string
                String addingText = editText.getText().toString();

                if (addingText.length() >0){
                    mToDoList.add(addingText);
                    //mToDoList.add(0);
                    mAdapter.notifyDataSetChanged();
                    //clearing out edit text after input is give from button
                    editText.setText("");

                }

                //Snackbar.make(view, "List Added", Snackbar.LENGTH_SHORT)
                //        .setAction("Action", null).show();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);

                mToDoList.get(position);



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




    //Creating click listener for the listView click
   // public void clickingList(View view) {

   // }
}
