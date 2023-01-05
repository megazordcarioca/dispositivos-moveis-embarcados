package com.example.calculadoraavaliacao;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class area2Calculator extends AppCompatActivity {
    EditText edtV1, edtV2, edtResp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_calculator_1);
        edtV1 = (EditText) findViewById(R.id.edtText1);
        edtV2 = (EditText) findViewById(R.id.edtText2);
        edtResp = (EditText) findViewById(R.id.editResp);
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
    }

    @SuppressLint("DefaultLocale")
    public void calcular(View v){
        Calculator calc = new Calculator (Double.parseDouble(edtV1.getText().toString()), Double.parseDouble(edtV2.getText().toString()));
        edtResp.setText(String.format("%.2f", calc.square()));
    }

    public void backToMenuWithResult(View f){
        String resp = edtResp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", resp);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}