package com.example.kidcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Startup extends AppCompatActivity {
    private  static int SPLASH_TIME = 4000;
    private FirebaseAuth mAuth;
    ImageView logo;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        logo = findViewById(R.id.logo);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        logo.setAnimation(slide_up);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        new Handler().postDelayed(
                (Runnable) () -> {
                    if (user == null) {
                        startActivity(new Intent(Startup.this, StartActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(Startup.this, MainActivity.class));
                        finish();
                    }
                },SPLASH_TIME
        );
    }
}
