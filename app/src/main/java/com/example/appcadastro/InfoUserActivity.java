package com.example.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);
    }

    public void addUser(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void listUser(View view){
        Intent i = new Intent(this, ListUserActivity.class);
        startActivity(i);
    }

}