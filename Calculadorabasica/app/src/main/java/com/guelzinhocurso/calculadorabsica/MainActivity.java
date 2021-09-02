package com.guelzinhocurso.calculadorabsica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText primeiroValor, segundoValor;
    private RadioGroup radioGroup;
    private RadioButton radioAdicao, radioSubtracao, radioMultiplicacao, radioDivisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResultado = findViewById(R.id.textResultado);
        primeiroValor = findViewById(R.id.primeiroValor);
        segundoValor = findViewById(R.id.segundoValor);
        radioGroup = findViewById(R.id.radioGroup);
        radioAdicao = findViewById(R.id.radioAdicao);
        radioSubtracao = findViewById(R.id.radioSubtracao);
        radioMultiplicacao = findViewById(R.id.radioMultiplicacao);
        radioDivisao = findViewById(R.id.radioDivisao);



    }

    public void calculadora (View view) {
        String valor11 = primeiroValor.getText().toString();
        String valor22 = segundoValor.getText().toString();
        Double valor1 = Double.parseDouble(valor11);
        Double valor2 = Double.parseDouble(valor22);


            if (radioAdicao.isChecked()) {


                Double adicao = valor1 + valor2;
                textResultado.setText("O resultado aproximado é: " + Math.round(adicao));


            } else if (radioSubtracao.isChecked()) {

                Double subtracao = valor1 - valor2;
                textResultado.setText("O resultado aproximado é: " + Math.round(subtracao));

            } else if (radioMultiplicacao.isChecked()) {

                Double multiplicacao = valor1 * valor2;
                textResultado.setText("O resultado aproximado é: " + Math.round(multiplicacao));

            } else if (radioDivisao.isChecked()) {

                Double divisao = valor1 / valor2;
                textResultado.setText("O resultado aproximado é: " + Math.round(divisao));

            }


        }


    }

