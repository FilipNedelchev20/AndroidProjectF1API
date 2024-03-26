package com.example.f1api.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.f1api.entity.Cat;

import java.util.List;

@Dao
public interface CatDao {
    @Insert
    void insertCat(Cat cat);
    @Query(value = "SELECT * FROM cat;")
    List<Cat> findAllCats();
}
