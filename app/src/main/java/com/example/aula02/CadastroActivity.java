package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etEmail;
    EditText etIdade;
    EditText etTelefone;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        bCadastrar.setOnClickListener(this::onClick);
    }


    private void onClick(View v) {
        //getText()= vc está acessando o texto no etNome,
        //toString()=vc está estraindo o texto que está lá dentro ,isEmpty()= verifica se está vazio
        if (etNome.getText().toString().isEmpty() ||
            etTelefone.getText().toString().isEmpty() ||
            etEmail.getText().toString().isEmpty() ||
            etIdade.getText().toString().isEmpty()
        ) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            //Variaveis locais
            String nome = etNome.getText().toString();
            String email = etEmail.getText().toString();
            int idade = Integer.parseInt(etIdade.getText().toString());
            String telefone = etTelefone.getText().toString();


            Bundle bundle = new Bundle();  //leva dados de uma activity para outra

            bundle.putString("nome", nome); //bundle que recebe os dados do formulario
            bundle.putString("email", email);
            bundle.putInt("idade", idade);
            bundle.putString("telefone", telefone);

            Intent intent = new Intent(this, ResultadoActivity.class); //para onde agent vai : ResultadoActivity.class

            intent.putExtras(bundle); //guardar o bundle dentro da intent

            startActivity(intent);  //fazer a mudança
        }
    }

    private void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etIdade = findViewById(R.id.etIdade);
        etTelefone = findViewById(R.id.etTelefone);
        bCadastrar = findViewById(R.id.bCadastrar);

    }

    //Para zerar os campos
    @Override
    protected void onStart() {
        super.onStart();
        etNome.getText().clear();
        etEmail.getText().clear();
        etIdade.getText().clear();
        etTelefone.getText().clear();
    }
}