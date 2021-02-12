package com.example.ejercicio3ecuacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvResultado;
    private TextView tvResultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casteo();
    }

    private void casteo(){
        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        etC = (EditText) findViewById(R.id.etC);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvResultado2 = (TextView) findViewById(R.id.tvResultado2);
    }

    public void Calcular(View view){
        if(etA.getText().toString().isEmpty() || etB.getText().toString().isEmpty() || etC.getText().toString().isEmpty()){
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_LONG ).show();
            return;
        }

        double A = Double.parseDouble(etA.getText().toString());
        double B = Double.parseDouble(etB.getText().toString());
        double C = Double.parseDouble(etC.getText().toString());

        if(A==0){
            Toast.makeText(this, "A no puede ser cero", Toast.LENGTH_LONG ).show();
            return;
        }

        Double raizResultado = Math.sqrt((B*B)-(4*A*C));
        if(raizResultado.isNaN()){
            tvResultado.setText("No tiene solución");
            tvResultado2.setText("");
            return;
        }
        double resultadoPositivo = (-B + raizResultado)/(2*A);
        double resultadoNegativo = (-B - raizResultado)/(2*A);

        tvResultado.setText("El resultado positivo es: "+resultadoPositivo);
        tvResultado2.setText("El resultado negativo es: "+resultadoNegativo);


    }
}