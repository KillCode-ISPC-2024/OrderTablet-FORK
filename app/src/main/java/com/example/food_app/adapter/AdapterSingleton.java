package com.example.food_app.adapter;

public class AdapterSingleton {
    private static ListAdapter listAdapter;

    public static void init(ListAdapter adapter) {
        if (listAdapter == null) {
            listAdapter = adapter;
        }
    }

    public static ListAdapter getInstance() {
        if (listAdapter == null) {
            throw new IllegalStateException("ListAdapter not initialized. Call init() first.");
        }
        return listAdapter;
    }
}

