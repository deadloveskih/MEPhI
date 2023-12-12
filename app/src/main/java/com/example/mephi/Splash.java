package com.example.mephi;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView imgLogo, txtLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.splash);

        imgLogo = findViewById(R.id.image_logo);
        txtLogo = findViewById(R.id.text_logo);

        imgLogo.setAnimation(topAnim);
        txtLogo.setAnimation(topAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}