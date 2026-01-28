package com.example.a251013_exa_108_numberpuzzlegame;

import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName().toUpperCase();
    TableLayout layout;
    public final int rows = 4;
    public final int collums = 4;
    public ArrayList<Integer> numbers;
    boolean done = false;
    ArrayList<Button> buttons = new ArrayList<Button>();

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

    public void init(){
        layout = findViewById(R.id.main);
        if(layout == null){
            Toast.makeText(this, "No layout found", Toast.LENGTH_LONG).show(); // this is the activity in der wir gerade sind
        }

        numbers = new ArrayList<Integer>();
        for (int i = 1; i < (rows * collums); i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        Log.d(TAG, "init: " + numbers);
    }

    public void update(){
        // Fit screen with so it looks NOICE
        int screenWidth = getResources().getDisplayMetrics().widthPixels - 40;
        int buttonSize = screenWidth / collums;
        TableRow.LayoutParams params = new TableRow.LayoutParams(buttonSize, buttonSize);
        params.setMargins(5, 5, 5, 5);

        int atNumbers = 0;
        for (int y = 0; y < rows; y++){
            TableRow r = new TableRow(this);
            for (int x = 0; x < collums; x++){
                Button b = new Button(this);
                try {
                    b.setText(String.valueOf(numbers.get(atNumbers)));
                    /* --------- Background switching does not work so excluded the Background-color
                    if(numbers.get(atNumbers)%2 == 1){
                        b.setBackgroundColor(Color.RED);
                    }

                     */
                    int id = (y*10) + x + 1;
                    b.setId(id);
                    buttons.add(b);  // ---------------------------------------- Store in a 2d array
                }catch (Exception ex){
                    b.setId(0);
                    b.setEnabled(false);
                    buttons.add(b);
                }
                b.setOnClickListener( ( v) -> {
                    switchButtons(b);
                });
                b.setLayoutParams(params);
                /*
                try{
                    if(numbers.get(atNumbers) % 2 == 1){
                        b.setBackgroundColor(getColor(android.R.color.holo_red_dark));
                    }
                } catch (Exception ex){
                    Log.d(TAG, "update: crash at color setter");
                }

                ############################ COLOR SETTER DOES NOT WORK ############################

                 */
                r.addView(b);
                atNumbers++;
            }
            layout.addView(r);
        }

        // TableRow resetter = new TableRow(this);
        Button reset = new Button(this);
        reset.setId((int)999);
        reset.setText("RESET");
        reset.setOnClickListener( (view) -> {
            layout.removeAllViewsInLayout();
            init();
            update();
        });
        // resetter.addView(reset);
        layout.addView(reset);

        Log.d(TAG, "Buttons: " + buttons);
    }
    private void switchButtons(Button bToSwitch) {
        try {
            // Find the empty button (id == 0)
            Button emptyButton = findViewById(0);
            if (emptyButton == null) return;

            int clickedIndex = buttons.indexOf(bToSwitch);
            int emptyIndex = buttons.indexOf(emptyButton);

            // Compute row and column for both
            int clickedRow = clickedIndex / collums;
            int clickedCol = clickedIndex % collums;
            int emptyRow = emptyIndex / collums;
            int emptyCol = emptyIndex % collums;

            // Check adjacency (up, down, left, right)
            boolean isAdjacent =
                    (clickedRow == emptyRow && Math.abs(clickedCol - emptyCol) == 1) ||  // Left or right
                            (clickedCol == emptyCol && Math.abs(clickedRow - emptyRow) == 1);    // Up or down

            if (!isAdjacent) {
                Toast.makeText(this, "You can only move adjacent tiles!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Swap texts and enabled states
            emptyButton.setText(bToSwitch.getText());
            emptyButton.setEnabled(true);

            bToSwitch.setText("");
            bToSwitch.setEnabled(false);

            emptyButton.setId(View.generateViewId());
            bToSwitch.setId(0);

            checkIfDone();

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, "switchButtons: crashed");
        }
    }

    private void checkIfDone(){
        int starter = 0;
        done = true;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < collums; x++) {
                try {
                    Button b = buttons.get(starter);
                    if (Integer.parseInt(b.getText().toString()) != starter + 1){
                        done = false;
                        Log.d(TAG, b.getText().toString());
                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                    String problem = ex.toString();
                    Log.d(TAG, "checkIfDone: " + problem);
                }
                if(starter < (rows * collums) - 1){
                    starter++;
                }
            }
        }
        if (done){
            Log.d(TAG, "done");
            Toast doneToast = new Toast(this);
            doneToast.setText("CONGRATS YOU ARE DONE");
            doneToast.show();
        }
    }
}