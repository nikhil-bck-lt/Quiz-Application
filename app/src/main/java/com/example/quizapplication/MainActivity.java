package com.example.quizapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView title;
    EditText name;
    Button start;
    Button about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        title = findViewById(R.id.textView);
        name = (EditText) findViewById(R.id.editTextText);
        start = findViewById(R.id.button);
        about = findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_text = name.getText().toString().trim();
                if(ed_text.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter Name to Start",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i2 = new Intent(getApplicationContext(), Quiz_Page.class);
                    i2.putExtra("Name",ed_text);
                    startActivity(i2);
                }
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Aboutpage.class);
                startActivity(i);
            }
        });
    }
}