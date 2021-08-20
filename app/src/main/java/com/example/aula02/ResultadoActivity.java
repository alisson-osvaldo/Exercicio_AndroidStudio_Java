package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvEmail;
    TextView tvIdade;
    TextView tvTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        inicializarComponentes();

        Intent intent = getIntent(); // Recebemos esta intent da activity que disparou essa intent

        Bundle bundle = intent.getExtras(); //guardando um valor extra dentro da intent???

        if(bundle == null){//Se algum Bundle for nullo, significa que alguma activity disparou está de forma equivocada
            Toast.makeText(this, "Activity não iniciada corretamente...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }

        tvNome.setText(bundle.getString("nome"));
        tvEmail.setText(bundle.getString("email"));
        tvIdade.setText(String.valueOf(bundle.getInt("idade")));
        tvTelefone.setText(bundle.getString("telefone"));
    }

    private void inicializarComponentes(){
        tvNome = findViewById(R.id.tvNome);
        tvEmail = findViewById(R.id.tvEmail);
        tvIdade = findViewById(R.id.tvIdade);
        tvTelefone = findViewById(R.id.tvTelefone);

    }


}