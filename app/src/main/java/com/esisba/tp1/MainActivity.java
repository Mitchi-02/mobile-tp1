package com.esisba.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weightEditText = findViewById(R.id.weightEditText);
        final EditText heightEditText = findViewById(R.id.heightEditText);
        final TextView resultTextView = findViewById(R.id.resultTextView);
        final Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(weightEditText.getText().toString());
                double height = Double.parseDouble(heightEditText.getText().toString());

                double bmi = calculateBMI(weight, height);
                String result = getResult(bmi);

                resultTextView.setText(result+ " (" + String.valueOf(bmi) + ")");
            }
        });
    }

    private double calculateBMI(double weight, double height) {
        return weight / (height * height / 10000);
    }

    private String getResult(double bmi){
        if(bmi < 16.5){
            return "Famine";
        }else if(bmi < 18.5){
            return "Maigreur";
        }else if(bmi < 25){
            return "Corpulence Normale";
        }else if(bmi < 30){
            return "Surpoids";
        } else if(bmi < 35){
            return "Obésité modérée";
        } else if(bmi < 40){
            return "Obésité sévère";
        } else {
            return "Obésité morbide ou massive";
        }
    }
}

