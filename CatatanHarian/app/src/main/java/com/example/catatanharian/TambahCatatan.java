package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class TambahCatatan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        EditText namaFile = findViewById(R.id.edt_namaFile);
        String stringNamaFile = namaFile.getText().toString();
        EditText catatan = findViewById(R.id.edt_catatan);
        String stringCatatan = catatan.getText().toString();

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            stringNamaFile = extras.getString("namaFile");
            namaFile.setText(stringNamaFile.substring(0, stringNamaFile.length()-1));
            try {
                FileInputStream fileInputStream = openFileInput(stringNamaFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                String baris;
                while ((baris = bufferedReader.readLine()) != null) {
                    stringBuffer.append(baris + "\n");
                }

                catatan.setText(stringBuffer.toString());
                stringCatatan = stringBuffer.toString();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (Exception e){

            }
        }
    }

    public void btn_simpan(View view) {
        EditText namaFile = findViewById(R.id.edt_namaFile);
        String stringNamaFile = namaFile.getText().toString();

        EditText catatan = findViewById(R.id.edt_catatan);
        String stringCatatan = catatan.getText().toString();

        File file = new File(getFilesDir(), stringNamaFile);
        if(file.exists()){
            file.delete();
        }

        FileOutputStream fileOutputStream = null;

        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(stringCatatan.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Catatan berhasil disimpan", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
