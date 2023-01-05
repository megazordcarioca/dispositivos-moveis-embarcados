package com.example.calculadoraavaliacao;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.widget.EditText;

public class Calculator {
    double valor1, valor2;
    EditText edtResp;
    //Atributos

    public Calculator() {  } // Construtores

    public Calculator(double v1, double v2){
        setValor1(v1);
        setValor2(v2);
    }

    public void setValor1(double valor){ // Metodos de Acesso
        valor1= valor;

    }
    public double getValor1(){

        return valor1;
    }
    public void setValor2(double valor){

        valor2 = valor;
    }
    public double getValor2(){

        return valor2;
    }
    public double somar() { // Metodos Extras
        return valor1 + valor2;

    }
    public double subtrair(){

        return valor1 - valor2;
    }
    public double multiplicar(){

        return valor1 * valor2;
    }
    public double dividir(){

        return valor1 / valor2;
    }
    public double exponencial(){

        return pow(valor1,valor2);
    }
    public double radiciar(){

        return sqrt(valor1);
    }

    public double triangle(){
        return multiplicar()/2;
    }

    public double square(){
        return multiplicar();
    }

}