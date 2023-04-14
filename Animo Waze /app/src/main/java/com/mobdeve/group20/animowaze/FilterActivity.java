package com.mobdeve.group20.animowaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobdeve.group20.animowaze.databinding.ActivityFilterBinding;
import com.mobdeve.group20.animowaze.databinding.ActivityMainBinding;

public class FilterActivity extends AppCompatActivity {
    ActivityFilterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.bottomNavigationView.setSelectedItemId(R.id.search);
        binding.bottomNavigationView.findViewById(R.id.map).setOnClickListener(view1 -> {
            Intent intent = new Intent(FilterActivity.this, MapActivity.class);
            startActivity(intent);
        });
    }
}