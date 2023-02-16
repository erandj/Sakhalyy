package com.example.myapplication.db.Words;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class WordsDBManager {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;

    public WordsDBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        dbHelper.close();
    }
}
