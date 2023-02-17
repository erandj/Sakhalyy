package com.example.myapplication.db.AffixCombinations;

import com.example.myapplication.db.Affixes.AffixesDB;
import com.example.myapplication.db.Definition.AffixCombinationDefsDB;

public class AffixCombinationDB {
    public static final String TABLE_NAME = "AffixCombination";

    public static final String KEY_ID = "_id";
    public static final String KEY_DEFINITION_ID = "definition_id";
    public static final String KEY_AFFIX_ID = "affix_id";

    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY UNIQUE," +
                    KEY_DEFINITION_ID + " INTEGER," +
                    KEY_AFFIX_ID + " INTEGER," +
                    " FOREIGN KEY ("+KEY_DEFINITION_ID+") REFERENCES "+ AffixCombinationDefsDB.TABLE_NAME +"("+AffixCombinationDefsDB.KEY_ID+")" +
                    " FOREIGN KEY ("+KEY_AFFIX_ID+") REFERENCES "+ AffixesDB.TABLE_NAME +"("+AffixesDB.KEY_ID+"));";

    public static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}