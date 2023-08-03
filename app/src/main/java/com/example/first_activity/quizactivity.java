package com.example.first_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quizactivity extends AppCompatActivity {

    TextView textView;
    Button btn1;
    Button btn2;
    private TextView tvQuestion;

    private RadioGroup radioGroup;
    private RadioButton rd1, rd2, rd3, rd4;
    int totalQuestion;
    private int currentQuestionIndex = 0;
    int getTotalQuestion = 5;

    private String questions[] = {
            "which method can be defined only once in a program?", "which keyword is used by method to refer to the current object that invoked it?",
            "which of these access specifiers can be used for an interface?", "which of the following is correct way of importing an entire package 'pkg'?", "what is the return type of constructor"
    };
    private String answers[] = {"main method", "this", "public", "import pkg.*", "none of them"};
    private String options[][] = {
            {"finalize the method", "main method", "static method", "private method"},
            {"import", "this", "catch", "abstract"},
            {"public", "protected", "private", "all of them"},
            {"import pkg.", "import pkg.*", "import pkg.*", "import pkg."},
            {"int", "float", "void", "none of them"}
    };

    public int score = 0, wrong = 0, right = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);

        textView = findViewById(R.id.textView3);
        tvQuestion = findViewById(R.id.question);

        radioGroup = findViewById(R.id.radiobtn);
        rd1 = findViewById(R.id.radioone);
        rd2 = findViewById(R.id.radiotwo);
        rd3 = findViewById(R.id.radiothree);
        rd4 = findViewById(R.id.radiofour);
        btn1 = findViewById(R.id.llablenext);
        btn2 = findViewById(R.id.quitquiz);

        String username = getIntent().getStringExtra("name user");
        textView.setText("hello  " + username);



        display(currentQuestionIndex);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(quizactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(currentQuestionIndex);
                currentQuestionIndex++;
                if (currentQuestionIndex >= questions.length) {
                    finishQuiz();
                } else {
                    display(currentQuestionIndex);
                }
            }
        });
    }

    private void display(int index) {

        tvQuestion.setText(questions[index]);
        rd1.setText(options[index][0]);
        rd2.setText(options[index][1]);
        rd3.setText(options[index][2]);
        rd4.setText(options[index][3]);
        radioGroup.clearCheck();
    }

    private void checkAnswer(int index) {

        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedRadioButton = findViewById(selectedId);

        String selectedAnswer = selectedRadioButton.getText().toString();

        if (selectedAnswer.equals(answers[index])) {

            score++;
            right++;
        } else {

            wrong++;
        }
    }

    private void finishQuiz() {

        Toast.makeText(this, "Quiz finished. Score: " + score, Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, endActivity2.class);
        intent.putExtra("score", score);
        intent.putExtra ("right",right);
        intent.putExtra ("wrong",wrong);
        startActivity(intent);


    }
}


