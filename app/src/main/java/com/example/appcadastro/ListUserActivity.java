package com.example.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {
    private ListView usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        findViewsById();

        Intent i = getIntent();
        ArrayList<User> users = (ArrayList<User>) i.getSerializableExtra("users");
        if(users == null){
            return;
        }

        ArrayList<String> nomes = new ArrayList<>();

        for (User user : users) {
            if(user.getNome() == null){
                break;
            }
            nomes.add(user.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, nomes
        );
        usuarios.setAdapter(adapter);
    }

    private void findViewsById(){
        usuarios = findViewById(R.id.lv_users);
    }

    public void addUser(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void infoUser(View view){
        Intent i = new Intent(this, InfoUserActivity.class);
        startActivity(i);
    }


}