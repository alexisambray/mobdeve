package com.mobdeve.group20.animowaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobdeve.group20.animowaze.databinding.ActivityFilterBinding;
import com.mobdeve.group20.animowaze.databinding.ActivityReviewBinding;


public class ReviewActivity extends AppCompatActivity {
    private ActivityReviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReviewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.cancelReviewBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(ReviewActivity.this, PlaceDetailsActivity.class);
            startActivity(intent);
        });
        binding.submitReviewBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(ReviewActivity.this, PlaceDetailsActivity.class);
            startActivity(intent);
        });
    }
}