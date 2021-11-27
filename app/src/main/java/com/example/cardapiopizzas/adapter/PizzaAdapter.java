package com.example.cardapiopizzas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardapiopizzas.R;
import com.example.cardapiopizzas.database.PizzasDB;
import com.example.cardapiopizzas.database.dao.PizzaDao;
import com.example.cardapiopizzas.entity.Pizza;
import com.example.cardapiopizzas.ui.DetalhesActivity;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Pizza> listaPizza;
    private PizzaDao pizzaDao;

    public PizzaAdapter(Context context) {
        this.context = context;
        pizzaDao = PizzasDB.getInstance(context).getPizzaDao();
        listaPizza = pizzaDao.getMenu();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.pizza_layout, parent, false);

        PizzaViewHolder pizzaVH = new PizzaViewHolder(itemView);

        return pizzaVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pizza pizza = listaPizza.get(position);
        PizzaViewHolder pizzaViewHolder = (PizzaViewHolder) holder;
        pizzaViewHolder.tvSabor.setText(pizza.getSabor());
        pizzaViewHolder.tvPreco.setText("R$ " + pizza.getPreco());

        pizzaViewHolder.btnDetalhes.setOnClickListener(view -> {
            Intent detailsIntent = new Intent(context, DetalhesActivity.class);
            detailsIntent.putExtra("pizza", pizza);
            context.startActivity(detailsIntent);

        });

    }

    @Override
    public int getItemCount() {
        return listaPizza.size();
    }

    public void updateDataSet(){
        listaPizza.clear();
        listaPizza = pizzaDao.getMenu();
       notifyDataSetChanged();
    }
}
