package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Aboutpage extends AppCompatActivity {
    TextView develop;
    TextView name;
    TextView email;
    Button backk;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutpage);
        develop = findViewById(R.id.develop);
        name = findViewById(R.id.name);
        email =findViewById(R.id.emailid);
        backk = findViewById(R.id.backbutton);
        name.setText("Nikhil Surelia");
        email.setText("nikhilsurelia@gmail.com");
        backk.setOnClickListener(v ->{
            Intent goback = new Intent(this, MainActivity.class);
            startActivity(goback);
        });
    }
}