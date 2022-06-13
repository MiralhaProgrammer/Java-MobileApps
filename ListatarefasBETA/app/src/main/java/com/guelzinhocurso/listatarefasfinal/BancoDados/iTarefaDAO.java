package com.guelzinhocurso.listatarefasfinal.BancoDados;

import com.guelzinhocurso.listatarefasfinal.RecyclerView.ListaValores;

import java.util.List;

public interface iTarefaDAO {

    public boolean salvar(ListaValores listaValores);
    public boolean atualizar(ListaValores listaValores);
    public boolean deletar (ListaValores listaValores);
    public List<ListaValores>listar();
}
