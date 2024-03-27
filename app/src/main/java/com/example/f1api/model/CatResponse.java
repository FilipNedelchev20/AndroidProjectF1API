package com.example.f1api.model;

import java.util.List;

public class CatResponse {
    private int count;
    private List<CatCharacteristic> data;

    public CatResponse(int count, List<CatCharacteristic> data) {
        this.count = count;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CatCharacteristic> getResults() {
        return data;
    }

    public void setResults(List<CatCharacteristic> results) {
        this.data = data;
    }
}
