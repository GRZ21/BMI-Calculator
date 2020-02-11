package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button button;
    EditText heighText, weighText;
    TextView resText,resText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        heighText = findViewById(R.id.editText1);
        weighText = findViewById(R.id.editText2);
        resText = findViewById(R.id.textView3);
        resText2 = findViewById(R.id.textView4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button) {
                    String height = heighText.getText().toString();
                    String weight = weighText.getText().toString();
                    double result, heightNum, weightNum;
                    if (!height.isEmpty() && !weight.isEmpty()) {
                        heightNum = Double.parseDouble(height);
                        weightNum = Double.parseDouble(weight);
                        result = weightNum / (heightNum * heightNum * 0.0001);
                        resText2.setText(String.valueOf(result));
                        if (result < 18.5) {
                            resText.setText(R.string.thin);
                        } else if (result > 24.5) {
                            resText.setText(R.string.fat);
                        } else
                        resText.setText(R.string.normal);
                    }
                }
            }
        });


    }
}

