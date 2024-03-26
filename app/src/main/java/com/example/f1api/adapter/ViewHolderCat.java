package com.example.f1api.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1api.R;

public class ViewHolderCat extends RecyclerView.ViewHolder {
    public TextView txtBreed;
    public TextView txtCountry;
    public TextView txtOrigin;
    public TextView txtCoat;
    public TextView txtPattern;
    public ViewHolderCat(@NonNull View itemView) {
        super(itemView);
        txtBreed = itemView.findViewById(R.id.txtBreed);
        txtCountry = itemView.findViewById(R.id.txtCountry);
        txtOrigin = itemView.findViewById(R.id.txtOrigin);
        txtCoat = itemView.findViewById(R.id.txtCoat);
        txtPattern = itemView.findViewById(R.id.txtPattern);
    }

    public TextView getTxtBreed() {
        return txtBreed;
    }

    public void setTxtBreed(TextView txtBreed) {
        this.txtBreed = txtBreed;
    }

    public TextView getTxtCountry() {
        return txtCountry;
    }

    public void setTxtCountry(TextView txtCountry) {
        this.txtCountry = txtCountry;
    }

    public TextView getTxtOrigin() {
        return txtOrigin;
    }

    public void setTxtOrigin(TextView txtOrigin) {
        this.txtOrigin = txtOrigin;
    }

    public TextView getTxtCoat() {
        return txtCoat;
    }

    public void setTxtCoat(TextView txtCoat) {
        this.txtCoat = txtCoat;
    }

    public TextView getTxtPattern() {
        return txtPattern;
    }

    public void setTxtPattern(TextView txtPattern) {
        this.txtPattern = txtPattern;
    }


}
