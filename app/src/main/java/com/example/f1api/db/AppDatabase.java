package com.example.f1api.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.f1api.dao.CatDao;
import com.example.f1api.entity.Cat;

@Database(entities = {Cat.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract CatDao catDao();
}
