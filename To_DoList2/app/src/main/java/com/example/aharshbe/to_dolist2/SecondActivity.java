package com.example.aharshbe.to_dolist2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class SecondActivity extends AppCompatActivity {

    LinkedList<String> mToDos;
    ArrayAdapter<String> mAdapter;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        final String positionWithName = getIntent().getStringExtra("nameOfListPrior");
        textView.setText(String.valueOf("UR List:" + " " + positionWithName));

        mToDos = new LinkedList<>();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mToDos);

        ListView listView = (ListView) findViewById(R.id.ToDoLists1);

        listView.setAdapter(mAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Removed a list item at it's position as a parameter
                mToDos.remove(position);
                //Notifying the adapter that the list did in fact change via removing from press @ position
                mAdapter.notifyDataSetChanged();
                //returning true..obyy. lol
                return true;
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String addingText = editText.getText().toString();

                if (addingText.length() > 0) {
                    mToDos.add(addingText);
                    mAdapter.notifyDataSetChanged();
                    //clearing out edit text after input is give from button
                    editText.setText("");

                    //Tried to get data to persist and think I'm pretty close but couldn't figure it out sadly.

                    //  arrayClass.ToDoObjectsArray.get(positionWithName).add(addingText);
                    // mAdapter.notifyDataSetChanged();


                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Long press to delete :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
