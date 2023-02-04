package com.example.aplicacaodeanimal;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LastScreen extends AppCompatActivity {

    Button voltar;
    TextView edRaca1;
    TextView edIdade1;
    TextView edPeso1;
    TextView edCor1;
    TextView tipoAnimal1;
    TextView edSexo1;
    TextView edCorDosOlhos1;
    TextView castrado1;
    TextView edFilhos1;
    TextView edNome1;
    TextView edDataNasc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        voltar = findViewById(R.id.voltar);
        edNome1 = findViewById(R.id.nome1);
        edNome1.setText(getIntent().getStringExtra("nome1"));

        edCor1 = findViewById(R.id.cor1);
        edCor1.setText(getIntent().getStringExtra("cor1"));

        castrado1 = findViewById(R.id.castrado1);
        castrado1.setText(getIntent().getStringExtra("castrado1"));

        edRaca1 = findViewById(R.id.raca1);
        edRaca1.setText(getIntent().getStringExtra("raca1"));

        edIdade1 = findViewById(R.id.idade1);
        edIdade1.setText(getIntent().getStringExtra("idade1"));

        edPeso1 = findViewById(R.id.peso1);
        edPeso1.setText(getIntent().getStringExtra("peso1"));

        tipoAnimal1 = findViewById(R.id.animal1);
        tipoAnimal1.setText(getIntent().getStringExtra("tipo1"));

        edSexo1 = findViewById(R.id.sexo1);
        edSexo1.setText(getIntent().getStringExtra("sexo1"));

        edCorDosOlhos1 = findViewById(R.id.olhos1);
        edCorDosOlhos1.setText(getIntent().getStringExtra("olhos1"));

        edFilhos1 = findViewById(R.id.filhos1);
        edFilhos1.setText(getIntent().getStringExtra("filhos1"));

        edDataNasc = findViewById(R.id.dataNasc2);
        edDataNasc.setText(getIntent().getStringExtra("dataNasc2"));

        voltar.setOnClickListener(v -> telaAnterior(v));

    }

    public void telaAnterior(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}