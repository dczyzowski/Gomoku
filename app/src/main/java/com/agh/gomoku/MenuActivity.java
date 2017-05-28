package com.agh.gomoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onEasy(View view) {
        MainActivity.dimension = 8;
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onMedium(View view) {
        MainActivity.dimension = 12;
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onHard(View view) {
        MainActivity.dimension = 15;
        startActivity(new Intent(this, MainActivity.class));
    }
}
