package com.example.cardapiopizzas.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cardapiopizzas.database.dao.PizzaDao;
import com.example.cardapiopizzas.entity.Pizza;

@Database(entities = {Pizza.class}, version = 1, exportSchema = false)
public abstract class PizzasDB extends RoomDatabase {
    private static final String DB_NAME= "pizzas.db";
    public abstract PizzaDao getPizzaDao();
    private static PizzasDB instance;

    public static PizzasDB getInstance(Context context){
        return (instance == null) ?
                Room.databaseBuilder(context, PizzasDB.class, DB_NAME).allowMainThreadQueries().build() :
                instance;
    }


}
