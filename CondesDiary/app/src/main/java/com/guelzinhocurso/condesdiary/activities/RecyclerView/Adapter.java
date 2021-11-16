package com.guelzinhocurso.condesdiary.activities.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guelzinhocurso.condesdiary.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<ValuesList>valuesList;

    public void setData(List<ValuesList>valuesList){ //setData
        this.valuesList = valuesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myviewHolderlist = LayoutInflater.from(parent.getContext()).inflate(R.layout.values_list, parent, false);

        return new MyViewHolder(myviewHolderlist);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ValuesList valuesPosition = valuesList.get(position);
        holder.textLayout.setText(valuesPosition.getTitle()); //O adaptador vai settar o titulo de acordo com oq pegar
        holder.dateLayout.setText(valuesPosition.getDate());
        holder.rateLayout.setText(valuesPosition.getRate());
        holder.dateLayoutm.setText(valuesPosition.getDatem());
        holder.dateLayouty.setText(valuesPosition.getDatey());

    }

    @Override
    public int getItemCount() {
        return this.valuesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textLayout, dateLayout, rateLayout, dateLayoutm, dateLayouty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textLayout = itemView.findViewById(R.id.textLayout);
            dateLayout = itemView.findViewById(R.id.dateLayout);
            rateLayout = itemView.findViewById(R.id.rateLayout);
            dateLayoutm = itemView.findViewById(R.id.dateLayoutM);
            dateLayouty = itemView.findViewById(R.id.dateLayoutY);

        }
    }
}





