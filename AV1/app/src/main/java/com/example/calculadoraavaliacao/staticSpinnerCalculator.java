package com.example.calculadoraavaliacao;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class staticSpinnerCalculator extends AppCompatActivity {

    Spinner spCalculadora;
    EditText edtV1, edtV2, edtResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_spinner_calculator);
        spCalculadora = (Spinner) findViewById(R.id.spinner1);
        edtV1=(EditText) findViewById(R.id.editValor1);
        edtV2=(EditText) findViewById(R.id.editValor2);
        edtResp=(EditText) findViewById(R.id.editResp);
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
    }

    public void calcular(View v){
        Calculator calc = new Calculator (Double.parseDouble(edtV1.getText().toString()), Double.parseDouble(edtV2.getText().toString()));

        if(spCalculadora.getSelectedItem().toString().equals("Somar")){
            edtResp.setText(String.format("%.3f", calc.somar()));
        }else{
            if(spCalculadora.getSelectedItem().toString().equals("Subtrair")){
                edtResp.setText(String.format("%.3f", calc.subtrair()));
            }else{
                if(spCalculadora.getSelectedItem().toString().equals("Multiplicar")){
                    edtResp.setText(String.format("%.3f", calc.multiplicar()));
                }else{
                    if(spCalculadora.getSelectedItem().toString().equals("Dividir")){
                        edtResp.setText(String.format("%.3f", calc.dividir()));
                    }else{
                        if(spCalculadora.getSelectedItem().toString().equals("Exponencial")){
                            edtResp.setText(String.format("%.3f", calc.exponencial()));
                        }else{
                            if(spCalculadora.getSelectedItem().toString().equals("Radiciar")){
                                edtResp.setText(String.format("%.3f", calc.radiciar()));
                            }
                        }
                    }
                }
            }
        }
    }

    public void backToMenuWithResult(View f){
        String resp = edtResp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", resp);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}

