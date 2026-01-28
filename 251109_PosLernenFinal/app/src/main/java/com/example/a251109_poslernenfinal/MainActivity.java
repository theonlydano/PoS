package com.example.a251109_poslernenfinal;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BackgroundTasks bk;

    private int currentPointer = 0;
    private int oldPointer = 0;
    private GestureDetector gd;
    List<String> lines;
    String[] parts;

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

    private void init(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.questions)));
            lines = bf.lines().toList();
            parts = lines.get(0).split(";");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.bk = new BackgroundTasks(findViewById(R.id.main), this);
        this.gd = new GestureDetector(this, new MyGestureDetector());
    }

    private void update(){
        bk.update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class BackgroundTasks {
        private GridLayout mainView;
        private Context mainContext;
        private ArrayList<TextView> textViews;
        public BackgroundTasks(GridLayout m, Context c){
            this.mainView = m;
            this.mainContext = c;
            mainView.setRowCount(5);
            mainView.setColumnCount(1);
            textViews = new ArrayList<>();

            for (int i = 0; i < 5; i++){
                TextView temp = new TextView(mainContext);
                temp.setText(parts[i]);
                temp.setBackgroundColor(Color.rgb(i*5, i*5, i*5));
                temp.setPadding(100, 100, 100, 100);
                textViews.add(temp);
                mainView.addView(temp);
            }
        }

        public void update(){
            textViews.get(oldPointer).setBackgroundColor(Color.rgb(0,0,0));
            textViews.get(currentPointer).setBackgroundColor(Color.rgb(255, 255,255));
        }
    }

    private class MyGestureDetector extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            Log.d("FLING", "Fling started...");
            float yAVG = e1.getY() - e2.getY();

            if(yAVG > 0){
                if (currentPointer > 0){
                    oldPointer = currentPointer;
                    currentPointer--;
                }
            }else {
                if (currentPointer < 4){
                    oldPointer = currentPointer;
                    currentPointer++;
                }
            }

            update();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}