package com.example.cardapiopizzas.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "pizzas.db")
public class Pizza implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String sabor;
    private String descricao;
    private Double preco;

    public Pizza() { }

    @Ignore
    public Pizza(int id, String sabor, String descricao, Double preco) {
        this.id = id;
        this.sabor = sabor;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return sabor + '\'';
    }
}
