package com.guelzinhocurso.listatarefasfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.guelzinhocurso.listatarefasfinal.BancoDados.TarefaDAO;
import com.guelzinhocurso.listatarefasfinal.RecyclerView.ListaValores;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText textTarefa;
    private ListaValores tarefaRecuperada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        textTarefa = findViewById(R.id.addTarefa);

        //Recuperar tarefa caso seja edição

        tarefaRecuperada= (ListaValores) getIntent().getSerializableExtra("tarefaSelecionada");

        //Configurar tarefa na caixa de texto
        if(tarefaRecuperada!=null){//for diferente de nulo
            textTarefa.setText(tarefaRecuperada.getNomeTarefa()); //Seta o texto com o nome recuperado

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                String nomeTarefa = textTarefa.getText().toString();

                if(tarefaRecuperada!=null) { //Significa que está editando, atualizando

                    if (!nomeTarefa.isEmpty()) {//Diferente de vazio

                        ListaValores tarefa = new ListaValores();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaRecuperada.getId());

                        //atualizar banco de dado

                        if (tarefaDAO.atualizar(tarefa)){
                            Toast.makeText(getApplicationContext(),"Sucesso ao atualizar tarefa", Toast.LENGTH_LONG).show();
                            finish();
                        }

                        else{
                            Toast.makeText(getApplicationContext(),"Erro ao atualizar tarefa", Toast.LENGTH_LONG).show();

                        }

                    }
                }

                else{ //salvar

                    if(!nomeTarefa.isEmpty()){

                        ListaValores tarefa = new ListaValores();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if(tarefaDAO.salvar(tarefa)){//no tarefa dao este método retorna verdadeiro ou falso
                            Toast.makeText(getApplicationContext(),"Sucesso ao salvar tarefa", Toast.LENGTH_LONG).show();
                            System.out.println(tarefaDAO.listar().size());
                            finish();
                        }

                        else{
                            Toast.makeText(getApplicationContext(),"Erro ao salvar tarefa", Toast.LENGTH_LONG).show();
                        }

                    }
                }

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}