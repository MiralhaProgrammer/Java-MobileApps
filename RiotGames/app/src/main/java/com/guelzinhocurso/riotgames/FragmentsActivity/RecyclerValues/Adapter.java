package com.guelzinhocurso.riotgames.FragmentsActivity.RecyclerValues;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guelzinhocurso.riotgames.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<ValuesList>originalList;

    public Adapter(List<ValuesList> originalList) {
        this.originalList = originalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myviewholderList = LayoutInflater.from(parent.getContext()).inflate(R.layout.values_list, parent, false);
        return new MyViewHolder(myviewholderList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ValuesList positionList = originalList.get(position);
        holder.textValues.setText(positionList.getText());
        holder.titleValues.setText(positionList.getTitle());
        holder.imageValues.setImageResource(positionList.getImage());


    }

    @Override
    public int getItemCount() {
        return originalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textValues, titleValues;
        private ImageView imageValues;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textValues = itemView.findViewById(R.id.textValues);
            titleValues = itemView.findViewById(R.id.titleValues);
            imageValues = itemView.findViewById(R.id.imageValues);
        }
    }
}
