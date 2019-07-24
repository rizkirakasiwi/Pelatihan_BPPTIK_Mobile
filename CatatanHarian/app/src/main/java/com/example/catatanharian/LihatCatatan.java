package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LihatCatatan extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_catatan);

        getSupportActionBar().setTitle("Lihat catatan");

        listView = findViewById(R.id.listview);

        File direktori = new File(getFilesDir().getPath());
        final File[] daftarFile = direktori.listFiles();
        String[] daftarNamaFile = new String[daftarFile.length];
        String[] tanggal = new String[daftarFile.length];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM YYYY");
        ArrayList<Map<String, Object>> itemDataList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < daftarFile.length; i++){
            daftarNamaFile[i] = daftarFile[i].getName();
            Date lastModDate = new Date(daftarFile[i].lastModified());
            tanggal[i] = simpleDateFormat.format(lastModDate);
            Map<String, Object> listItemMap = new HashMap<>();
            listItemMap.put("Nama", daftarNamaFile[i]);
            listItemMap.put("Tanggal", tanggal[i]);
            itemDataList.add(listItemMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemDataList,
                android.R.layout.simple_list_item_2, new String[]{"nama", "Tanggal"},
                new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LihatCatatan.this, TambahCatatan.class);
                intent.putExtra("namaFile", daftarFile[i]);
                startActivity(intent);
            }
        });
    }
}
