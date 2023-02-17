package com.example.myapplication.db.Definition;

import com.example.myapplication.db.Words.WordsDB;

public class AffixCombinationDefsDB {
    public static final String TABLE_NAME = "AffixCombinationDefs";

    public static final String KEY_ID = "_id";
    public static final String KEY_DEFINITION = "definition";
    public static final String KEY_WORD_ID = "word_id";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY UNIQUE," +
                    KEY_DEFINITION + " TEXT," +
                    KEY_WORD_ID + " integer," +
                    " FOREIGN KEY ("+KEY_WORD_ID+") REFERENCES "+ WordsDB.TABLE_NAME +"("+WordsDB.KEY_ID+"));";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}