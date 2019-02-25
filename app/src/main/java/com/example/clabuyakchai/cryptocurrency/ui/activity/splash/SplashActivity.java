package com.example.clabuyakchai.cryptocurrency.ui.activity.splash;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.ui.activity.currency.CurrencyActivity;
import com.example.clabuyakchai.cryptocurrency.ui.activity.login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;

    private final Handler handler = new Handler();
    private final Launcher launcher = new Launcher();

    private ImageView iconImage;
    private GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        iconImage = findViewById(R.id.icon);
        iconAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        account = GoogleSignIn.getLastSignedInAccount(this);
        handler.postDelayed(launcher, SPLASH_DELAY);
    }

    private void iconAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iconImage, View.TRANSLATION_Y, 50f, -50f, 0f);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    @Override
    protected void onStop() {
        handler.removeCallbacks(launcher);
        super.onStop();
    }

    private void launch() {
        if (!isFinishing()) {
            if (account != null) {
                startActivity(new Intent(this, CurrencyActivity.class));
            } else {
                startActivity(new Intent(this, LoginActivity.class));
            }
            finish();
        }
    }

    private class Launcher implements Runnable {
        @Override
        public void run() {
            launch();
        }
    }
}
