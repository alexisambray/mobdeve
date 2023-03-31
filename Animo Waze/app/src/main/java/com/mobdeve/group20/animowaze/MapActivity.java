package com.mobdeve.group20.animowaze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.mobdeve.group20.animowaze.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {
    ActivityMapBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME_KEY);
        String email = intent.getStringExtra(MainActivity.EMAIL_KEY);

        Toast.makeText(getApplicationContext(), "Email: " + email + "\nUsername: " + username, Toast.LENGTH_LONG).show();
        binding.bottomNavigationView.setSelectedItemId(R.id.map);
        binding.bottomNavigationView.findViewById(R.id.search).setOnClickListener(view1 -> {
            Intent filterintent = new Intent(MapActivity.this, FilterActivity.class);
            startActivity(filterintent);

        });
        binding.mapBtn.setOnClickListener(view1 -> {
            Intent intent1 = new Intent(MapActivity.this, PlaceDetailsActivity.class);
            startActivity(intent1);
        });
    }
}