package com.example.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spnUf;
    private EditText nome, sobrenome, idade, apelido, email, telefone, cidade, senha, senhaConfirmada;;
    private CheckBox cbAcao, cbAventura, cbRpg, cbEstrategia;
    ArrayList<String> generos = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        getGeneroChecked();
    }

    private void findViewsById(){
        nome = findViewById(R.id.et_nome);
        sobrenome = findViewById(R.id.et_sobrenome);
        idade = findViewById(R.id.et_idade);
        apelido = findViewById(R.id.et_apelido);
        email = findViewById(R.id.et_email);
        telefone = findViewById(R.id.et_tel);
        cidade = findViewById(R.id.et_cidade);
        spnUf = findViewById(R.id.spn_uf);
        cbAcao = findViewById(R.id.cb_acao);
        cbAventura = findViewById(R.id.cb_aventura);
        cbRpg = findViewById(R.id.cb_rpg);
        cbEstrategia = findViewById(R.id.cb_estrategia);
        senha = findViewById(R.id.et_senha);
        senhaConfirmada = findViewById(R.id.et_senha_confirmada);
    }

    public void listUser(View view){
       Intent i = new Intent(this, ListUserActivity.class);
       i.putExtra("users", users);
       startActivity(i);
    }

    public void infoUser(View view){
        Intent i = new Intent(this, ListUserActivity.class);
        startActivity(i);
    }

    public void saveUser(View view){
        if(!validateForm()){
            return;
        }

        User usuario = new User();

        usuario.setNome(nome.getText().toString());
        usuario.setSobrenome(sobrenome.getText().toString());
        usuario.setIdade(Integer.parseInt(idade.getText().toString()));
        usuario.setApelido(apelido.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setTelefone(telefone.getText().toString());
        usuario.setCidade(cidade.getText().toString());
        usuario.setUf(spnUf.getSelectedItem().toString());
        usuario.setGenero(generos);
        usuario.setSenha(senha.getText().toString());

        users.add(usuario);

        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    public boolean validateForm() {
        if(nome.getText().toString().isEmpty()){
            Toast.makeText(this, "O campo Nome é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(sobrenome.getText().toString().isEmpty()){
            Toast.makeText(this, "O campo Sobrenome é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(idade.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Idade deve ser preenchida!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(Integer.parseInt(idade.getText().toString().trim()) < 18){
            Toast.makeText(this, "O usuario deve ser maior de idade (+18)", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(apelido.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "O campo Apelido é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "O campo E-mail é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(telefone.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "O campo Telefone é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(cidade.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "O campo Cidade é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(spnUf.getSelectedItem().equals("Selecione...")){
            Toast.makeText(this, "O campo UF é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!cbAcao.isChecked() && !cbAventura.isChecked() && !cbRpg.isChecked() && !cbEstrategia.isChecked()){
            Toast.makeText(this, "Genero deve ter pelo menos uma opção selecionada!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(senha.getText().toString().isEmpty()){
            Toast.makeText(this, "A senha é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(senhaConfirmada.getText().toString().isEmpty()){
            Toast.makeText(this, "Confirme a senha!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!senha.getText().toString().trim().equals(senhaConfirmada.getText().toString().trim())){
            Toast.makeText(this, "As senhas devem ser iguais!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void clearFields(){
        nome.getText().clear();
        sobrenome.getText().clear();
        idade.getText().clear();
        apelido.getText().clear();
        email.getText().clear();
        telefone.getText().clear();
        cidade.getText().clear();
        spnUf.setSelection(0);
        cbAcao.setChecked(false);
        cbAventura.setChecked(false);
        cbRpg.setChecked(false);
        cbEstrategia.setChecked(false);
        senha.getText().clear();
        senhaConfirmada.getText().clear();
    }

    private void getGeneroChecked(){
        cbAcao.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                generos.add(cbAcao.getText().toString());
            } else {
                generos.remove(cbAcao.getText().toString());
            }
        });
        cbAventura.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                generos.add(cbAventura.getText().toString());
            } else {
                generos.remove(cbAventura.getText().toString());
            }
        });
        cbRpg.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                generos.add(cbRpg.getText().toString());
            } else {
                generos.remove(cbRpg.getText().toString());
            }
        });
        cbEstrategia.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                generos.add(cbEstrategia.getText().toString());
            } else {
                generos.remove(cbEstrategia.getText().toString());
            }
        });
    }

}