package com.example.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.security.auth.Destroyable;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView img = findViewById(R.id.splash_screen);
        Glide.with(this).asGif().load(R.raw.loading).into(img);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent i = new Intent(SplashActivity.this, MainActivity.class);
               startActivity(i);
            }
        }, 2000);
    }

    /** Metodo para esconder a action bar */
    private void hideActionBar(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

}