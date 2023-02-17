package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;

public class WordListChangeActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    public static int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list_change);

        dbHelper = new DBHelper(this);

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> wordsTrans = dbHelper.getWords();
        ArrayList<String> words = new ArrayList<>();

        for( String oneItem : wordsTrans ) {
            words.add(oneItem.split(" ")[0] + " " + oneItem.split(" ")[1]);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, words);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemPos = position;
                onClick();
            }
        });
    }

    private void onClick(){
        Intent intent = new Intent(this, CombinationsActivity.class);
        startActivity(intent);
    }
}
