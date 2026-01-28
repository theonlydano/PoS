package com.example.a251020_gesturedetection;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.NotNull;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    public static final String TAG = "GESTURE";

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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        Log.d(TAG, "dispach called...");
        gestureDetector.onTouchEvent(ev);

        return true;
    }
    public void init(){
        gestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(@NotNull MotionEvent e){
            long startTime = System.currentTimeMillis();
            Log.d(TAG, "onDown() starts...");
            // your turn: get the important values from event
            //          log them into netcat
            Log.d(TAG, e.toString());

            Log.d(TAG, "Y: " + e.getY());
            Log.d(TAG,"X: " + e.getX());

            Log.d(TAG, "onDown() ends...");
            long endTime = System.currentTimeMillis();
            Log.d(TAG, "Taken time: " + (endTime - startTime) + " ms");
            return false;
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling() start...");
            // your turn: calculate the distance between press and release
            float startX = e2.getX();
            float startY = e2.getY();

            float endX = e1.getX();
            float endY = e1.getY();

            double distanceX = endX - startX;
            double distanceY = endY - startY;

            double distance = Math.sqrt((distanceX*distanceX)+(distanceY+distanceY));

            Log.d(TAG, "Distance: " + distance);
            return true;
        }
    }
}