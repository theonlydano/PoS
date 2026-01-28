package com.example.a250922_exa_104_fuelconsumption;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button calc;
    EditText km;
    EditText liter;

    TextView result;

    @SuppressLint("SetTextI18n")
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


            calc = findViewById(R.id.calc);
            km = findViewById(R.id.km);
            liter = findViewById(R.id.liter);
            result = findViewById(R.id.result);

            calc.setOnClickListener((view) -> {
                int kmNumber = 1;
                int literNumber = 1;

                try {
                    kmNumber = Integer.parseInt(km.getText().toString());
                    literNumber = Integer.parseInt(liter.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }

                result.setText("" + (float) literNumber / (float) kmNumber);
            });

    }
}