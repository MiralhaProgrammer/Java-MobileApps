package com.guelzinhocurso.condesdiary.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.guelzinhocurso.condesdiary.R;
import com.guelzinhocurso.condesdiary.activities.DataBase.Dao;
import com.guelzinhocurso.condesdiary.activities.DataBase.DbHelper;
import com.guelzinhocurso.condesdiary.activities.RecyclerView.Adapter;
import com.guelzinhocurso.condesdiary.activities.RecyclerView.RecyclerItemClickListener;
import com.guelzinhocurso.condesdiary.activities.RecyclerView.ValuesList;

import java.util.ArrayList;
import java.util.List;

public class AllNoteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ValuesList>valuesList = new ArrayList<>();
    private Adapter adapter;
    private ValuesList itemSelect;

    @Override
    protected void onStart() {
        super.onStart();
        this.loadList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_note);
        getSupportActionBar().setTitle("Todas as anotações");

        //RecyclerView & Adapter
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter();
        adapter.setData(valuesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //DataBase
        ContentValues cv = new ContentValues();
        DbHelper db = new DbHelper(getApplicationContext());
        db.getWritableDatabase().insert("TABLE_NAMES", null, cv);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) { //Click curto, edit

                ValuesList taskSelected = valuesList.get(position); //Pega a posição com os dados
                Intent intent = new Intent(AllNoteActivity.this, NewNoteActivity.class);
                intent.putExtra("taskSelected", taskSelected);
                startActivity(intent); // starta a activity com os dados
                finish();

            }

            @Override
            public void onLongItemClick(View view, int position) { //Click Longo, delete

                itemSelect = valuesList.get(position);
                //alertDialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AllNoteActivity.this);
                alertDialog.setTitle("Excluir");
                alertDialog.setMessage("Deseja excluir a anotação: " + itemSelect.getTitle()+ "?");
                alertDialog.setIcon(R.drawable.ic_delete);
                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dao dao = new Dao(getApplicationContext());
                        if (dao.delete(itemSelect)){
                            loadList();
                            Toast.makeText(getApplicationContext(), "Anotação deletada", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Erro ao deletar anotação", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialog.setNegativeButton("Não", null);
                alertDialog.create();
                alertDialog.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_allnote, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

        case R.id.addItem:
            Toast.makeText(getApplicationContext(), "Adicionar Anotação", Toast.LENGTH_LONG).show();
            Intent openNewnote = new Intent(getApplicationContext(), NewNoteActivity.class);
            startActivity(openNewnote);

            break;

            case R.id.backItem:
                Toast.makeText(getApplicationContext(), "Voltar", Toast.LENGTH_LONG).show();
                finish();

        }

        return super.onOptionsItemSelected(item);
    }

    public void loadList(){
        Dao dao = new Dao(getApplicationContext());
        valuesList = dao.list();
        adapter.setData(valuesList);
    }



}