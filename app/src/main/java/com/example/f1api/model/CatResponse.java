package com.example.f1api.model;

import com.example.f1api.entity.Cat;

import java.util.List;

public class CatResponse {
    private int count;
    private List<CatCharacteristic> results;

    public CatResponse(int count, List<CatCharacteristic> results) {
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CatCharacteristic> getResults() {
        return results;
    }

    public void setResults(List<CatCharacteristic> results) {
        this.results = results;
    }
}
