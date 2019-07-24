package com.example.latihan1rizkirakasiwi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mencariGanjilGenap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mencari_ganjil_genap);
    }

    public void backMencariGanjilGenap(View view) {
        onBackPressed();
    }

    public void prosesGG(View view) {
        EditText input = findViewById(R.id.edt_masukanAngkaGG);
        String stringInput = input.getText().toString();
        int masukan = Integer.parseInt(stringInput);
        TextView output = findViewById(R.id.txt_outputGG);

        int nilai = masukan;
        int mod = nilai%2;

        if(mod == 1) {
            output.setText(nilai+" adalah bilangan ganjil");
        }else{
           output.setText(nilai+ " adalah bilangan genap");
        }
    }
}
