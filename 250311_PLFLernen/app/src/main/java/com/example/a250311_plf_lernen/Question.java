package com.example.a250311_plf_lernen;

import java.util.ArrayList;

public class Question {
    private String title;
    private ArrayList<String> answers = new ArrayList<>();
    private int correctAnswer;

    public String getTitle(){
        return title;
    }
    public void setTitle(String s){
        this.title = s;
    }

    public void setQ1(String part) {
        answers.add(part);
    }
    public String getQ1(){
        return answers.get(0);
    }
    public void setQ2(String part) {
        answers.add(part);
    }
    public String getQ2(){
        return answers.get(1);
    }
    public void setQ3(String part) {
        answers.add(part);
    }
    public String getQ3(){
        return answers.get(2);
    }
    public void setQ4(String part) {
        answers.add(part);
    }
    public String getQ4(){
        return answers.get(3);
    }

    public void setCorrectAnswer(int i) {
        this.correctAnswer = i;
    }
    public int getCorrectAnswer(){
        return correctAnswer;
    }
}
