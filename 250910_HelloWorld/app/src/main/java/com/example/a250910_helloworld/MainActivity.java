package com.example.a250910_helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // remove generated code

        /*
        your turn: replace "hello world" with your name

        your turn:
            + add a field (TextView) with your mailaddress
            + change the background of the mailaddress


        your turn:
            + add a linear layout (horizontal)
            -> <TextField>name:</TextField><EditText>
         */
    }
}