package com.example.cardapiopizzas.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cardapiopizzas.entity.Pizza;

import java.nio.channels.SelectableChannel;
import java.util.List;

@Dao
public interface PizzaDao {

    @Insert
    void saveFlavor(Pizza pizza);

    @Update
    void updateFlavor(Pizza pizza);

    @Delete
    void deleteFlavor(Pizza pizza);

    @Query("SELECT * FROM `pizzas.db`")
    List<Pizza> getMenu();

}
