package com.example.myapplication.db.Definition;

public class AffixCombinationDefsDB {
    public static final String TABLE_NAME = "AffixCombinationDefs";

    public static final String KEY_ID = "_id";
    public static final String KEY_DEFINITION = "definition";
    public static final String KEY_WORD_ID = "word_id";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY," +
                    KEY_DEFINITION + " TEXT," +
                    KEY_WORD_ID + " INTEGER)";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}