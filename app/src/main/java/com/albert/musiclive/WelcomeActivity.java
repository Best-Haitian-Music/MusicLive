package com.albert.musiclive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.parse.Parse.getApplicationContext;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        finish();

    }
}
