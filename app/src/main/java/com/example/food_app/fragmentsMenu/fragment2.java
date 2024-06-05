package com.example.food_app.fragmentsMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.R;
import com.example.food_app.adapter.AdapterSingleton;
import com.example.food_app.adapter.ListAdapter;
import com.example.food_app.database.entity.comidaBebida;

import java.util.List;
import java.util.stream.Collectors;

public class fragment2 extends Fragment {
    private RecyclerView recyclerView;
    private static final String TAG = "Fragment1";
    private int category;

    public static fragment2 newInstance(int category) {
        fragment2 fragment = new fragment2();
        Bundle args = new Bundle();
        args.putInt("category", category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getInt("category");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        recyclerView = view.findViewById(R.id.recycler2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Obtener la instancia compartida de ListAdapter
        ListAdapter listAdapter = AdapterSingleton.getInstance();

        // Filtra los datos según la categoría específica
        List<comidaBebida> filteredList = listAdapter.getData().stream()
                .filter(item -> item.getId_categoria() == category)
                .collect(Collectors.toList());

        // Usa el método setItems del adaptador compartido para actualizar los datos
        listAdapter.setItems(filteredList);
        recyclerView.setAdapter(listAdapter);

        // Logs para la lista filtrada
        Log.d(TAG, "Lista filtrada para el adaptador: " + filteredList.size() + " elementos.");

        return view;
    }
}
