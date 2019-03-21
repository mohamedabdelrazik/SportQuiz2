package com.example.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity {

    ImageView splash ;
    RelativeLayout activity_splash;
    Animation translat , fade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash = findViewById(R.id.splash);
        activity_splash = findViewById(R.id.activity_splash);

        fade = AnimationUtils.loadAnimation(this,R.anim.alpha);
        activity_splash.clearAnimation();
        activity_splash.startAnimation(fade);


        translat = AnimationUtils.loadAnimation(this,R.anim.together_animation);
        splash.clearAnimation();
        splash.startAnimation(translat);

        translat.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash.this,Language.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
