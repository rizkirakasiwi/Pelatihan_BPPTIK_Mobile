package com.example.latihanstorage;

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

    public void btn_internal(View view) {
        Intent intent = new Intent(this, InternalActivity.class);
        startActivity(intent);
    }

    public void btn_external(View view) {
        Intent intent = new Intent(this, ExternalActivity.class);
        startActivity(intent);
    }
}
