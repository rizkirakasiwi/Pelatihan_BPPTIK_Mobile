package com.example.tampilkannama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_proses(View view) {
        EditText inputNama = findViewById(R.id.edt_masukanNama);
        String stringInputNama = inputNama.getText().toString();
        TextView tampilkanNama = findViewById(R.id.txt_tampilNama);

        tampilkanNama.setText(stringInputNama);
    }
}
