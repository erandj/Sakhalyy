package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.db.AffixCombinations.AffixCombinationDBManager;
import com.example.myapplication.db.Affixes.AffixesDBManager;
import com.example.myapplication.db.Definition.AffixCombinationDefsDB;
import com.example.myapplication.db.Definition.AffixCombinationDefsDBManager;
import com.example.myapplication.db.Words.WordsDBManager;

public class WordEditorActivity extends AppCompatActivity {

    private EditText mEditTextWord;
    private EditText mEditTextAffixes;
    private EditText mEditTextDefinitions;
    private EditText mEditTextCombinations;
    private TextView mTextView;

    private WordsDBManager wordDBManager;
    private AffixesDBManager affixesDBManager;
    private AffixCombinationDefsDBManager affixCombinationDefsDBManager;
    private AffixCombinationDBManager affixCombinationDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_editor);

        wordDBManager = new WordsDBManager(this);
        affixesDBManager = new AffixesDBManager(this);
        affixCombinationDBManager = new AffixCombinationDBManager(this);
        affixCombinationDefsDBManager = new AffixCombinationDefsDBManager(this);

        mEditTextWord = findViewById(R.id.editTextWord);
        mEditTextAffixes = findViewById(R.id.editTextAffixes);
        mEditTextDefinitions = findViewById(R.id.editTextDefinitions);
        mEditTextCombinations = findViewById(R.id.editTextCombinations);
        mTextView = findViewById(R.id.textViewBDWord);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wordDBManager.openDb();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wordDBManager.closeDb();
    }

    public void onClickSaveWord(View view){
        wordDBManager.createWord(mEditTextWord.getText().toString().split(" ")[0], mEditTextWord.getText().toString().split(" ")[1]);
    }

    public void onClickSaveAffixes(View view){
        affixesDBManager.createWord(mEditTextAffixes.getText().toString());
    }

    public void onClickSaveDefinitions(View view){
        affixCombinationDefsDBManager.createWord(mEditTextDefinitions.getText().toString().split(" ")[0], Integer.parseInt(mEditTextDefinitions.getText().toString().split(" ")[1]));
    }

    public void onClickSaveCombinations(View view){
        affixCombinationDefsDBManager.createWord(mEditTextDefinitions.getText().toString().split(" ")[0], Integer.parseInt(mEditTextDefinitions.getText().toString().split(" ")[1]));
    }

    public void Po(View view){
        mTextView.setText(wordDBManager.getAllWords().toString());

    }
}
