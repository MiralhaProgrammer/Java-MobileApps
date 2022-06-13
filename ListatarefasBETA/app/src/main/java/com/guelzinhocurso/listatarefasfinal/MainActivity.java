package com.guelzinhocurso.listatarefasfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.guelzinhocurso.listatarefasfinal.BancoDados.DbHelper;
import com.guelzinhocurso.listatarefasfinal.BancoDados.TarefaDAO;
import com.guelzinhocurso.listatarefasfinal.RecyclerView.Adapter;
import com.guelzinhocurso.listatarefasfinal.RecyclerView.ListaValores;
import com.guelzinhocurso.listatarefasfinal.RecyclerView.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private List<ListaValores>listaValores = new ArrayList<>();
    private Adapter adapter;
    private ListaValores tarefaSelecionada;


    @Override
    protected void onStart() {
        super.onStart();
        this.carregarLista();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recyclerView);
        getSupportActionBar().hide();
        getSupportActionBar().setElevation(0);

        adapter = new Adapter();
        adapter.setData(listaValores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        // Linha Divisória Vertical
        recyclerView.setAdapter(adapter);

        //Banco de dados
        ContentValues cv = new ContentValues(); //definir itens como se fosse arrays
        cv.put("nome", "Teste"); //colocar dentro da tabela tarefas estes valores na coluna nome

        DbHelper db = new DbHelper(getApplicationContext());
        db.getWritableDatabase().insert("TABELA_TAREFAS", null, cv ); //Salvar os dados

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) { //Click curto, para editar
                    //Recuperar tarefa para edição
                        ListaValores tarefaSelecionada = listaValores.get(position); //recupera a tarefa selecionada

                        //Envia tarefa para tela adicionar tarefa
                        Intent intent = new  Intent(MainActivity.this, AdicionarTarefaActivity.class);
                        intent.putExtra("tarefaSelecionada", tarefaSelecionada);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) { //Click longo, deletar

                        tarefaSelecionada = listaValores.get(position); //Vai pegar a posição da lista

                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        //Configura titulo e mensagem
                        alert.setTitle("Confirmar exclusão");
                        alert.setMessage("Deseja excluir a tarefa: " + tarefaSelecionada.getNomeTarefa() + "?");
                        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {// Ao clicar sim
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                if (tarefaDAO.deletar(tarefaSelecionada)){
                                    carregarLista();
                                    Toast.makeText(getApplicationContext(), "Sucesso ao deletar tarefa", Toast.LENGTH_LONG).show();
                                }

                                else {
                                    Toast.makeText(getApplicationContext(), "Erro ao deletar tarefa", Toast.LENGTH_LONG).show();
                                }

                            }
                        });

                        alert.setNegativeButton("Não", null);// Não terá evento

                        alert.create();
                        alert.show();


                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
                )
        );


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);

            }
        });


    }


    public void carregarLista (){

        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaValores = tarefaDAO.listar();
        adapter.setData(listaValores);

        }

}