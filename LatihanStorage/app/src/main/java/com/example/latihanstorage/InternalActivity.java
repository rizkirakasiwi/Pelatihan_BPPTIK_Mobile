package com.example.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class InternalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        getSupportActionBar().setTitle("Internal Storage");
    }

    public void btn_buatFile(View view) {
        String isiFile = "Coba isi file";
        File file = new File(getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(InternalActivity.this, "File berhasil di buat", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btn_ubahFile(View view) {
    }

    public void btn_bacaFile(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(FILENAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String baris;
            while((baris = bufferedReader.readLine())!= null){
                stringBuffer.append(baris +"\n");
            }

            TextView hasil = findViewById(R.id.textBaca);
            hasil.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btn_hapusFile(View view) {
        File file = new File(getFilesDir(), FILENAME);

        if(file.exists()){
            file.delete();
            Toast.makeText(InternalActivity.this, "File berhasil dihapus", Toast.LENGTH_SHORT).show();
            TextView hasil = findViewById(R.id.textBaca);
            hasil.setText("");
        }
    }

}
