package com.example.myapplication.db.Definition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class AffixCombinationDefsDBManager {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;

    public AffixCombinationDefsDBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        dbHelper.close();
    }

    public void createWord(String definition, int wordId){
        ContentValues cv = new ContentValues();
        cv.put(AffixCombinationDefsDB.KEY_DEFINITION, definition);
        cv.put(AffixCombinationDefsDB.KEY_WORD_ID, wordId);

        db.insert(AffixCombinationDefsDB.TABLE_NAME, null, cv);
    }

    public List<String> getAllWords(){
        List<String> tempList = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + AffixCombinationDefsDB.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                tempList.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            } while(c.moveToNext());
        }
        c.close();
        return tempList;
    }
}
