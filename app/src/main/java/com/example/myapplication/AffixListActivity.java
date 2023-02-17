package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.db.DBHelper;

import java.util.ArrayList;

public class AffixListActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affix_list);

        dbHelper = new DBHelper(this);

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> wordsTrans = dbHelper.getWords();
        ArrayList<String> words = new ArrayList<>();

        for (int i=0; i<wordsTrans.size(); i++){
            words.add(wordsTrans.get(i).split(" ")[0]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, words);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
    }
}
