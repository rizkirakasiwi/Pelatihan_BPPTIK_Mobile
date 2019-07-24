package com.example.latihan1rizkirakasiwi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class membandingkanDuaBilangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membandingkan_dua_bilangan);
    }

    public void backMembandingkanDuaBilangan(View view) {
        onBackPressed();
    }

    public void btnproseslkl(View view) {

        EditText angka1 = findViewById(R.id.edt_masukanangka1);
        EditText angka2 = findViewById(R.id.edt_masukanangka2);
        String stringAngka1 = angka1.getText().toString();
        String stringAngka2 = angka2.getText().toString();
        TextView output = findViewById(R.id.txt_outputKLK);

        int nilai = Integer.parseInt(stringAngka1);
        int nilai2 = Integer.parseInt(stringAngka2);
        if(nilai==nilai2){
            output.setText(nilai+" sama dengan " +nilai2);
        }else if(nilai<nilai2){
            output.setText(nilai + " Lebih kecil dari "+nilai2);
        }else{
            output.setText(nilai + " lebih besar dari "+nilai2);
        }

    }
}
