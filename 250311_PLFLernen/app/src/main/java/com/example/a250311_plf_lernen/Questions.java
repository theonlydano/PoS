package com.example.a250311_plf_lernen;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;

public class Questions extends GridLayout {

    private Question question;
    private ArrayList<MyButton> buttons;
    private int correctAnswered = 0;
    private int clicked = 0;
    private int correctAnswer = 0;

    public Questions(Context context) {
        super(context);
        setRowCount(2);
        setColumnCount(2);
        buttons = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            MyButton b = new MyButton(this.getContext());
            b.setId(i);
            b.setCode(i);
            b.setOnClickListener( (v)-> {
                clicked = b.getCode();
                Log.d("BUTTON", b.getCode()  + " clicked");
            });
            buttons.add(b);
            addView(b);
        }
    }

    public boolean check() {
        Log.d("TAG", "check: " + correctAnswer + clicked);
        if (correctAnswer ==  clicked){
            correctAnswered++;
            Log.d("TAG", "ANSWERED CORRECTLY " + correctAnswered);
            return true;
        }else {
            Log.d("TAG", "ANSWERED CORRECTLY " + correctAnswered);
            return false;
        }
    }

    public void setNextQuestion(Question next) {
        this.question = next;
        buttons.get(0).setText(question.getQ1());
        buttons.get(1).setText(question.getQ2());
        buttons.get(2).setText(question.getQ3());
        buttons.get(3).setText(question.getQ4());
        correctAnswer = question.getCorrectAnswer();
    }
    public String getTitle(){
        return this.question.getTitle();
    }
}
