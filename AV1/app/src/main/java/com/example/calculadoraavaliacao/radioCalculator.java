package com.example.calculadoraavaliacao;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class radioCalculator extends AppCompatActivity {
    EditText edtV1, edtV2, edtResp;
    RadioButton rbSomar, rbSubtrair, rbMultiplicar, rbDividir, rbPotencia, rbRadicia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_calculator);
        edtV1 = (EditText) findViewById(R.id.editValor1);
        edtV2 = (EditText) findViewById(R.id.editValor2);
        edtResp = (EditText) findViewById(R.id.editResp2);
        rbSomar = (RadioButton) findViewById(R.id.radioSomar);
        rbSubtrair = (RadioButton) findViewById(R.id.radioSubtrair);
        rbMultiplicar = (RadioButton) findViewById(R.id.radioMultiplicar);
        rbDividir = (RadioButton) findViewById(R.id.radioDividir);
        rbPotencia = (RadioButton) findViewById(R.id.radioPotencia);
        rbRadicia = (RadioButton) findViewById(R.id.radioRadicia);
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
    }

    public void calcular(View v){
        // Declaração de variáveis
        double v1, v2, resp = 0;
        // entrada de dados
        v1 = Double.parseDouble(edtV1.getText().toString());
        v2 = Double.parseDouble(edtV2.getText().toString());

        if (rbSomar.isChecked()){
            // Tabela Soma
            resp = v1 + v2;
        }else{
            if(rbSubtrair.isChecked()){
                //Tabela Subtração
                resp = v1 - v2;
            }else{
                if(rbMultiplicar.isChecked()){
                    // Tabela Multiplicação
                    resp = v1 * v2;
                }else{
                    if(rbDividir.isChecked()){
                        // Tabela Divisão
                        resp = v1 / v2;
                    }else{
                        if(rbPotencia.isChecked()){
                            // Tabela Potência
                            resp = pow(v1, v2);
                        }else{
                            if(rbRadicia.isChecked()){
                                // Tabela radiciação
                                resp = sqrt(v1);
                            }
                        }
                    }
                }
            }
        }
        // Saída
        edtResp.setText(String.valueOf(resp));
        String result = edtResp.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resp", result);
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}