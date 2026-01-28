package com.example.a250929_quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String text;
    private List<String> answers;
    private int correctAnswer;

    public Question(String text){
        this.text = text;
        answers = new ArrayList<>();
        // correctAnswer = 0; muss nicht gemacht werden, da primitive Datentypen automatisch mit 0 initialisieren
    }

    public void addAnswer(String text){
        answers.add(text);
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getText() {
        return text;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer % 4;
    }

    public List<String> getQuestion(){
        return answers;
    }
}