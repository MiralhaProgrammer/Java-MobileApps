package com.guelzinhocurso.calculadoradoamor20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SegundaActivity extends AppCompatActivity {

    private Button fazerDenovo;
    private TextView segundaPrimeironome;
    private TextView segundaSegundonome;
    private TextView porcentagem;
    private TextView mensagem;
    private ImageView imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        segundaPrimeironome = findViewById(R.id.segundaPrimeiroNome);
        segundaSegundonome = findViewById(R.id.textView);
        fazerDenovo = findViewById(R.id.fazerDenovo);
        porcentagem = findViewById(R.id.porcentagem);
        mensagem = findViewById(R.id.mensagem);
        imagem = findViewById(R.id.imagem);


        //settando numero random na porcentagem
        int numeroRandom = new Random().nextInt(101);
        porcentagem.setText(numeroRandom + "%");

        // puxando dados dos nomes da primeira activity e substituindo no layout

        Bundle dadosPrimeira = getIntent().getExtras();
        String primeiroNomerecebido = dadosPrimeira.getString("primeiroEnviado");
        String segundoNomerecebido = dadosPrimeira.getString("segundoEnviado");

        segundaPrimeironome.setText(primeiroNomerecebido);
        segundaSegundonome.setText(segundoNomerecebido);

        //condição com mensagem e mudando imagem

        if (numeroRandom <= 20){
            mensagem.setText("Infelizmente você e " + segundoNomerecebido + " possuem uma química de " + numeroRandom + "%" + ", você pode até tentar, mas eu recomendaria cair fora");
            imagem.setImageResource(R.drawable.akinator020);
        }

        if (numeroRandom >= 21 && numeroRandom <=50){
            mensagem.setText("A chance de você e " + segundoNomerecebido + " darem certo é de " + numeroRandom + "%" + ". Podemos dizer que é uma química neutra. Fica por sua conta, os números podem ser mudados!");
            imagem.setImageResource(R.drawable.akinator2149);
        }

        if (numeroRandom >= 51 && numeroRandom<=100){
            mensagem.setText("Parabens!! Você e " + segundoNomerecebido + " possuem uma química de " + numeroRandom + "%" + "!!! Isso é estraordinário!!! Vai fundo guerreiro(a)!");
            imagem.setImageResource(R.drawable.akinator50100);
        }

















        fazerDenovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }


}
