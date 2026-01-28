package com.example.a250929_quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "QUIZ_SC";
    private Question currentQuestion;

    private TextView tvCategory;
    private TextView tvQuestion;
    private final int BUTTON_ANSWERS = 4;
    private Button[] answerButtons = new Button[BUTTON_ANSWERS];
    private Button btNext;
    private boolean answerCorrect; // not default false since when no question is locked then null
    QuestionPool qp;
    int questionIndex;
    int answerChosen;
    TableRow answersToMake;

    // Inner Class
    MyOnclickListener myOnclickListener;
    private class MyOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Check which view was clicked by its ID
            if (v.getId() == R.id.btAnswer1) {
                Log.d(TAG, "Answer 1 clicked");
                answerChosen = 1;
            }
            else if (v.getId() == R.id.btAnswer2) {
                Log.d(TAG, "Answer 2 clicked");
                answerChosen = 1;
            }
            else if (v.getId() == R.id.btAnswer3) {
                Log.d(TAG, "Answer 3 clicked");
                answerChosen = 1;
            }
            else if (v.getId() == R.id.btAnswer4) {
                Log.d(TAG, "Answer 4 clicked");
                answerChosen = 1;
            }
            else if (v.getId() == R.id.btNext) {
                Log.d(TAG, "Next button clicked");
                update(); // load next question
            }

        }
    }

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
        update();
    }

    private void init() {
        questionIndex = 0;
        myOnclickListener = new MyOnclickListener();

        tvCategory = findViewById(R.id.tvCategory);
        tvQuestion = findViewById(R.id.tvQuestion);
        btNext = findViewById(R.id.btNext);
        btNext.setEnabled(false); // ------------------------------------------------- Set false
        btNext.setOnClickListener((View v) -> {
            nextQuestion();
        });
        /*
        btNext.setOnClickListener((View) => {

        });
         */

        // your turn: init the button array
        answerButtons[0] = findViewById(R.id.btAnswer1);
        answerButtons[1] = findViewById(R.id.btAnswer2);
        answerButtons[2] = findViewById(R.id.btAnswer3);
        answerButtons[3] = findViewById(R.id.btAnswer4);

        for (Button b : answerButtons) {
            View.OnClickListener myOnyclickListener = myOnclickListener;
            b.setOnClickListener(myOnyclickListener);
        }

        qp = QuestionPool.getQuestionPool();
        qp.initQuestions("school");
        try{
            InputStream is = getResources().openRawResource(R.raw.questions);
            qp.loadFromFile(is);
        }catch (Exception ex){
            ex.printStackTrace();
            Log.d(TAG, "crashed by loading file");
        }

        answersToMake = findViewById(R.id.answersToMake);
        
    }

    // setup the next question
    private void update() {
        // your turn: refactor the code to geeth the current question from pool
        // hint: use a constant category

        // 250929 task: your turn: get all categories from pool
        // res/raw resource folder
        // named questions.csv
        // Category Question Option 1 Option 2 Option 3
        String category = "school";

        /*
        currentQuestion = new Question("Frage Number 1");
        currentQuestion.setCorrectAnswer(3);
        currentQuestion.addAnswer("Antwort 1");
        currentQuestion.addAnswer("Antwort 2");
        currentQuestion.addAnswer("Antwort 3");
        currentQuestion.addAnswer("Antwort 4");
         */
        try {
            currentQuestion = qp.questions.get(category).get(questionIndex);
            questionIndex++;
        } catch (NullPointerException nuex){
            throw new RuntimeException();
        }
        tvQuestion.setText(category);

        tvQuestion.setText(currentQuestion.getText());
        // for(String answer : currentQuestion.getAnswers)
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(currentQuestion.getAnswers().get(i));
        }
    }

    private void checkAnswer(){
        if(answerCorrect){
            nextQuestion();
        }
    }
    private void nextQuestion(){
        Log.d(TAG, "Next Question Starts...");
        update();
        btNext.setEnabled(false);
    }
}