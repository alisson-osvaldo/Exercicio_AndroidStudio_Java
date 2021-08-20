package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TemperaturaActivity extends AppCompatActivity {

    EditText etCelsius;
    Button bConverter;
    TextView tvK;
    TextView tvF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        etCelsius = findViewById(R.id.etCelsius);
        bConverter = findViewById(R.id.bConverter);
        tvK = findViewById(R.id.tvK);
        tvF = findViewById(R.id.tvF);

        bConverter.setOnClickListener((v -> {
            if(etCelsius.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha a temperatura...", Toast.LENGTH_SHORT).show();
            } else {
                float c = Float.parseFloat(etCelsius.getText().toString());

                float f = (c * (9/5)) + 32;
                float k = c + 273.15f;

                tvK.setText("K: " + k);
                tvF.setText("F: " + f);

                etCelsius.getText().clear();
            }

        }));
    }
}