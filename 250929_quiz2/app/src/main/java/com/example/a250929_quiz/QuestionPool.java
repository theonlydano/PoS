package com.example.a250929_quiz;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionPool{
    // your turn: please refactor to singleton
    private static QuestionPool qp = null;

    Map<String, List<Question>> questions = new HashMap<>();
    private final String TAG = "QUESTIONPOOL_SC";
    private QuestionPool(){
        // questions = getQuestionPool();
    }

    public void initQuestions(String category){
        List<Question> questionsOfCategory = new ArrayList<>();
        Question q = new Question("QP: Frage Number 1");
        q.setCorrectAnswer(3);
        q.addAnswer("Antwort s");
        q.addAnswer("Antwort 2");
        q.addAnswer("Antwort 3");
        q.addAnswer("Antwort 4");

        questionsOfCategory.add(q);

        q = new Question("QP: Frage Number 2");
        q.setCorrectAnswer(2);
        q.addAnswer("2Antwort 1");
        q.addAnswer("2Antwort 2");
        q.addAnswer("2Antwort 3");
        q.addAnswer("2Antwort 4");

        questionsOfCategory.add(q);

        questions.put(category, questionsOfCategory);
    }

    public void loadFromFile(InputStream inputStream) throws IOException {
        Log.d(TAG, "load questions from a file");
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        boolean firstline = true;
        while((line = bf.readLine()) != null){
            if (firstline) {
                firstline = false;
                continue;
            }
            // Category,Question,Answer1,Answer2,Answer3,Answer4,CorrectAnswer
            // your turn: remove magic numbers -> use e num -------------------------------------------
            String[] tokens = line.split(",");
            Question q = new Question(tokens[1]);
            for (int i = 0; i < tokens.length; i++){
                q.addAnswer(tokens[i+2]);
            }
            q.setCorrectAnswer(Integer.parseInt(tokens[6]));

            //add categorie
            // categories.computeIfAbsent(tokens[0], k -> new Arraylist<>().add(q)
            String category = tokens[0];
            if(!questions.containsKey(category)){
                questions.put(category, new ArrayList<>());
            }
            questions.get(category).add(q);
        }
    }

    public static QuestionPool getQuestionPool(){
        if(qp == null){
            qp = new QuestionPool();
        }
        return qp;
    }
}
