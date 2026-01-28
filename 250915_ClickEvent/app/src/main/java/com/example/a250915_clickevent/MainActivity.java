package com.example.a250915_clickevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
    your turn:

    + layout:
        + first line: App Name
        + second line: Label with "name" and one EditText
        + third line: Button with Text: "Click me"
        + fourth line: TextView with a text "name missing"

     */

    private Button btClickMe;
    private TextView tvShowName;
    private EditText etName;

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

        // init of instance variables
        btClickMe = findViewById(R.id.btClickMe);
        etName = findViewById(R.id.etName);
        tvShowName = findViewById(R.id.tvShowName);

        btClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                tvShowName.setText(name);
                Toast.makeText(MainActivity.this, "Toast - miam", Toast.LENGTH_SHORT).show();
            }
        });

        tvShowName.setOnClickListener((theClickedView) -> {
                Toast.makeText(MainActivity.this, "Clicked on tvShowName", Toast.LENGTH_SHORT).show();
        });

    }
}