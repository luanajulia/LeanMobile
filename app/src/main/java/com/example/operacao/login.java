package com.example.operacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.operacao.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {

    private EditText mEditEmail;
    private EditText mEditPassword;
    private Button mBtnEnter;
    private TextView resultado;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        mEditEmail = findViewById(R.id.edit_email);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnEnter = findViewById(R.id.btn_enter);
        resultado = findViewById(R.id.resultado);


        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEditEmail.getText().toString();
                String password = mEditPassword.getText().toString();

                Usuario usu = new UsuarioDao().selecionarUsuario(email, password);
                if (usu != null){
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    resultado.setText("Usuario ou Senha Invalido");
                }
            }
        });


}}
/*
if(email.equalsIgnoreCase("suporte")){
                    if (password.equalsIgnoreCase("123123")){
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        resultado.setText("Senha inválida");

                    }
                }else {
                    resultado.setText("Usuario Invalido");
                }
 */