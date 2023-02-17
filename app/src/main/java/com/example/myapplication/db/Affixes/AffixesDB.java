package com.example.myapplication.db.Affixes;

public class AffixesDB {
    public static final String TABLE_NAME = "Affixes";

    public static final String KEY_ID = "_id";
    public static final String KEY_AFFIX = "affix";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY UNIQUE," +
                    KEY_AFFIX + " TEXT)";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}