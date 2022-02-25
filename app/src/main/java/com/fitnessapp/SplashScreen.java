package com.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    private SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        sp = getSharedPreferences("UserPref", Context.MODE_PRIVATE);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reference = FirebaseDatabase.getInstance().getReference("Users");
            reference.child(currentUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    Intent intent = null;
                    if (snapshot.exists()) {

                        SharedPreferences.Editor editor = sp.edit();

                        editor.putString("user_id", currentUser.getUid());
                        editor.putString("username", snapshot.child("username").getValue().toString());
                        editor.putString("age", snapshot.child("age").getValue().toString());
                        editor.putString("rec", snapshot.child("recType").getValue().toString());
                        editor.putString("gender", snapshot.child("gender").getValue().toString());

                        editor.commit();

                        intent = new Intent(SplashScreen.this, MainActivity.class);

                    } else {
                        intent = new Intent(SplashScreen.this, SignIn.class);
                    }
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Intent intent = new Intent(SplashScreen.this, SignIn.class);
                    startActivity(intent);
                    finish();
                }
            });

        } else {
            new Handler().postDelayed(
                    () -> {
                        Intent intent = new Intent(SplashScreen.this, SignIn.class);
                        startActivity(intent);
                        finish();
                    }, 2000
            );
        }
    }

}
