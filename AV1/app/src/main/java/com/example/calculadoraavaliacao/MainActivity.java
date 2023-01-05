package com.example.calculadoraavaliacao;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2,edtResp;
    static final int ACTIVITY_REQUEST_CALCULAR = 1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edtText1);
        edt2 = (EditText) findViewById(R.id.edtText2);
        edtResp = (EditText) findViewById(R.id.editResp);
    }

    public void callButtonScreen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), buttonCalculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    public void callRadioScreen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), radioCalculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    public void callStaticSpinnerScreen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), staticSpinnerCalculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    public void callDinamicSpinnerScreen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), dinamicSpinnerCalculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    public void callArea1Screen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), area1Calculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    public void callArea2Screen(View v){
        intent = null;
        double val1, val2;
        val1 = Double.parseDouble( edt1.getText().toString());
        val2 = Double.parseDouble( edt2.getText().toString());
        intent = new Intent(getApplicationContext(), area2Calculator.class);
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));
        startActivityForResult(intent, ACTIVITY_REQUEST_CALCULAR);
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == ACTIVITY_REQUEST_CALCULAR && resultCode == RESULT_OK){
            String retorno = data.getStringExtra("resp");
            double calculo = Double.parseDouble(retorno);
            edtResp.setText(String.format("%.2f",calculo));
        }
    }
}