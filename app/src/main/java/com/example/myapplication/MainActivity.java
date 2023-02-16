package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWordEditorActivity(View view){
        Intent intent = new Intent(this, WordEditorActivity.class);
        startActivity(intent);
    }

    public void startConstructorActivity(View view){
        Intent intent = new Intent(this, ConstructorActivity.class);
        startActivity(intent);
    }
}