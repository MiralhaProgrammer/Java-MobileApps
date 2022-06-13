package com.guelzinhocurso.listatarefasfinal.BancoDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.guelzinhocurso.listatarefasfinal.RecyclerView.ListaValores;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements iTarefaDAO{

    private SQLiteDatabase escreve; //escreve/salva dados na tabela
    private SQLiteDatabase ler;


    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase(); //salvar
        ler = db.getReadableDatabase(); // ler os dados
    }

    @Override
    public boolean salvar(ListaValores listaValores) {

        ContentValues cv = new ContentValues();
        cv.put("nome", listaValores.getNomeTarefa());

        try{
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv); //vai inserir os nomes acima
            Log.i("AVISO", "Tarefa salva com sucesso!");
        }

        catch (Exception e){
        return false; // retorna falso indicando que tem um problema e erro ao salvar tarefa
        }
        return true;
    }

    @Override
    public boolean atualizar(ListaValores listaValores) {
        ContentValues cv = new ContentValues();
        cv.put("nome", listaValores.getNomeTarefa());

        try{
            String [] args = {listaValores.getId().toString()}; // Pega o id
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args); //o caractere ? coringa é substituido pelo array args
            //primeiro parametro, tabela, valores, cv, clausula where pra saber onde quer atualizar a tabela, entre outros
        }

        catch (Exception e){

            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(ListaValores listaValores) {

        try{
            String [] args = {listaValores.getId().toString()}; // Pega o id e converte para string porque ele é long
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?", args); //o caractere ? coringa é substituido pelo array args
            //Não precisa do content values pq vai deletar a linha toda
        }

        catch (Exception e){

            return false;
        }
        return true;
    }

    @Override
    public List<ListaValores> listar() {

        List<ListaValores> listaTarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;"; //seleciona da tabela tarefas todos os dados
        Cursor cursor = ler.rawQuery(sql, null);

        while (cursor.moveToNext()){
            ListaValores tarefa = new ListaValores();

            Long id  = cursor.getLong(cursor.getColumnIndex("id")); //vai pegar da coluna id
            String nomeTarefa = cursor.getString(cursor.getColumnIndex("nome")); // pegar nome da tarefa na coluna do id

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            listaTarefas.add(tarefa);
        }

        return listaTarefas;
    } //Classe que vai salvar os dados para o usuário


}
