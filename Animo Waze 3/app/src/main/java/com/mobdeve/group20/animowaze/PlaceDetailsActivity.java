package com.mobdeve.group20.animowaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobdeve.group20.animowaze.databinding.ActivityMapBinding;
import com.mobdeve.group20.animowaze.databinding.ActivityPlaceDetailsBinding;

public class PlaceDetailsActivity extends AppCompatActivity {
    private ActivityPlaceDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.reviewBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(PlaceDetailsActivity.this, ReviewActivity.class);
            startActivity(intent);
        });
        binding.bottomNavigationView.findViewById(R.id.map).setOnClickListener(view1 -> {
            Intent intent = new Intent(PlaceDetailsActivity.this, MapActivity.class);
            startActivity(intent);
        });
        binding.bottomNavigationView.findViewById(R.id.map).setOnClickListener(view1 -> {
            Intent intent = new Intent(PlaceDetailsActivity.this, MapActivity.class);
            startActivity(intent);
        });
        binding.bottomNavigationView.findViewById(R.id.search).setOnClickListener(view1 -> {
            Intent filterintent = new Intent(PlaceDetailsActivity.this, FilterActivity.class);
            startActivity(filterintent);
        });
    }
}