package com.amk_community.amkexamen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.amk_community.amkexamen.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Jordan on 06/09/2017.
 */
public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    @BindView(R.id.img_splash)
    ImageView imageView;

    private Animation animation;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
