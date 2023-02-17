package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.db.AffixCombinations.AffixCombinationDBManager;
import com.example.myapplication.db.Affixes.AffixesDBManager;
import com.example.myapplication.db.DBHelper;
import com.example.myapplication.db.Definition.AffixCombinationDefsDBManager;
import com.example.myapplication.db.Words.WordsDBManager;

public class WordEditorActivity extends AppCompatActivity {

    private EditText mEditTextWord;
    private EditText mEditTextAffixes;
    private TextView mTextViewWords;
    private TextView mTextViewAffixes;

    private DBHelper dbHelper;

    private WordsDBManager wordDBManager;
    private AffixesDBManager affixesDBManager;
    private AffixCombinationDefsDBManager affixCombinationDefsDBManager;
    private AffixCombinationDBManager affixCombinationDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_editor);

        dbHelper = new DBHelper(this);

        wordDBManager = new WordsDBManager(this);
        affixesDBManager = new AffixesDBManager(this);
        affixCombinationDBManager = new AffixCombinationDBManager(this);
        affixCombinationDefsDBManager = new AffixCombinationDefsDBManager(this);

        mEditTextWord = findViewById(R.id.editTextWord);
        mEditTextAffixes = findViewById(R.id.editTextAffixes);
        mTextViewWords = findViewById(R.id.textViewWords);
        mTextViewAffixes = findViewById(R.id.textViewAffixes);

    }

    @Override
    protected void onResume() {
        super.onResume();
        wordDBManager.openDb();
        affixesDBManager.openDb();
        affixCombinationDBManager.openDb();
        affixCombinationDefsDBManager.openDb();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wordDBManager.closeDb();
        affixesDBManager.closeDb();
        affixCombinationDBManager.closeDb();
        affixCombinationDefsDBManager.closeDb();
    }



    public void onClickSaveWord(View view){
        String word = mEditTextWord.getText().toString().split(" ")[0];
        String translation = mEditTextWord.getText().toString().split(" ")[1];
        dbHelper.addWord(word, translation);
        mEditTextWord.setText("");
    }

    public void onClickSaveAffix(View view){
        dbHelper.addAffix(mEditTextAffixes.getText().toString());
        mEditTextAffixes.setText("");
    }

    public void Po(View view){
        mTextViewWords.setText(dbHelper.getWords().toString());
        mTextViewAffixes.setText(dbHelper.getAffixes().toString());
    }

    public void toCombinations(View view){
        Intent intent = new Intent(this, WordListChangeActivity.class);
        startActivity(intent);
    }
}
