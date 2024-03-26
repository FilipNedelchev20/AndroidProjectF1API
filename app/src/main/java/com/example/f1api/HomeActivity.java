package com.example.f1api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1api.adapter.RecyclerViewCatCharacteristic;
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

}
