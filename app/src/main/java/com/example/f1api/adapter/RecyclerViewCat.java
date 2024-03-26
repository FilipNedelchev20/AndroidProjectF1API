package com.example.f1api.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1api.R;
import com.example.f1api.db.AppDatabase;
import com.example.f1api.model.CatCharacteristic;

import java.util.List;

public class RecyclerViewCat extends RecyclerView.Adapter<ViewHolderCat> {
    private List<CatCharacteristic> catCharacteristicList;
    private AppDatabase appDatabase;

    @NonNull
    @Override
    public ViewHolderCat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_info_layout, parent, false);
        return new ViewHolderCat(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCat holder, int position) {
        CatCharacteristic catCharacteristic = catCharacteristicList.get(position);
        holder.txtBreed.setText(catCharacteristic.getBreed());
        holder.txtCountry.setText(catCharacteristic.getCountry());
        holder.txtOrigin.setText(catCharacteristic.getOrigin());
        holder.txtCoat.setText(catCharacteristic.getCoat());
        holder.txtPattern.setText(catCharacteristic.getPattern());
    }

    @Override
    public int getItemCount() {
        return catCharacteristicList.size();
    }
}
