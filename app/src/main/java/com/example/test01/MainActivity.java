package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView showbmi;
    private String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edHeight);
        weight = findViewById(R.id.edWeight);
        showbmi = findViewById(R.id.tvShowBMI);
    }

    public void calBMI(View view) {
        if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()){
            showbmi.setText("請輸入身高或體重的數值");
        }else {
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / ((h/100.0) * (h/100.0));
            b = String.format("%.1f",bmi);
            showbmi.setText(String.valueOf(b));
            if(bmi < 18.5){
                showbmi.setText(b+" 體重過輕");
            }else if(bmi >= 18.5 && bmi <= 23.9){
                showbmi.setText(b+" 體重正常");
            }
            else if(bmi >= 24 && bmi <= 27.9){
                showbmi.setText(b+" 體重過重");
            }
        }

    }
}