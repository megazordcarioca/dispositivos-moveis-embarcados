package com.example.aplicacaodeanimal;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.DatePicker;

import java.util.Locale;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edRaca;
    EditText edIdade;
    EditText edPeso;
    EditText edCor;
    EditText tipoAnimal;
    RadioButton rdSexoM, rdSexoF;
    EditText edCorDosOlhos;
    CheckBox castrado;
    EditText edFilhos;
    EditText edNome;
    Button ultimo;
    String sexo;
    EditText dtNasc;
    DatePickerDialog datePicker;
    // declaração do objeto para o armazenamento das preferências
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome =findViewById(R.id.nome);
        tipoAnimal = findViewById(R.id.animal);
        rdSexoF = (RadioButton) findViewById(R.id.radio1);
        rdSexoM = (RadioButton) findViewById(R.id.radio2);
        edRaca = findViewById(R.id.raca);
        edCor = findViewById(R.id.cor);
        edIdade = findViewById(R.id.idade);
        edPeso = findViewById(R.id.peso);
        castrado = findViewById(R.id.castrado);
        edCorDosOlhos = findViewById(R.id.olhos);
        edFilhos = findViewById(R.id.filhos);
        ultimo = findViewById(R.id.ultimo);
        dtNasc = (EditText) findViewById(R.id.dataNasc);

        prefs = getSharedPreferences("dadosAnimal", MODE_PRIVATE);

        ultimo.setOnClickListener(v -> {
            proximaTela(v);
            onResume();
        });
        entradaDosDados();
    }

    public void proximaTela(View view) {
        Intent intent = new Intent(this, LastScreen.class);

        String raca, cor, tipo, cordosolhos, nome,peso,idade,filhos, dataNasc;

        raca = edRaca.getText().toString();
        cor = edCor.getText().toString();
        nome =edNome.getText().toString();
        tipo =tipoAnimal.getText().toString();
        cordosolhos =edCorDosOlhos.getText().toString();
        idade = edIdade.getText().toString();
        filhos = edFilhos.getText().toString();
        peso = edPeso.getText().toString();
        dataNasc = dtNasc.getText().toString();

        intent.putExtra("raca1",raca);
        intent.putExtra("cor1",cor);
        if (rdSexoM.isChecked()) {
            intent.putExtra("sexo1","Macho");
        }else{
            intent.putExtra("sexo1","Fêmea");
        }
        intent.putExtra("olhos1",cordosolhos);
        intent.putExtra("tipo1",tipo);
        intent.putExtra("nome1",nome);
        intent.putExtra("idade1",String.valueOf(idade));
        intent.putExtra("peso1",String.valueOf(peso));
        intent.putExtra("filhos1",String.valueOf(filhos));
        if (castrado.isChecked()){
            intent.putExtra("castrado1", "Castrado");
        }else{
            intent.putExtra("castrado1", "Nao Castrado");
        }
        startActivity(intent);
        intent.putExtra("dataNasc2", String.valueOf(dataNasc));
    }
    public void entradaDosDados(){

        if (prefs.contains("raca")) {
            edRaca.setText(prefs.getString("raca", "raca?"));
        }
        if (prefs.contains("nome")) {edNome.setText(prefs.getString("nome", "nome?"));
        }
        if (prefs.contains("idade")) {
            edIdade.setText(prefs.getString("idade", "idade?"));
        }
        if (rdSexoM.isChecked()) {
            //Femea
            sexo = "Macho" ;
        }else{
            sexo = "Fêmea";
        }
        if (prefs.contains("peso")) {
            edPeso.setText((prefs.getString("peso","peso?")));
        }
        if (prefs.contains("cor")) {
            edCor.setText(prefs.getString("cor", "cor?"));
        }
        if (prefs.contains("tipo")) {
            tipoAnimal.setText(prefs.getString("tipo", "tipo?"));
        }
        if (prefs.contains("cordosolhos")) {
            edCorDosOlhos.setText(prefs.getString("cordosolhos", "cordosolhos?"));
        }
        if (prefs.contains("filhos")) {
            edFilhos.setText(prefs.getString("filhos", "filhos?"));
        }
        castrado.setChecked(prefs.contains("castrado") && prefs.getBoolean("castrado", false));
        dtNasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int cYear =  c.get(Calendar.YEAR);
                int cMonth = c.get(Calendar.MONTH);
                int cDay = c.get(Calendar.DAY_OF_MONTH);

                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dtNasc.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },cYear, cMonth, cDay);
                datePicker.show();
            }});
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences.Editor prefUsu = prefs.edit();

        prefUsu.putString("nome", edNome.getText().toString());
        prefUsu.putString("raca", edRaca.getText().toString());
        prefUsu.putBoolean("sexo", rdSexoF.isChecked() || rdSexoM.isChecked());
        prefUsu.putString("cor", edCor.getText().toString());
        prefUsu.putString("filhos", edFilhos.getText().toString());
        prefUsu.putString("cordosolhos", edCorDosOlhos.getText().toString());
        prefUsu.putString("brilho", edFilhos.getText().toString());
        prefUsu.putString("idade", edIdade.getText().toString());
        prefUsu.putString("tipo", tipoAnimal.getText().toString());
        prefUsu.putString("peso", edPeso.getText().toString());
        prefUsu.putBoolean("castrado", castrado.isChecked());
        prefUsu.apply();
    }
}