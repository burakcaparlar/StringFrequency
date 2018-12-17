package com.example.bcaparlar.stringfrequency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText inputET, freqET;
    private Button calculateButton;
    private TextView calculatedText;
    private int freq = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputET.getText().toString().isEmpty()) {
                    if (!freqET.getText().toString().isEmpty()) {
                        freq = Integer.parseInt(freqET.getText().toString());
                        ArrayList<FreqVal> list = calculateFrequency();
                        showText(list);
                    } else {
                        showToast("Lütfen frekans giriniz.");
                    }
                } else {
                    showToast("Lütfen bir string giriniz.");
                }
            }
        });

    }

    private void init() {
        inputET = findViewById(R.id.inputET);
        freqET = findViewById(R.id.freqET);
        calculateButton = findViewById(R.id.calculateButton);
        calculatedText = findViewById(R.id.calculatedText);
    }

    public void showToast(String message) {
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    private ArrayList<FreqVal> calculateFrequency() {
         char[] array = inputET.getText().toString().toCharArray();

        ArrayList<FreqVal> list = new ArrayList<>();

         for (char c : array) {
             if (list.size() == 0) {
                 FreqVal freqVal = new FreqVal(c, 1);
                 list.add(freqVal);
             } else {
                 if (list.get(list.size() - 1).aChar == c) {
                     list.get(list.size() -1).increaseFrequency();
                 } else {
                     FreqVal freqVal = new FreqVal(c, 1);
                     list.add(freqVal);
                 }
             }
         }

         return list;
    }

    private void showText(ArrayList<FreqVal> list) {
        String text = "";
        for (FreqVal freqVal : list) {
            if (freqVal.freq >= freq) {
                for (int index = 0; index < freqVal.freq; index++) {
                    text += "*";
                }
            } else {
                for (int index = 0; index < freqVal.freq; index++) {
                    text += freqVal.aChar;
                }
            }
        }

        calculatedText.setText(text);
    }
}
