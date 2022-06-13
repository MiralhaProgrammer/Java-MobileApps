package com.guelzinhocurso.listatarefasfinal.BancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1; //Para a própria classe saber qual método usar, oncreate ou upgrade, mudar quando atualizar o app
    public static String NOME_DB = "DB_TAREFAS"; // Nome do banco de dados
    public static String TABELA_TAREFAS = "TABELA_TAREFAS"; //Se quiser mudar nome da tabela depois fica mais facil

    public DbHelper(@Nullable Context context) {


        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Criar primeira vez banco de dados, quando usuário instala

        String sql = "CREATE TABLE IF NOT EXISTS TABELA_TAREFAS" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);"; // NOME DA TAREFA NÃO PODE SER NULO

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar tabela");
        }

        catch (Exception e){
            Log.i("Info DB", "Erro ao criar tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //Lançar outra versão do app,
        // criando mais tabela, arrumar a versão que já existe, etc.

        /* String sql = "DROP TABLE IF EXISTS" + TABELA_TAREFAS + " ;"; //Deletar tabela

        String sql = "ALTER TABLE" + TABELA_TAREFAS + "ADD COLUMN status VARCHAR(1)"; //Alterar tabela adicionando coluna COM 1 CARACTERE

        try {
            db.execSQL(sql);
            onCreate(db); //Deletando a tabela e puxando oncreate para criar dnv
            Log.i("INFO DB", "Sucesso ao atualizar tabela");
        }

        catch (Exception e){
            Log.i("Info DB", "Erro ao atualizar tabela" + e.getMessage());
        } */

    }
}
