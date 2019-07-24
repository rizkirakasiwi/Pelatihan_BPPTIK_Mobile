package com.example.aplikasisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class addEdit extends AppCompatActivity {

    private EditText inputname;
    private EditText inputAddress;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> arrayList;

    private String idExtra;
    private Bundle extras;
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        inputname = findViewById(R.id.name);
        inputAddress = findViewById(R.id.address);

        extras = getIntent().getExtras();
        if (extras != null){
            idExtra = extras.getString(TAG_ID);
            inputname.setText(extras.getString(TAG_NAME));
            inputAddress.setText(extras.getString(TAG_ADDRESS));
        }

    }




    public void submit(View view) {
        if (extras != null) {
            databaseHelper = new DatabaseHelper(this);
            databaseHelper.update(Integer.parseInt(idExtra), inputname.getText().toString(),
                    inputAddress.getText().toString());
            Toast.makeText(this, "Berhasil diupdate", Toast.LENGTH_SHORT).show();
        }else{
            inputname = findViewById(R.id.name);
            inputAddress = findViewById(R.id.address);
            databaseHelper = new DatabaseHelper(this);
            databaseHelper.insert(inputname.getText().toString(),inputAddress.getText().toString());
            inputname.setText("");
            inputAddress.setText("");
            Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        onBackPressed();
    }
}
