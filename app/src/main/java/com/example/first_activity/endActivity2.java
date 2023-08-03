package com.example.first_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class endActivity2 extends AppCompatActivity {
Button btnone,buttonthree,buttonfour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_end2);

        Button btnone = (Button) findViewById (R.id.btn34);

        Button btnthree = (Button) findViewById (R.id.buttonfour);
        Button btnfour = (Button) findViewById (R.id.fbuttonfive);
        int score = getIntent().getIntExtra("score", 0);
        int right = getIntent().getIntExtra("right", 0);
        int wrong = getIntent ().getIntExtra ("wrong",0);

        btnone.setText("Your Score: " + score);
        btnfour.setText ("wrong Answer "+wrong);
        btnthree.setText ("right answer "+right);

    }


}