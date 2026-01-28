package com.example.a250915_exa_103_currencyconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    EditText currencyInput;
    TextView currencyOutput;
    // Button convert;
    ImageButton changeCurrency;

    boolean type; // false = EUR, true = USD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Start onCreate() of MainActivity");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        type = false;

        init();

        currencyInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Nichts
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nichts
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    if (type) {
                        currencyOutput.setText(currencyInput.getText().toString() + " EUR" + " is " + Integer.parseInt(currencyInput.getText().toString()) * 1.2 + " USD");
                    } else {
                        currencyOutput.setText(currencyInput.getText().toString() + " USD" + " is " + Integer.parseInt(currencyInput.getText().toString()) / 1.2 + " EUR");
                    }
                }catch (Exception e){
                    // Nichts
                }
            }
        });

        changeCurrency.setOnClickListener((changeCurrency) -> {
            if(type){
                type = false;
                currencyInput.setHint("USD");
            } else {
                type = true;
                currencyInput.setHint("EUR");
            }
            try {
                if (type) {
                    currencyOutput.setText(currencyInput.getText().toString() + " EUR" + " is " + Integer.parseInt(currencyInput.getText().toString()) * 1.2 + " USD");
                } else {
                    currencyOutput.setText(currencyInput.getText().toString() + " USD" + " is " + Integer.parseInt(currencyInput.getText().toString()) / 1.2 + " EUR");
                }
            }catch (Exception e){
                Log.d(TAG, e.toString());
            }
        });

        Log.d(TAG, "END onCreate() of MainActivity");

    }

    private void init(){
        currencyInput = findViewById(R.id.currencyInput);
        currencyOutput = findViewById(R.id.currencyOutput);
        changeCurrency = findViewById(R.id.changeCurrency);
    }

}