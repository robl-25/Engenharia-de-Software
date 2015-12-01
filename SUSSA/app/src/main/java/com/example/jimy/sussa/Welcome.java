package com.example.jimy.sussa;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener{
//// TODO: 10/11/15 colocar informacoes do grupo e da materia/projeto no link 'Sobre'
//// TODO: 30/11/15 Colocar o 'Sobre' na overflow toolbar
//// TODO: 30/11/15 criar logo do SUSSA e nome do grupo desenvolvedor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageButton sussaIcon = (ImageButton)findViewById(R.id.ibSussaIcon);
        sussaIcon.setOnClickListener(this);

        TextView sobre = (TextView)findViewById(R.id.tvSobre);
        sobre.setOnClickListener(this);
        
        //// TODO: 13/11/15 Colocar icone na barra nao esta funfando.. 
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        try{
            actionBar.setIcon(R.drawable.sussaicon);
        }catch(NullPointerException n) {
            Toast.makeText(this, "actionBar vazio..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibSussaIcon:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.tvSobre:
                Toast.makeText(this,"Abrindo arquivos de informacoes do projeto",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
