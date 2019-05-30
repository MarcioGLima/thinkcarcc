package com.example.ccproject.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ccproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class Menu extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private Button btLogin;
    private Button btRegistro;
    private ProgressBar loginProgess;
    private FirebaseAuth mAuth;
    private Intent PainelAcitivy;
    private Intent RegisterActivity;


//    @Override
//    protected void onResume() {
//        String email = "gaabriel.lima15@gmail.com";
//        String senha = "123456";
//        signIn(email,senha);
//
//
//        super.onResume();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //INU VIEW
        userEmail = findViewById(R.id.tLogin);
        userPassword = findViewById(R.id.tSenha);
        btRegistro = findViewById(R.id.reg_novo);
        btLogin =  findViewById(R.id.btLogin);
        loginProgess = findViewById(R.id.login_progrss);
        mAuth = FirebaseAuth.getInstance();
        RegisterActivity = new Intent(this,RegisterActivity.class);

        PainelAcitivy = new Intent(this,com.example.ccproject.Activities.PainelActivity.class);

        loginProgess.setVisibility(View.INVISIBLE);





        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateREG();
            }
        });


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginProgess.setVisibility(View.VISIBLE);
                btLogin.setVisibility(View.INVISIBLE);

                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    showMessage("Por favor verifique todos os campos");
                    btLogin.setVisibility(View.VISIBLE);
                    loginProgess.setVisibility(View.INVISIBLE);




                }
                else{
                    signIn(email,password);
                }




            }
        });


    }

    //Função para verificação FIREBASE e
    // FUNÇÃO PARA ENTRAR NO MENU
    public void signIn(String email, String password){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    loginProgess.setVisibility(View.INVISIBLE);
                    btLogin.setVisibility(View.VISIBLE);
                    updateUI();
                }
                else{
                    showMessage(task.getException().getMessage());
                    // Criação da conta falhou!
                    String erroExcecao;

                    try{
                        throw task.getException();
                    }  catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "O E-mail ou senha digitado é invalido!";
                    } catch (Exception e){
                        erroExcecao = "Erro ao efetuar o login!";
                        e.printStackTrace();
                    }
                    Toast.makeText(Menu.this, erroExcecao, Toast.LENGTH_LONG).show();
                    btLogin.setVisibility(View.VISIBLE);
                    loginProgess.setVisibility(View.INVISIBLE);
                }

            }
        });
    }


    private void updateUI(){
        startActivity(PainelAcitivy);
        finish();
    }

    private void updateREG(){
        startActivity(RegisterActivity);
        finish();
    }

    //Funcao para mostrar mensagem!

    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }




    public void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}
