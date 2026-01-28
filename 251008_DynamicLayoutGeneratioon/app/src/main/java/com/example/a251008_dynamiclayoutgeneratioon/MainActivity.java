package com.example.a251008_dynamiclayoutgeneratioon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName().toUpperCase();
    TableLayout layout;
    private final int columns = 10;
    private final int rows = 2;

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
        initGrid();
    }

    private void init(){
        Log.d(TAG, "init starts...");

        layout = findViewById(R.id.main);
        if(layout == null){
            Toast.makeText(this, "No layout found", Toast.LENGTH_LONG).show(); // this is the activity in der wir gerade sind
        }

        Log.d(TAG, "init ends...");
    }

    @SuppressLint("DefaultLocale")
    private void initGrid(){
        // Das is unser Ziel: grid aus Buttons mit Spalten- und Zeilenanzahl (variable)
        /* B = Button
        +---+---+---+---+---+---+---+
        | B | B |   |   |   |   |   |
        +---+---+---+---+---+---+---+
        |   |   |   |   |   |   |   |
        +---+---+---+---+---+---+---+
        |   |   |   |   |   |   |   |
        +---+---+---+---+---+---+---+
        |   |   |   |   |   |   |   |
        +---+---+---+---+---+---+---+
        |   |   |   |   |   |   |   |
        +---+---+---+---+---+---+---+
         */

        // 1. links oben
        // 2. links -> rechts (erste Zeile)
        // 3. neue zeile
        // ... siehe 2

        /* your turn:
            Implement the click event handler for each button
            First approach: Log out detailed information.
         */

        TableRow.LayoutParams params = new TableRow.LayoutParams(0, (int) (60 * getResources().getDisplayMetrics().density), 1);
        params.setMargins(5, 5, 5, 5);

        for(int y = 0; y < columns; y++){ // zeile
            TableRow row = new TableRow(this);
            for(int x = 0; x < rows; x++){
                Button button = new Button(this);
                button.setLayoutParams(params);
                button.setText(String.format("%d/%d", x, y));
                int finalY = y;
                int finalX = x;
                button.setOnClickListener((View v) -> {
                    Log.d(TAG, String.format("Button clicked %d/%d", finalX, finalY));
                });
                row.addView(button);
            }
            layout.addView(row);;
        }
    }
}