package com.example.f1api.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1api.R;
import com.example.f1api.entity.Cat;

import java.util.List;

public class RecyclerViewCatCharacteristic extends RecyclerView.Adapter<ViewHolderCat> {
    private List<Cat> cats;

    public RecyclerViewCatCharacteristic(List<Cat> cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public ViewHolderCat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_info_layout, parent, false);
        return new ViewHolderCat(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCat holder, int position) {
        Cat cat = cats.get(position);
        holder.txtBreed.setText(cat.getBreed());
        holder.txtCountry.setText(cat.getCountry());
        holder.txtOrigin.setText(cat.getOrigin());
        holder.txtCoat.setText(cat.getCoat());
        holder.txtPattern.setText(cat.getPattern());
        holder.saveButton.setVisibility(View.INVISIBLE);
    }


    @Override
    public int getItemCount() {
        return cats.size();
    }
}
