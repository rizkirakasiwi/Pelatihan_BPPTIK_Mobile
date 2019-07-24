package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void tambahCatatan(View view) {
        Intent intent = new Intent(this, TambahCatatan.class);
        startActivity(intent);
    }

    public void lihatCatatan(View view) {
        Intent intent = new Intent(this, LihatCatatan.class);
        startActivity(intent);
    }
}
