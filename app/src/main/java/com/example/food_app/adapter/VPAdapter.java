package com.example.food_app.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.food_app.fragmentsMenu.fragment1;
import com.example.food_app.fragmentsMenu.fragment2;
import com.example.food_app.fragmentsMenu.fragment3;
import com.example.food_app.fragmentsMenu.fragment4;

public class VPAdapter extends FragmentStateAdapter {

    private static final String TAG = "VPAdapter";

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(TAG, "VPAdapter initialized");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = fragment1.newInstance(5);
                Log.d(TAG, "Fragment 1 created with category 5");
                break;
            case 1:
                fragment = fragment2.newInstance(6);
                Log.d(TAG, "Fragment 1 created with category 6");
                break;
            case 2:
                fragment = fragment3.newInstance(11);
                Log.d(TAG, "Fragment 1 created with category 11");
                break;
            case 3:
                fragment = fragment4.newInstance(12);
                Log.d(TAG, "Fragment 1 created with category 12");
                break;
            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
        Log.d(TAG, "createFragment called for position: " + position);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4; // Número de fragmentos
    }
}
