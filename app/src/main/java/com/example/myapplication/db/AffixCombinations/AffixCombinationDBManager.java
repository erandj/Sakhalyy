package com.example.myapplication.db.AffixCombinations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class AffixCombinationDBManager {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;

    public AffixCombinationDBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        dbHelper.close();
    }

    public void createWord(int definitionId, int affixId){
        ContentValues cv = new ContentValues();
        cv.put(AffixCombinationDB.KEY_DEFINITION_ID, definitionId);
        cv.put(AffixCombinationDB.KEY_AFFIX_ID, affixId);

        db.insert(AffixCombinationDB.TABLE_NAME, null, cv);
    }

    public List<String> getAllWords(){
        List<String> tempList = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + AffixCombinationDB.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                tempList.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            } while(c.moveToNext());
        }
        c.close();
        return tempList;
    }
}
