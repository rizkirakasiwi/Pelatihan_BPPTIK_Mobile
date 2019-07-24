package com.example.aplikasisqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "digitaltalent.db";
    private static  final int DATABASE_VERION = 2;
    private static final String TABLE_CONTACT = "contact";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";

    private static final String CREATE_TABLE_CONTACT = "CREATE  TABLE "+TABLE_CONTACT+ " ("+
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT, "+ COLUMN_ADDRESS + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '"+TABLE_CONTACT+"'");
     onCreate(sqLiteDatabase);
    }

    public void insert(String name, String address){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String insertQuery = "INSERT INTO "+TABLE_CONTACT+" (name, address) VALUES ('"+name+"', '"+address+"');";
        sqLiteDatabase.execSQL(insertQuery);
        sqLiteDatabase.close();
    }

    public ArrayList<HashMap<String, String>> getAllData(){
        ArrayList<HashMap<String, String>> contactList;

        contactList = new ArrayList<HashMap<String, String>>();

        String selectQuery = "SELECT * FROM "+TABLE_CONTACT;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NAME, cursor.getString(1));
                map.put(COLUMN_ADDRESS, cursor.getString(2));
                contactList.add(map);
            }while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return contactList;
    }

    public void update(int id, String name, String address){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String updateQuery = "UPDATE "+TABLE_CONTACT+" SET "+COLUMN_NAME+" = '"+name+"', "+COLUMN_ADDRESS+" = '"+address+"' WHERE "+COLUMN_ID+" = '"+id+"'";
        sqLiteDatabase.execSQL(updateQuery);
        sqLiteDatabase.close();
    }

    public void delete(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM "+TABLE_CONTACT+ " WHERE "+COLUMN_ID+" = '"+id+"'";
        sqLiteDatabase.execSQL(deleteQuery);
        sqLiteDatabase.close();
    }

}
