
package com.mobdeve.group20.animowaze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.mobdeve.group20.animowaze.databinding.ActivityPlaceDetailsBinding;

import java.util.Objects;

public class PlaceDetailsActivity extends AppCompatActivity {
    private ActivityPlaceDetailsBinding binding;
    //private final FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent2 = getIntent();
        //String placeName = intent2.getStringExtra("PLACE_NAME");

        /*for(int i = 1; i <= 4; i++){
            DocumentReference docRef = db.collection(MyFirestoreReferences.PLACES_COLLECTION).document("placedocu" + i);
            Task<DocumentSnapshot> documentSnapshotTask = docRef.get();
            String name = Objects.requireNonNull(documentSnapshotTask.getResult().get(MyFirestoreReferences.PLACE_NAME_FIELD)).toString();
            if(Objects.equals(name, placeName)){
                String type = (String) documentSnapshotTask.getResult().get(MyFirestoreReferences.PLACE_TYPE_FIELD);
                String rating = (String) documentSnapshotTask.getResult().get(MyFirestoreReferences.PLACE_RATING_FIELD);
                String features = (String) documentSnapshotTask.getResult().get(MyFirestoreReferences.PLACE_FEATURES_FIELD);
                binding.placenameTv.setText(name);
                binding.placetypeTv.setText(type);
                binding.ratingTv.setText(rating);
                binding.featuresTv.setText(features);
                break;
            }
        }
        CollectionReference placesRef = db.collection(MyFirestoreReferences.PLACES_COLLECTION);
        Query query = placesRef.whereEqualTo(
                MyFirestoreReferences.PLACE_NAME_FIELD,
                placeName);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful())
                    task.getResult().getDocuments().

                    else
                        moveToChatRoomActivity(username);
                else
                    Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });



*/
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