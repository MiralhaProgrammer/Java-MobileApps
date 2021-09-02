package com.guelzinhocurso.calculadoradoamor20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoCalcular;
    private EditText nome1;
    private EditText nome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome1 = findViewById(R.id.nome1);
        nome2 = findViewById(R.id.nome2);

        botaoCalcular = findViewById(R.id.botaoCalcular);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String primeiroNome = nome1.getText().toString();
                String segundoNome = nome2.getText().toString();

                if( primeiroNome == null || primeiroNome.equals("") ){

                    Toast.makeText(getApplicationContext(), "Nome inválido ou vazio", Toast.LENGTH_SHORT).show();
                }

                else if (segundoNome == null || segundoNome.equals("")){
                    Toast.makeText(getApplicationContext(), "Nome inválido ou vazio", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent abrirSegunda = new Intent(getApplicationContext(), SegundaActivity.class);

                    abrirSegunda.putExtra("primeiroEnviado", primeiroNome);
                    abrirSegunda.putExtra("segundoEnviado", segundoNome);

                    startActivity(abrirSegunda);

                    nome1.setText("");
                    nome2.setText("");




                }




            }
        });
    }
}
