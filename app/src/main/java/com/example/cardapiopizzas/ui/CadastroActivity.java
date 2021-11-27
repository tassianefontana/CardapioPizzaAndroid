package com.example.cardapiopizzas.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cardapiopizzas.R;
import com.example.cardapiopizzas.database.PizzasDB;
import com.example.cardapiopizzas.database.dao.PizzaDao;
import com.example.cardapiopizzas.entity.Pizza;

public class CadastroActivity extends AppCompatActivity {

    private EditText etSabor;
    private EditText etDescricao;
    private EditText etPreco;
    private Button btnSalvar;
    private PizzaDao pizzaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etSabor = findViewById(R.id.etSabor);
        etDescricao = findViewById(R.id.etDescricao);
        etPreco = findViewById(R.id.etpreco);
        btnSalvar = findViewById(R.id.btnSalvar);

        pizzaDao = PizzasDB.getInstance(this).getPizzaDao();

        Intent intent = getIntent();
        Pizza edtPizza;

        if (intent.hasExtra("pizza"))
        {
            edtPizza = (Pizza) intent.getSerializableExtra("pizza");
            etSabor.setText(edtPizza.getSabor());
            etDescricao.setText(edtPizza.getDescricao());
            etPreco.setText(edtPizza.getPreco() + "");
        }
        else
        {
            edtPizza = null;
        }

        btnSalvar.setOnClickListener(view -> {

            if (etSabor.getText().toString().isEmpty() | etDescricao.getText().toString().isEmpty() | etPreco.getText().toString().isEmpty()){
                Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_LONG).show();
            } else {
                Pizza pizza = new Pizza(0, etSabor.getText().toString(), etDescricao.getText().toString(), Double.parseDouble(etPreco.getText().toString()));

                if (edtPizza == null) {
                    pizzaDao.saveFlavor(pizza);
                    Toast.makeText(this, "Sabor adicionado com sucesso", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    pizza.setId(edtPizza.getId());
                    pizzaDao.updateFlavor(pizza);
                    Toast.makeText(this, "Sabor editado com sucesso", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }
}