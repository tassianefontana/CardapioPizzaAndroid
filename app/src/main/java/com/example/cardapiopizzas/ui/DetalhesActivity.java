package com.example.cardapiopizzas.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardapiopizzas.R;
import com.example.cardapiopizzas.database.PizzasDB;
import com.example.cardapiopizzas.database.dao.PizzaDao;
import com.example.cardapiopizzas.entity.Pizza;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvSabor;
    TextView tvDescricao;
    TextView tvpreco;
    Button btnEditar;
    Button btnDeletar;
    PizzaDao dao;
    Context context;

//    public DetalhesActivity(Context context) {
//        this.context = context;
//        dao = PizzasDB.getInstance(context).getPizzaDao();
//    }
//
//    public DetalhesActivity() {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvSabor = findViewById(R.id.tvTitulo);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvpreco = findViewById(R.id.tvPrice);
        btnEditar = findViewById(R.id.btnEdt);
        btnDeletar = findViewById(R.id.btnDelete);
        context = this;
        dao = PizzasDB.getInstance(context).getPizzaDao();

        Intent intent = getIntent();

        Pizza pizza;

        pizza = (Pizza) intent.getSerializableExtra("pizza");
        tvSabor.setText(pizza.getSabor());
        tvDescricao.setText(pizza.getDescricao());
        tvpreco.setText("R$ " + pizza.getPreco());


        btnDeletar.setOnClickListener(view -> {
            dao.deleteFlavor(pizza);
            finish();

        });

        btnEditar.setOnClickListener(view -> {
                    Intent editarIntent = new Intent(context, CadastroActivity.class);
                    editarIntent.putExtra("pizza", pizza);
                    context.startActivity(editarIntent);
                }
        );
    }
}
