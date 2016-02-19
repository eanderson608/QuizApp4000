package com.example.patron.quizapp4000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, ImagePlayFragment.newInstance(null, null))
                .addToBackStack(null)
                .commit();

    }
}
