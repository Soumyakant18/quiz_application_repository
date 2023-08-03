package com.example.first_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aboutactivity extends AppCompatActivity {

    Button button ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_aboutactivity);


        TextView textView=(TextView)findViewById (R.id.textView2);

        Button button=(Button)findViewById (R.id.aboutb);
        button.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (aboutactivity.this,MainActivity.class);
                startActivity (intent);
            }
        });
    }
}