package com.example.myapplication.db.Words;

public class WordsDB{
    public static final String TABLE_NAME = "Words";

    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_TRANSLATION = "translation";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY UNIQUE," +
                    KEY_WORD + " TEXT," +
                    KEY_TRANSLATION + " TEXT)";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
