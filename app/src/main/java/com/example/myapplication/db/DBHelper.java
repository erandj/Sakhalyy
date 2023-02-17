package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapplication.Affix;
import com.example.myapplication.db.AffixCombinations.AffixCombinationDB;
import com.example.myapplication.db.Affixes.AffixesDB;
import com.example.myapplication.db.Definition.AffixCombinationDefsDB;
import com.example.myapplication.db.Words.WordsDB;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 6;

    public DBHelper(Context context) {
        super(context, "sakhalyy.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WordsDB.CREATE_ENTRIES);
        db.execSQL(AffixesDB.CREATE_ENTRIES);
        db.execSQL(AffixCombinationDB.CREATE_ENTRIES);
        db.execSQL(AffixCombinationDefsDB.CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(WordsDB.DELETE_ENTRIES);
        db.execSQL(AffixesDB.DELETE_ENTRIES);
        db.execSQL(AffixCombinationDB.DELETE_ENTRIES);
        db.execSQL(AffixCombinationDefsDB.DELETE_ENTRIES);

        onCreate(db);
    }

    public void addAffix(String affix){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues affixvalues = new ContentValues();
        affixvalues.put(AffixesDB.KEY_AFFIX, affix);

        long id = db.insert(AffixesDB.TABLE_NAME, null, affixvalues);
    }

    public void addWord(String word, String translation){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues wordvalues = new ContentValues();
        wordvalues.put(WordsDB.KEY_WORD, word);
        wordvalues.put(WordsDB.KEY_TRANSLATION,translation);

        db.insert(WordsDB.TABLE_NAME, null, wordvalues);
    }

    public void addFullWord(String word, String translation, Affix[][] combinations, String[] definitions){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues wordvalues = new ContentValues();
        wordvalues.put(WordsDB.KEY_WORD, word);
        wordvalues.put(WordsDB.KEY_TRANSLATION,translation);
        long wordId = db.insert(WordsDB.TABLE_NAME, null, wordvalues);

        for (int i=0; i<combinations.length; i++){
            ContentValues definitionvalues = new ContentValues();

            definitionvalues.put(AffixCombinationDefsDB.KEY_DEFINITION, definitions[i]);
            definitionvalues.put(AffixCombinationDefsDB.KEY_WORD_ID, wordId);

            long definitonId = db.insert(AffixCombinationDefsDB.TABLE_NAME, null, definitionvalues);

            for (int j=0; j<combinations[i].length; j++){
                Affix affix = combinations[i][j];

                String myQuery = "SELECT * " +
                            "FROM " +  AffixesDB.TABLE_NAME +
                            " WHERE " +
                            "instr(" + AffixesDB.KEY_AFFIX + ", ?)";

                Cursor c = db.rawQuery(myQuery, new String[] {affix.getAffix()}); //?????????

                long affixId = c.getLong(c.getColumnIndexOrThrow("_id"));


                ContentValues combinationvalues = new ContentValues();

                combinationvalues.put(AffixCombinationDB.KEY_DEFINITION_ID, definitonId);
                combinationvalues.put(AffixCombinationDB.KEY_AFFIX_ID, affixId);

                db.insert(AffixCombinationDB.TABLE_NAME, null, combinationvalues);
            }
        }
    }

    public void updateWord(int id, String word) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WordsDB.KEY_WORD, word);
        db.update(WordsDB.TABLE_NAME, values, WordsDB.KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void updateWordTranslation(int id, String translation) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WordsDB.KEY_TRANSLATION, translation);
        db.update(WordsDB.TABLE_NAME, values, WordsDB.KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void updateAffix(int id, String affix) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AffixesDB.KEY_AFFIX, affix);
        db.update(AffixesDB.TABLE_NAME, values, AffixesDB.KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void updateDefinition(int id, String definition) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AffixCombinationDefsDB.KEY_DEFINITION, definition);
        db.update(AffixCombinationDefsDB.TABLE_NAME, values, AffixCombinationDefsDB.KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void createDefinition(int wordId, String definition, Affix[] affixes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues definitionvalues = new ContentValues();
        definitionvalues.put(AffixCombinationDefsDB.KEY_DEFINITION, definition);
        definitionvalues.put(AffixCombinationDefsDB.KEY_WORD_ID, wordId);

        long definitonId = db.insert(AffixCombinationDefsDB.TABLE_NAME, null, definitionvalues);

        for (int i=0; i<affixes.length; i++){
            ContentValues affixCombinationsValues = new ContentValues();
            definitionvalues.put(AffixCombinationDB.KEY_AFFIX_ID, affixes[i].getId());
            definitionvalues.put(AffixCombinationDB.KEY_DEFINITION_ID, definitonId);

            db.insert(AffixCombinationDB.TABLE_NAME, null, affixCombinationsValues);
        }
    }

    public ArrayList<String> getWords(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.query(WordsDB.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<String> str = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                str.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            } while (c.moveToNext());
        }
        c.close();

        return str;
    }

    public ArrayList<String> getAffixes(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.query(AffixesDB.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<String> str = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                str.add(c.getString(0) + " " + c.getString(1));
            } while (c.moveToNext());
        }
        c.close();

        return str;
    }
}
