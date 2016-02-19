package com.example.patron.quizapp4000;

import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playPressed(View view) {
        Intent intent = new Intent(this, com.example.patron.quizapp4000.PlayActivity.class);
        startActivity(intent);

    }
}
