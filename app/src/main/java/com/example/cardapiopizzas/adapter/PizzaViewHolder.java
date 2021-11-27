package com.example.cardapiopizzas.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardapiopizzas.R;

public class PizzaViewHolder extends RecyclerView.ViewHolder {
    TextView tvId;
    TextView tvSabor;
    TextView tvDescricao;
    TextView tvPreco;
    Button btnDetalhes;


    public PizzaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSabor = itemView.findViewById(R.id.tvSabor);
        tvDescricao = itemView.findViewById(R.id.etDescricao);
        tvPreco =  itemView.findViewById(R.id.tvPreco);
        btnDetalhes = itemView.findViewById(R.id.btnDetalhes);

    }
}
