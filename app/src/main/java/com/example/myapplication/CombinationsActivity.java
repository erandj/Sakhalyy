package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class CombinationsActivity extends AppCompatActivity {

    private int word_id;
    private DBHelper dbHelper;
    private ListView mListViewAffixes;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinations);

        word_id = WordListChangeActivity.itemPos + 1;

        dbHelper = new DBHelper(this);

        mListViewAffixes = findViewById(R.id.listViewAffixes);

        ArrayList<String> affixes = dbHelper.getAffixes();
        ArrayList<String> choosedAffixes = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, affixes);

        mListViewAffixes.setAdapter(adapter);

        mListViewAffixes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(choosedAffixes.contains(adapter.getItem(mListViewAffixes.getCheckedItemPosition()))){
                    choosedAffixes.remove(adapter.getItem(mListViewAffixes.getCheckedItemPosition()));
                    return;
                }

                choosedAffixes.add(adapter.getItem(mListViewAffixes.getCheckedItemPosition()));
                Log.i("", choosedAffixes.toString());
            }
        });
    }
}