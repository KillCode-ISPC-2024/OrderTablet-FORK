package com.example.food_app.fragmentsMenu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.R;
import com.example.food_app.adapter.AdapterSingleton;
import com.example.food_app.adapter.ListAdapter;
import com.example.food_app.database.entity.comidaBebida;

import java.util.List;
import java.util.stream.Collectors;

public class fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private static final String TAG = "Fragment1";
    private int category;

    public fragment1() {
        Log.d(TAG, "fragment1 constructor called");
    }

    public static fragment1 newInstance(int category) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putInt("category", category);
        fragment.setArguments(args);
        Log.d(TAG, "newInstance created with category: " + category);
        return fragment;
    }

    // Método onAttach actualizado sin duplicación
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getInt("category");
            Log.d(TAG, "Category received in onCreate: " + category);
        } else {
            Log.d(TAG, "No arguments received in onCreate");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView called");
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        recyclerView = view.findViewById(R.id.recycler1);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Obtener la instancia compartida de ListAdapter
        ListAdapter listAdapter = AdapterSingleton.getInstance();

        // Filtra los datos según la categoría específica
        List<comidaBebida> filteredList = listAdapter.getData().stream()
                .filter(item -> item.getId_categoria() == category)
                .collect(Collectors.toList());

        // Logs para verificar los datos obtenidos del adaptador
        Log.d(TAG, "Número de elementos en la lista filtrada: " + filteredList.size());

        // Usa el método setItems del adaptador compartido para actualizar los datos
        listAdapter.setItems(filteredList);
        recyclerView.setAdapter(listAdapter);

        if (filteredList.size() > 0) {
            // Usa el método setItems del adaptador compartido para actualizar los datos
            listAdapter.setItems(filteredList);
            recyclerView.setAdapter(listAdapter);
            Log.d(TAG, "Lista filtrada para el adaptador: " + filteredList.size() + " elementos.");
        } else {
            Log.d(TAG, "Error: No hay elementos en el adaptador.");
        }

        // Logs para la lista filtrada
        Log.d(TAG, "Lista filtrada para el adaptador: " + filteredList.size() + " elementos.");

        if (listAdapter.getItemCount() > 0) {
            // Usa el método setItems del adaptador compartido para actualizar los datos
            listAdapter.setItems(filteredList);
            recyclerView.setAdapter(listAdapter);

            // Logs para la lista filtrada
            Log.d(TAG, "Lista filtrada para el adaptador: " + filteredList.size() + " elementos.");
        } else {
            Log.e(TAG, "Error: No hay elementos en el adaptador.");
        }

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach called");
    }
}

