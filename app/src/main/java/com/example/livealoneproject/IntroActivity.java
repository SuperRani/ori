package com.example.livealoneproject;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        context = this;
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
                finish();

            }
        };
        handler.postDelayed(r, 3000);

        LottieAnimationView lottie = (LottieAnimationView) findViewById(R.id.lottie);
        lottie.setAnimation("home.json");

        lottie.playAnimation();
//        lottie.loop(true);
    }
}
