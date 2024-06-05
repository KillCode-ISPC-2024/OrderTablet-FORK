package com.example.food_app.menu;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.food_app.R;
import com.example.food_app.adapter.VPAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MenuScroll extends AppCompatActivity {

    private static final String TAG = "MenuScroll";
    private ViewPager2 viewPager2;
    private VPAdapter vpAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_scroll);

        // Inicializar ViewPager2 y TabLayout
        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        // Inicializar VPAdapter
        vpAdapter = new VPAdapter(this);

        // Configurar ViewPager2 con el adaptador
        viewPager2.setAdapter(vpAdapter);

        // Configurar TabLayoutMediator para establecer los títulos de las pestañas
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Entradas");
                    break;
                case 1:
                    tab.setText("Principal");
                    break;
                case 2:
                    tab.setText("Postres");
                    break;
                case 3:
                    tab.setText("Bebidas");
                    break;
                default:
                    tab.setText("Tab " + (position + 1));
                    break;
            }
        }).attach();

        Log.d(TAG, "MenuScroll created and ViewPager2 set up with TabLayout");
    }
}
