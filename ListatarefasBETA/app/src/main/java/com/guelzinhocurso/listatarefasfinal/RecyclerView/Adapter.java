package com.guelzinhocurso.listatarefasfinal.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guelzinhocurso.listatarefasfinal.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<ListaValores>listaValores;

    public void setData (List<ListaValores> listaValores){
        this.listaValores = listaValores;
        notifyDataSetChanged();

    }

//    /*public Adapter(List<ListaValores> listaValores) {
//        this.listaValores = listaValores;
//    } */

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myviewHolderlist = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_valores, parent, false);
        return new MyViewHolder(myviewHolderlist);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ListaValores positionList = listaValores.get(position);
        holder.textTarefa.setText(positionList.getNomeTarefa());

    }

    @Override
    public int getItemCount() {
        return this.listaValores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textTarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textTarefa = itemView.findViewById(R.id.textViewtarefa);
        }
    }
}


