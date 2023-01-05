package com.example.calculadoraavaliacao;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class buttonCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_calculator);
        edtV1 = (EditText) findViewById(R.id.edtText1);
        edtV2 = (EditText) findViewById(R.id.edtText2);
        edtResp = (EditText) findViewById(R.id.editResp);
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
    }
    EditText edtV1, edtV2, edtResp;
    public void somar(View v){
        // Declaração de variáveis
        double v1, v2, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());
        // processamento
        resp = v1 + v2;
        // saída
        edtResp.setText(String.valueOf(resp));
    }
    public void subtrair(View c){
        // Declaração de variáveis
        double v1, v2, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());
        // processamento
        resp = v1 - v2;
        // saída
        edtResp.setText(String.valueOf(resp));
    }
    public void multiplica(View d){
        // Declaração de variáveis
        double v1, v2, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());
        // processamento
        resp = v1 * v2;
        // saída
        edtResp.setText(String.valueOf(resp));
    }
    public void dividir(View e){
        // Declaração de variáveis
        double v1, v2, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());
        // processamento
        resp = v1 / v2;
        // saída
        edtResp.setText(String.valueOf(resp));
    }

    public void potencia(View e){
        // Declaração de variáveis
        double v1, v2, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());
        // processamento
        resp = pow(v1,v2);
        // saída
        edtResp.setText(String.valueOf((resp)));
    }

    public void radicia(View e){
        // Declaração de variáveis
        double v1, resp;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        // processamento
        resp = sqrt(v1);
        // saída
        edtResp.setText(String.valueOf((resp)));
    }

    public void backToMenuWithResult(View f){
        String resp = edtResp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", resp);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}