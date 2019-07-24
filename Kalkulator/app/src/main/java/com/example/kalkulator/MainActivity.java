package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int hasil;
    private float hasilB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void kalkulator(String perintah){
        EditText angka1 = findViewById(R.id.edt_angka1);
        EditText angka2 = findViewById(R.id.edt_angka2);
        String stringAngka1 = angka1.getText().toString();
        String stringAngka2 = angka2.getText().toString();
        int nilai1 = Integer.parseInt(stringAngka1);
        int nilai2 = Integer.parseInt(stringAngka2);
        TextView textHasil = findViewById(R.id.txt_Hasil);

        if(perintah == "+"){
            hasil = nilai1 + nilai2;
        }else  if(perintah == "-"){
            hasil = nilai1 - nilai2;
        }else  if(perintah == "*"){
            hasil = nilai1 * nilai2;
        }else  if(perintah == "/"){
            hasilB = (float) nilai1 / nilai2;
        }else{
            hasil = 0;
            angka1.setText("");
            angka2.setText("");
        }



        if(perintah == "/") textHasil.setText(String.valueOf(hasilB));
        else textHasil.setText(String.valueOf(hasil));
    }

    public void btn_tambah(View view) {
        kalkulator("+");
    }

    public void btn_kurang(View view) {
        kalkulator("-");
    }

    public void btn_kali(View view) {
        kalkulator("*");
    }

    public void btn_bagi(View view) {
        kalkulator("/");
    }

    public void btn_bersihkan(View view) {
        kalkulator("!");
    }
}
