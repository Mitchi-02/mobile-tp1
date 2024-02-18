package com.esisba.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weightEditText, heightEditText;
    TextView resultTextView;
    Button calculateButton;

    ImageView image;

    float weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initilisation();
        HandelingOnCLicks();

    }

    private void HandelingOnCLicks() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatingDATA();
            }
        });
    }

    private void Initilisation() {
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);
        image = findViewById(R.id.ResultIMG);
    }

    private void calculatingDATA() {
        if (!weightEditText.getText().toString().isEmpty() && !heightEditText.getText().toString().isEmpty()) {
            // getting data
            weight = Float.parseFloat(weightEditText.getText().toString());
            height = Float.parseFloat(heightEditText.getText().toString());

            float bmi = calculateBMI(weight, height);
            String result = getResult(bmi);
            resultTextView.setText(result + " (" + String.valueOf(bmi) + ")");
        } else {
            resultTextView.setText("Waiting your informations !");
        }
    }

    private float calculateBMI(float weight, float height) {
        return weight / (height * height / 10000);
    }

    private String getResult(float bmi) {
        String result;

        if (bmi < 16.5) {
            result = "Famine";
            // image 1
            image.setImageResource(R.drawable.ic_launcher_background);
        } else if (bmi < 18.5) {
            result = "Maigreur";
            // image 2
            image.setImageResource(R.drawable.ic_launcher_background);
        } else if (bmi < 25) {
            result = "Corpulence Normale";
            // image 3
            image.setImageResource(R.drawable.ic_launcher_background);
        } else if (bmi < 30) {
            result = "Surpoids";
            // image 4
            image.setImageResource(R.drawable.ic_launcher_background);
        } else if (bmi < 35) {
            result = "Obésité modérée";
            // image 5
            image.setImageResource(R.drawable.ic_launcher_background);
        } else if (bmi < 40) {
            result = "Obésité sévère";
            // image 6
            image.setImageResource(R.drawable.ic_launcher_background);
        } else {
            result = "Obésité morbide ou massive";
            // image 7
            image.setImageResource(R.drawable.ic_launcher_background);
        }

        image.setVisibility(View.VISIBLE);
        return result;
    }
}

