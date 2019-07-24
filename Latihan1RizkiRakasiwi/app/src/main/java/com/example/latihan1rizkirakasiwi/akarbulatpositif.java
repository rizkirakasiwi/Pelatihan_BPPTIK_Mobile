package com.example.latihan1rizkirakasiwi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class akarbulatpositif extends AppCompatActivity {

    private int inputA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akarbulatpositif);
    }

    public void backMencariakarbulatpositif(View view) {
        onBackPressed();
    }

    public void prosesHasil(View view) {
        EditText editTextInputA = findViewById(R.id.edt_masukanAngkaBP);
        String stringInputA = editTextInputA.getText().toString();
        inputA = Integer.parseInt(stringInputA);


        int hasil = 0;
        int nilai = inputA;
        TextView output = findViewById(R.id.txt_outputAB);

        // selama hasil x hasil tidak bernilai nilai maka hasil terus ditambah 1
        while(hasil*hasil != nilai){
            hasil++;

            // jika hasil dari perkalian hasil x hasil > nilai maka hentikan perulangan
            if(hasil*hasil > nilai){
                output.setText("Akar bulat positif dari "+nilai+" tidak ditemukan");
                // memberikan nilai -1 ke hasil
                hasil = -1;
                break;
            }
        }

        // cek apakah program memiliki hasil yang benar atau enggak
        if(hasil != -1){
            output.setText(hasil + " adalah akar dari " + nilai );
        }
    }
}
