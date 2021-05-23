package com.example.kidcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;

import java.util.Timer;
import java.util.TimerTask;

public class Intermediate extends AppCompatActivity implements OnProgressBarListener{
    private Timer timer;
    Button check;
    TextView tv;
    TextView tv2;
    private NumberProgressBar bnp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);
        check = findViewById(R.id.check);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textview2);
        tv2.setVisibility(View.INVISIBLE);
        check.setVisibility(View.INVISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.INFINITE);
        tv.startAnimation(alphaAnimation);


        bnp = (NumberProgressBar)findViewById(R.id.number_progress_bar);
        bnp.setOnProgressBarListener((OnProgressBarListener) Intermediate.this);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bnp.incrementProgressBy(1);
                    }
                });
            }
        }, 1000, 100);
    }
    @Override
    public void onProgressChange(int current, int max) {
        if(current == max) {

             tv2.setVisibility(View.VISIBLE);
            check.setVisibility(View.VISIBLE);
            tv.setVisibility(View.INVISIBLE);

            check.setOnClickListener(v -> startActivity(new Intent(Intermediate.this,MainActivity.class)));
        }
    }
}