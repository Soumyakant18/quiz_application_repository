package com.example.first_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText ed;
    Button btn1;
    Button btn2;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Button btn1=(Button) findViewById (R.id.button2);
        tv = (TextView) findViewById (R.id.textView);
        ed=(EditText) findViewById (R.id.editTextText);
        Button btn2=(Button) findViewById (R.id.button5);

        btn2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (MainActivity.this, aboutactivity.class);
                startActivity (intent);
            }
        });

        btn1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String n = ed.getText ().toString ();

                Intent intent = new Intent (MainActivity.this, quizactivity.class);
intent.putExtra ("name user",n);
                startActivity (intent);
            }
        });
    }


}