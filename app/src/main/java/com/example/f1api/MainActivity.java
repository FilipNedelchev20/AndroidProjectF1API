package com.example.f1api;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.f1api.adapter.RecyclerViewCat;
import com.example.f1api.db.AppDatabase;
import com.example.f1api.model.CatCharacteristic;
import com.example.f1api.model.CatResponse;
import com.example.f1api.web.CatApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<CatCharacteristic> catCharacteristicList = new ArrayList<>();
    public static AppDatabase appDatabase;
    int page = 1;


    private void setAdapter(List<CatCharacteristic> catCharacteristicList) {
        RecyclerViewCat recyclerViewCat = new RecyclerViewCat(catCharacteristicList, appDatabase);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewCat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "cats_new")
                .allowMainThreadQueries()
                .build();


        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrev = findViewById(R.id.btnPrev);

        Button btnShowInfo = findViewById(R.id.InfoButton);
        Intent goToHomeActivity = new Intent(this, HomeActivity.class);
        btnShowInfo.setOnClickListener(v -> {
            startActivity(goToHomeActivity);
        });

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://catfact.ninja/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CatApiClient catApiClient = retrofit.create(CatApiClient.class);

        SharedPreferences sharedPreferences = getSharedPreferences("FirstDB", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int currPage = sharedPreferences.getInt("currentPage", 1);
        System.out.println("Current page " + currPage);
        page = currPage;
        loadCats(catApiClient, editor);
        btnNext.setOnClickListener(v -> {
            if (page ==4){
                return;
            }
            page++;
            loadCats(catApiClient, editor);
        });

        btnPrev.setOnClickListener(v -> {
            if (page == 1) {
                return;
            }
            page--;
            loadCats(catApiClient, editor);
        });
    }

    private void loadCats(CatApiClient starWarsApiClient, SharedPreferences.Editor editor) {
        Call<CatResponse> call = starWarsApiClient.getCatsPaged(page);
        call.enqueue(new Callback<CatResponse>() {
            @Override
            public void onResponse(Call<CatResponse> call, Response<CatResponse> response) {
                if (response.isSuccessful()) {
                    CatResponse swResponse = response.body();
                    editor.putInt("currentPage", page);
                    editor.apply();
                    if (swResponse != null) {
                        Log.e(TAG, swResponse.getCount() + "");
                        setAdapter(swResponse.getResults());
                        Log.d(TAG, "Response: " + swResponse.getCount());
                    } else {
                        Log.e(TAG, "Response is null");
                    }
                } else {
                    Log.e(TAG, "Failed to get cat facts: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CatResponse> call, Throwable t) {
                Log.e(TAG, "Error getting cat response: " + t.getMessage());
            }
        });
    }






}





