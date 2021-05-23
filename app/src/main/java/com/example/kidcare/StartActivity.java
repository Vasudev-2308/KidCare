package com.example.kidcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.animation.ObjectAnimator;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    Button login, register;
    TextView kidscare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        kidscare = findViewById(R.id.kidcare);
        login.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        register.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        login.startAnimation(slide_up);
        register.startAnimation(slide_up);
        Typeface tf = ResourcesCompat.getFont(
                this,
                R.font.gothambold);
        kidscare.setTypeface(tf);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}