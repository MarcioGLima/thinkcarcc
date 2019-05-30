package com.example.ccproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.ccproject.R;


import java.util.Calendar;
import java.util.Locale;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Element adsElement = new Element();
        adsElement.setTitle("Anuncie Aqui!");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.about_icon_google_play)
                .setDescription("Este é um aplicativo BETA, ainda não completo. Feito para aula de Programação para Dispositivo Móvel. ")
                .addItem(new Element().setTitle("Version 0.9"))
                .addItem(adsElement)
                .addGroup("Conecte com nós!")
                .addEmail("m.theus.lt@gmail.com")
                .addFacebook("MatheusSilva")
                .addTwitter("My Twitter")
                .addYoutube("My Youtube")
                .addPlayStore("My PlayStore")
                .addInstagram("My Instagram")
                .addGitHub("teste")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent loginActivity = new Intent(this, Menu.class);
        startActivity(loginActivity);
        finish();
    }

    private Element createCopyright() {
        Element copyright = new Element();
        final String copyrightString = String.format(Locale.getDefault(), "Copyright %d by Marcio", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIconDrawable(R.mipmap.ic_launcher_round);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, copyrightString, Toast.LENGTH_LONG).show();
                // Toast.makeText(AboutActivity.this, copyrightString, Toast.LENGTH_LONG).show();
            }
        });
        return copyright;
    }
}
