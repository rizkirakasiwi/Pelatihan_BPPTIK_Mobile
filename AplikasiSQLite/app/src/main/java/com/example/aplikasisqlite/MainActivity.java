package com.example.aplikasisqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseHelper databaseHelper;
    ArrayList<HashMap<String, String>> row;
    AlertDialog.Builder dialog;

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


                Intent intent = new Intent(MainActivity.this
                , addEdit.class);
                startActivity(intent);
            }
        });


        getSupportActionBar().setTitle("Daftar Kontak");
        getAllDat();

        listView = findViewById(R.id.listview);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String id = row.get(i).get(TAG_ID);
                final String name = row.get(i).get(TAG_NAME);
                final String address = row.get(i).get(TAG_ADDRESS);


                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(MainActivity.this, addEdit.class);
                                intent.putExtra(TAG_ID, id);
                                intent.putExtra(TAG_NAME, name);
                                intent.putExtra(TAG_ADDRESS, address);
                                startActivity(intent);
                                break;
                            case 1:
                                databaseHelper.delete(Integer.parseInt(id));
                                row.clear();
                                getAllDat();
                                break;
                        }


                    }
                }).show();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        row.clear();
        getAllDat();
    }

    public void getAllDat(){
        listView = findViewById(R.id.listview);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        row = databaseHelper.getAllData();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, row, android.R.layout.simple_list_item_2,
                new String[]{TAG_NAME, TAG_ADDRESS}, new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();
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
