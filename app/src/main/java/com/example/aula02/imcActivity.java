package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class imcActivity extends AppCompatActivity {

    EditText etPeso;
    EditText etAltura;
    Button bCalc;
    TextView tvIMC;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        inicializarComponentes();

        bCalc.setOnClickListener(v -> {
            //verificar se tem algum campo vazio
            if(etPeso.getText().toString().isEmpty() || etAltura.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha Peso e Altura para efetuar o calculo!", Toast.LENGTH_SHORT).show();
            } else {
                //armazenado em variaveis locais peso e altura
                float peso = Float.parseFloat(etPeso.getText().toString());
                float altura = Float.parseFloat(etAltura.getText().toString());

                float imc = peso / (altura*altura);
                String status;

                if (imc < 18.5f){
                    status = "Abaixo do Peso";
                } else if (imc < 25){
                    status = "Peso Normal";
                } else if (imc < 30){
                    status ="Sobrepeso";
                } else if (imc < 35){
                    status = "Obesidade Grau I";
                } else if (imc < 40) {
                    status = "Obesidade Grau II (severa)";
                } else {
                    status = "Obesidade Grau III (Mórbida)";
                }

                //Convertendo floar do imc com apenas 1 casa decimal
                String res = String.format("%.1f", imc);
                tvIMC.setText(res); //enviando para o IMC
                tvStatus.setText(status); //enviando para o status

                //limpar os edit text
                etPeso.getText().clear();
                etAltura.getText().clear();
            }
        });


    }

    private void inicializarComponentes(){
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        bCalc = findViewById(R.id.bCalc);
        tvIMC = findViewById(R.id.tvIMC);
        tvStatus = findViewById(R.id.tvStatus);

    }
}