package com.example.myapplication.db.Affixes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class AffixesDBManager {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;

    public AffixesDBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        dbHelper.close();
    }

    public void createWord(String affix){
        ContentValues cv = new ContentValues();
        cv.put(AffixesDB.KEY_AFFIX, affix);

        db.insert(AffixesDB.TABLE_NAME, null, cv);
    }

    public List<String> getAllWords(){
        List<String> tempList = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + AffixesDB.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                tempList.add(c.getString(0) + " " + c.getString(1));
            } while(c.moveToNext());
        }
        c.close();
        return tempList;
    }
}
