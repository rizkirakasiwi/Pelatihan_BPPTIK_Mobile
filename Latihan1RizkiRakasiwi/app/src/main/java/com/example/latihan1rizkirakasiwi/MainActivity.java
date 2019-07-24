package com.example.latihan1rizkirakasiwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void mencariAkarBulatPositif(View view) {
        Intent intent = new Intent(this, akarbulatpositif.class);
        startActivity(intent);
    }

    public void luasDanKelilingLingkaran(View view) {
        Intent intent = new Intent(this, luasDanKelilingLinkaran.class);
        startActivity(intent);
    }

    public void mencariGanjilDanGenap(View view) {
        Intent intent = new Intent(this, mencariGanjilGenap.class);
        startActivity(intent);
    }

    public void membandingkanDuaBilangan(View view) {
        Intent intent = new Intent(this, membandingkanDuaBilangan.class);
        startActivity(intent);
    }
}
