package com.example.ccproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.ccproject.R;

public class ChegadaActivity extends AppCompatActivity {

    private Spinner nivel_combfim;
    private Button btFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chegada);

        btFinal = findViewById(R.id.btFinal);

        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChegadaActivity.this, PainelActivity.class));
                finish();

            }
        });

    }
}
