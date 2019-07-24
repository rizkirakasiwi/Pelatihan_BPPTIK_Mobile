package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private DatabaseHelper databaseHelper;
    private TextView txt_names;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStore(View view) {
        edtName = findViewById(R.id.edt_enterName);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        databaseHelper.addStudentDetail(edtName.getText().toString());
        edtName.setText("");

        Toast.makeText(MainActivity.this, "Berhasil disimpan", Toast.LENGTH_LONG).show();
    }

    public void btnGet(View view) {
        databaseHelper = new DatabaseHelper(this);
        arrayList = new ArrayList<String>();
        arrayList = databaseHelper.getAllStudentsList();
        txt_names = findViewById(R.id.txt_names);
        txt_names.setText("");
        for (int i = 0; i < arrayList.size(); i++){
            txt_names.setText(txt_names.getText().toString() + ", "+arrayList.get(i));
        }
    }
}
