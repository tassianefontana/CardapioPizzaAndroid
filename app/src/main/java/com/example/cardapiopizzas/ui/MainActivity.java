package com.example.cardapiopizzas.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.cardapiopizzas.R;
import com.example.cardapiopizzas.adapter.PizzaAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton fab;
    PizzaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvPizzas);
        fab = findViewById(R.id.fbSalvar);

        LinearLayoutManager layout =  new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        adapter = new PizzaAdapter(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);

        fab.setOnClickListener(view -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }

}