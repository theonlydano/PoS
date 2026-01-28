package com.example.a250311_plf_lernen;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QuestionLayout extends GridLayout {

    private TextView questionTitle;
    private Questions question;
    private QuestionPool questionPool;
    private Button check;

    public QuestionLayout(Context context) {
        super(context);
        setColumnCount(1);
        setRowCount(4);

        questionTitle = new TextView(this.getContext());
        questionTitle.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        question = new Questions(this.getContext());
        questionPool = new QuestionPool();
        try {
            questionPool.setQuestions(context.getResources().openRawResource(R.raw.questionfile));
        }catch (IOException e){
            e.printStackTrace();
        }

        check = new Button(this.getContext());
        check.setOnClickListener((v -> {
            check();
            setNext();
        }));
        check.setText("CHECK");

        addView(questionTitle);
        addView(question);
        addView(check);
    }

    public void setNext(){
        question.setNextQuestion(questionPool.getNext());
        this.questionTitle.setText(question.getTitle());
    }

    private void check(){
        if(question.check()){
            Log.d("QUESTION", "Correct");
        }else{
            Log.d("QUESTION", "Wrong");
        }
    }
}
