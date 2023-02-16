package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.db.DBHelper;
import com.example.myapplication.db.Words.WordsDB;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
    }

    public void startWordEditorActivity(View view){
        Intent intent = new Intent(this, WordEditorActivity.class);
        startActivity(intent);
    }

    public void startConstructorActivity(View view){
        Intent intent = new Intent(this, WordPickActivity.class);
        startActivity(intent);
    }
}