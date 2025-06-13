package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.quizapplication.Quiz_Page.*;

import java.util.Objects;

public class Resultpage extends AppCompatActivity {
    TextView correctscore;

    TextView wrongscore;
    TextView finalScore;
    Button restart;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        correctscore = findViewById(R.id.correctscore);
        wrongscore = findViewById(R.id.wrongscore);
        finalScore = findViewById(R.id.finalscore);
        restart = findViewById(R.id.rst);
        Intent getValues = getIntent();
        String str = getValues.getStringExtra("correct");
        String str2 = getValues.getStringExtra("wrong");
        String str3 = getValues.getStringExtra("score");
        correctscore.setText("Correct answers: "+str);
        wrongscore.setText("Wrong answers: " +str2);
        finalScore.setText("Final score : " +str3);
        restart.setOnClickListener(v ->{
            Intent restart = new Intent(Resultpage.this , MainActivity.class);
            startActivity(restart);
        });
    }
}