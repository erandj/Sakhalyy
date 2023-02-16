package com.example.myapplication.db.AffixCombinations;

public class AffixCombinationDB {
    public static final String TABLE_NAME = "AffixCombination";

    public static final String KEY_ID = "_id";
    public static final String KEY_DEFINITION_ID = "definition_id";
    public static final String KEY_AFFIX_ID = "affix_id";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY," +
                    KEY_DEFINITION_ID + " INTEGER," +
                    KEY_AFFIX_ID + " INTEGER)";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}