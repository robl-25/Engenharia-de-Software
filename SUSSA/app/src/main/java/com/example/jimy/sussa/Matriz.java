package com.example.jimy.sussa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
        initToolbars();

        TextView matrizesInterativas = (TextView)findViewById(R.id.tvMatrizesInterativas);
        TextView planejador = (TextView)findViewById(R.id.tvPlanejador);
        TextView progressoCursos = (TextView)findViewById(R.id.tvProgressoCursos);


        matrizesInterativas.setOnClickListener(this);
        planejador.setOnClickListener(this);
        progressoCursos.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvMatrizesInterativas:
                //// TODO: 13/11/15 Open fragment progress
                //setContentView(R.layout.activity_matrizesint);
                startActivity(new Intent(this,MatrizInterativa.class));
                break;
            case R.id.tvPlanejador:
                break;
            case R.id.tvProgressoCursos:
                setContentView(R.layout.fragment_progress);
                break;
        }
    }


    //Custom Toolbar events handler
    public void initToolbars(){
        //Recebendo toolbar criadas
        android.support.v7.widget.Toolbar tbTop = (android.support.v7.widget.Toolbar)findViewById(R.id.tbTop);
        android.support.v7.widget.Toolbar tbBottom = (android.support.v7.widget.Toolbar)findViewById(R.id.tbBottom);

        //Tratando o tbtop como se fosse o AcionBar padrao, portanto precisa implementar metodo onCreateOptionsMenu
        setSupportActionBar(tbTop);

        getSupportActionBar().setTitle("SUSSA_MATRIZES");
        tbBottom.inflateMenu(R.menu.bottom_menu);


        tbBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itProfile:
                        //TODO verificar se esta na propria activity Profile
                        Toast.makeText(getApplicationContext(), "Carregando tela de perfil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        break;
                    case R.id.itMatriz:
                        Toast.makeText(getApplicationContext(), "Carregando tela de gerencia de matrizes", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Matriz.class));
                        break;
                    case R.id.itProfessores:
                        Toast.makeText(getApplicationContext(), "Carregando tela de Professores", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itArquivos:
                        Toast.makeText(getApplicationContext(), "Carregando tela de Arquivos", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
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
