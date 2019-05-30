package com.example.ccproject.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ccproject.Models.Carros;
import com.example.ccproject.Print.Print;
import com.example.ccproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;


public class InicioActivity extends AppCompatActivity {



    private EditText inicioEnd = null, destinoEnd = null, kmInicio = null;

    private Button iniciarViagem = null;
    private Spinner nivelComb = null;
    private ArrayAdapter<String> dataAdapter;
    private Spinner mSpinner;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    private DatabaseReference mDatabase;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inicio);
            mAuth = FirebaseAuth.getInstance();
            kmInicio = findViewById(R.id.km_atual);
            currentUser = mAuth.getCurrentUser();
            nivelComb = findViewById(R.id.nivel_comb);
            inicioEnd = findViewById(R.id.inicio_end);
            destinoEnd = findViewById(R.id.destino_end);
            iniciarViagem = findViewById(R.id.iniciar_viagem);

            //Database Firebase
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            mDatabase = database.getInstance().getReference();
            mDatabase.child("Inicio-Viagem").child("inicio-teste").setValue("Testeee");




            //UpdateInicio tem sua funcao para mostrar o usuario que esta usando o aplicativo
            updateInicio();


            iniciarViagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    comecarViagem();



                }
            });


        }


        public void updateInicio() {

            TextView inicioUser = findViewById(R.id.inicio_user);

            inicioUser.setText(currentUser.getDisplayName());

    }

    public void comecarViagem(){

        final String inicioEnde = inicioEnd.getText().toString();
        final String destinoEnde = destinoEnd.getText().toString();
        //final Double kmInicial = Double.parseDouble(kmInicio.getText().toString());
       // FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = mDatabase.getInstance().getReference();



        if(inicioEnde.isEmpty()|| destinoEnde.isEmpty() ){
            Toast.makeText(this, "Por favor coloque dados em todos os campos", Toast.LENGTH_SHORT).show();


        }
        else{

            mDatabase.child("Inicio-Viagem").child("inicio-End").setValue(inicioEnde);
            mDatabase.child("Inicio-Viagem").child("destino-End").setValue(destinoEnde);
          //  mDatabase.child("Inicio-Viagem").child("km-Inicial").setValue(kmInicial);



            Intent chegadaActivity = new Intent(InicioActivity.this, ChegadaActivity.class);
            startActivity(chegadaActivity);




        }

    }

}

