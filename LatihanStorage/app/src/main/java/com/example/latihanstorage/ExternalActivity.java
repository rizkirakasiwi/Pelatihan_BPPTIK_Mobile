package com.example.latihanstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExternalActivity extends AppCompatActivity {

    public static final String FILENAME =" namafile.txt";
    public static final  int REQUEST_CODE_STORAGE = 100;
    public boolean mendapatIzin;
    private String filepath = "MyFileStorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
    }

    public boolean periksaIzinPenyimpanan(){
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                mendapatIzin = true;
                return  true;
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE);
                return false;
            }
        }else{
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_CODE_STORAGE: if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mendapatIzin = true;
            }
            break;
        }
    }

    public void btn_buatFileEx(View view) {
        if(periksaIzinPenyimpanan()){
            if(mendapatIzin){
                String isifile = "Coba isi data";
                File file = new File(getExternalFilesDir(filepath), FILENAME);
                FileOutputStream fileOutputStream = null;

                try {
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file, true);
                    fileOutputStream.write(isifile.getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Toast.makeText(this, "File was succeed to created", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void btn_ubahFileEx(View view) {
    }

    public void btn_bacaFileEx(View view) {
        if(periksaIzinPenyimpanan()){
            if(mendapatIzin){
                try{
                    FileInputStream fileInputStream = openFileInput(FILENAME);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                }catch (Exception e){

                }
            }
        }
    }

    public void btn_hapusFileEx(View view) {
    }
}
