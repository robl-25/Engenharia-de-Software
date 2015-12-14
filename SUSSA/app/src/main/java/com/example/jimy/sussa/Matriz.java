package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Matriz extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz);

        //Iniciando toolbars
        ToolbarCreator tc = new ToolbarCreator();
        tc.initToolbars(this,"SUSSA_MATRIZES");

        TextView matrizesInterativas = (TextView)findViewById(R.id.tvMatrizesInterativas);
        TextView planejador = (TextView)findViewById(R.id.tvPlanejador);
        TextView progressoCursos = (TextView)findViewById(R.id.tvProgressoCursos);

        matrizesInterativas.setGravity(Gravity.CENTER);
        planejador.setGravity(Gravity.CENTER);
        progressoCursos.setGravity(Gravity.CENTER);

        matrizesInterativas.setOnClickListener(this);
        planejador.setOnClickListener(this);
        progressoCursos.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvMatrizesInterativas:
                startActivity(new Intent(this,MatrizInterativa.class));
                break;
            case R.id.tvPlanejador:
                break;
            case R.id.tvProgressoCursos:
                setContentView(R.layout.activity_progress);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.itBusca:
                Toast.makeText(this,"Realize sua busca",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itPreferencias:
                Toast.makeText(this,"Carregando tela de preferencias",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itAjuda:
                Toast.makeText(this,"Abrindo tela de ajuda",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itSair:
                Toast.makeText(this,"Retornando a tela de login..",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Login.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
