package com.example.latihan1rizkirakasiwi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class luasDanKelilingLinkaran extends AppCompatActivity {

    private int jari_jari_Lingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_dan_keliling_linkaran);
    }

    public void backLuasDanKelilingLingkaran(View view) {
        onBackPressed();
    }

    public void btn_proses_lkl(View view) {
        EditText jari_jari = findViewById(R.id.edt_inputJariJari);
        String stringJari_jari = jari_jari.getText().toString();
        jari_jari_Lingkaran = Integer.parseInt(stringJari_jari);

        TextView output = findViewById(R.id.txt_outputKLK);

        double pi = 3.14;
        double hasil = pi * (jari_jari_Lingkaran * jari_jari_Lingkaran);
        double keliling = 2 * pi * jari_jari_Lingkaran;
        output.setText("Luas lingkaran adalah "+hasil+"\ndan Keliling lingkaran "+keliling);
    }
}
