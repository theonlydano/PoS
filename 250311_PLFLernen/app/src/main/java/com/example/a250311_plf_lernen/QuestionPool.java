package com.example.a250311_plf_lernen;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionPool {

    public ArrayList<Question> questions = new ArrayList<>();
    private int currentQuestion = 0;

    public void setQuestions(InputStream in) throws IOException {
        List<String> lines = new String(in.readAllBytes()).lines().toList();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(";");

            if (parts.length == 6) {
                Question q = new Question();
                q.setTitle(parts[0]);
                q.setQ1(parts[1]);
                q.setQ2(parts[2]);
                q.setQ3(parts[3]);
                q.setQ4(parts[4]);
                q.setCorrectAnswer(Integer.parseInt(parts[5]));
                questions.add(q);
            } else {
                System.out.println("Skipping malformed line: " + line);
            }
        }
    }

    public Question getNext(){
        currentQuestion++;
        return questions.get(currentQuestion-1);
    }
}
