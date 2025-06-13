package com.example.quizapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.quizapplication.R.id;

import java.util.Objects;


public class Quiz_Page extends AppCompatActivity {
    RadioGroup Rgroup;
    RadioButton rad1;
    RadioButton rad2;
    RadioButton rad3;
    RadioButton rad4;

    TextView display;
    TextView qsn;
    TextView scorecount;
    TextView txt;
    Button quit;
    Button next;
    String[] qbank = {"Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package 'pkg'?",
            "What is the return type of Constructors?"};
    String[] opt = {"finalize method","main method","static method","private method",//first
            "import","this","catch","abstract",//second
            "public","protected","private","All of the mentioned",//third
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",//fourth
            "int","float","void","None of the mentioned"};//fifth
    String[] ans = {"main method",
            "this",
            "public",
            "import pkg.*",
            "None of the mentioned"};
    int flag =0;
    public static int correct=0,marks=0,wrong=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        display = findViewById(id.textView2);
        qsn = findViewById(id.question);
        txt = findViewById(id.textvieww);
        scorecount = findViewById(id.scorecount);
        quit = findViewById(id.quit);
        next = findViewById(id.next);
        Rgroup =findViewById(id.answergrp);
        rad1 = findViewById(id.radioButton);
        rad2 = findViewById(id.radioButton2);
        rad3 = findViewById(id.radioButton3);
        rad4 = findViewById(id.radioButton4);
        //Top part
        Intent i1 = getIntent();
        String str = i1.getStringExtra("Name");
        str = "Hello " + str;
        display.setText(str);

        qsn.setText(qbank[0]);
        rad1.setText(opt[0]);
        rad2.setText(opt[1]);
        rad3.setText(opt[2]);
        rad4.setText(opt[3]);
        next.setOnClickListener(v -> {
            if(Rgroup.getCheckedRadioButtonId() == -1){
                Toast.makeText(getApplicationContext(),"Please select your answer",Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton uans =findViewById(Rgroup.getCheckedRadioButtonId());
            String answer = uans.getText().toString();
            if(answer.equals(ans[flag])){
                correct++;
                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
            }
            else{
                wrong++;
                Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
            }
            flag++;
            if(scorecount != null){
                scorecount.setText(""+correct);
            }
            if(flag<qbank.length){
                qsn.setText(qbank[flag]);
                rad1.setText(opt[flag*4]);
                rad2.setText(opt[flag*4+1]);
                rad3.setText(opt[flag*4+2]);
                rad4.setText(opt[flag*4+3]);
            }
            else{
                marks = correct;
                Intent i3 = new Intent(Quiz_Page.this, Resultpage.class);
                i3.putExtra("correct",String.valueOf(correct));
                i3.putExtra("wrong",String.valueOf((wrong)));
                i3.putExtra("score",String.valueOf(marks));
                startActivity(i3);
                correct = 0;
                wrong = 0;
                marks = 0;
            }
            Rgroup.clearCheck();
        });
//
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Quiz_Page.this, Resultpage.class);
                startActivity(back);
            }
        });

    }
}