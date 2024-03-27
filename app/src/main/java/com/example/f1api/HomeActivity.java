package com.example.f1api;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1api.adapter.RecyclerViewCatCharacteristic;
import com.example.f1api.dao.CatDao;
import com.example.f1api.entity.Cat;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  void setAdapter(List<Cat> catList){
        RecyclerViewCatCharacteristic recyclerViewCatCharacteristic = new RecyclerViewCatCharacteristic(catList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewCatCharacteristic);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         recyclerView = findViewById(R.id.recyclerViewHome);
        Button btnBack = findViewById(R.id.btnBack);

        Intent goBack = new Intent(this, MainActivity.class);

        btnBack.setOnClickListener(v -> {
            startActivity(goBack);
        });

        CatDao catDao = MainActivity.appDatabase.catDao();
        List<Cat> cats = catDao.findAllCats();
        setAdapter(cats);
    }

}
