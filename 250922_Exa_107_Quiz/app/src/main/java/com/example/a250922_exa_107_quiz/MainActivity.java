package com.example.a250922_exa_107_quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;

    private int clicked = 0;
    private ArrayList<TextView> resutls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

    }

    public void init(){
        answer1 = findViewById(R.id.question1);
        answer2 = findViewById(R.id.question2);
        answer3 = findViewById(R.id.question3);
        answer4 = findViewById(R.id.question4);

        resutls.add(findViewById(R.id.r1));
        resutls.add(findViewById(R.id.r2));
        resutls.add(findViewById(R.id.r3));
        resutls.add(findViewById(R.id.r4));
        resutls.add(findViewById(R.id.r5));
    }

    public void q1(View v){
        boolean checker = false;

        try {
            if (checker) {
                resutls.get(clicked).setBackgroundColor(Color.green(100));
            } else {
                resutls.get(clicked).setBackgroundColor(Color.red(100));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void q2(View v){
        boolean checker = false;

        try {
            if (checker) {
                resutls.get(clicked).setBackgroundColor(Color.green(100));
            } else {
                resutls.get(clicked).setBackgroundColor(Color.red(100));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void q3(View v){
        boolean checker = false;

        try {
            if (checker) {
                resutls.get(clicked).setBackgroundColor(Color.green(100));
            } else {
                resutls.get(clicked).setBackgroundColor(Color.red(100));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void q4(View v){
        boolean checker = false;

        try {
            if (checker) {
                resutls.get(clicked).setBackgroundColor(Color.green(100));
            } else {
                resutls.get(clicked).setBackgroundColor(Color.red(100));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}