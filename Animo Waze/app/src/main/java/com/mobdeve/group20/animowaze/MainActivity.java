package com.mobdeve.group20.animowaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.mobdeve.group20.animowaze.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private SignInClient oneTapClient;
    private BeginSignInRequest signUpRequest;

    public static final String USERNAME_KEY = "USERNAME_KEY";
    public static final String EMAIL_KEY = "EMAIL_KEY";
    public static final String PASSWORD_KEY = "PASSWORD_KEY";

    private ActivityMainBinding binding;

   private ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartIntentSenderForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        try {
                            SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(result.getData());
                            String idToken = credential.getGoogleIdToken();

                            if (idToken !=  null) {
                                String email, username, password;
                                boolean dlsuemail;
                                email = credential.getId();
                                username = credential.getDisplayName();

                                dlsuemail = email.contains("dlsu.edu.ph");

                                if(dlsuemail && (email != null && username != null)){
                                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                                    intent.putExtra(USERNAME_KEY, username);
                                    intent.putExtra(EMAIL_KEY, email);
                                    startActivity(intent);
                                    finish();
                                }

                                else{
                                    Toast.makeText(getApplicationContext(), "Please use a dlsu email to login.", Toast.LENGTH_LONG).show();
                                }

                            }
                        } catch (ApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        oneTapClient = Identity.getSignInClient(this);
        signUpRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(getString(R.string.web_client_id))
                        // Show all accounts on the device.
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();


        // Redirects user to google signin
        binding.googleBtn.setOnClickListener(view1 -> {
            oneTapClient.beginSignIn(signUpRequest)
                    .addOnSuccessListener(this, new OnSuccessListener<BeginSignInResult>() {
                        @Override
                        public void onSuccess(BeginSignInResult result) {
                            IntentSenderRequest intentSenderRequest =
                                    new IntentSenderRequest.Builder(result.getPendingIntent().getIntentSender()).build();
                            activityResultLauncher.launch(intentSenderRequest);
                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // No Google Accounts found. Just continue presenting the signed-out UI.
                            Log.d("TAG", e.getLocalizedMessage());
                        }
                    });
        });
        // User login using credentials (username, password)
        binding.loginButton.setOnClickListener(view1 -> {
            if(binding.username.getText().toString().equals("user") && binding.password.getText().toString().equals("1234")){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        });



    }

    void navigateToMapActivity(){
        finish();
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "OnStart executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MAIN_ACTIVITY", "OnResume executed");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAIN_ACTIVITY", "OnPause executed");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN_ACTIVITY", "OnStop executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN_ACTIVITY", "OnDestroy executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN_ACTIVITY", "OnRestart executed");
    }
}
