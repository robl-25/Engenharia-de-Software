package com.example.jimy.sussa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Profile extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //Iniciando toolbars
        ToolbarCreator tc = new ToolbarCreator();
        tc.initToolbars(this,"SUSSA_PERFIL");


        TextView saudacoes = (TextView)findViewById(R.id.tvSaudacoes);

        //// TODO: 11/11/15 Receber atributos preenchidos na tela de login

        saudacoes.setText("OLA, " + CurrentUser.nome + "!");
        saudacoes.setTypeface(Typeface.DEFAULT_BOLD);


        TextView fillNome = (TextView)findViewById(R.id.tvFillNome);
        TextView fillEmail = (TextView)findViewById(R.id.tvFillEmail);
        TextView fillCurso = (TextView)findViewById(R.id.tvFillCurso);
        TextView tvEditFields = (TextView)findViewById(R.id.tvEditFields);

        tvEditFields.setOnClickListener(this);
        tvEditFields.setGravity(Gravity.CENTER);


        fillNome.setText(CurrentUser.nome);
        fillNome.setTypeface(Typeface.DEFAULT_BOLD);
        fillNome.setGravity(Gravity.CENTER);

        fillEmail.setText(CurrentUser.email);
        fillEmail.setTypeface(Typeface.DEFAULT_BOLD);
        fillEmail.setGravity(Gravity.CENTER);

        fillCurso.setText(CurrentUser.curso);
        fillCurso.setGravity(Gravity.CENTER);
        fillCurso.setTypeface(Typeface.DEFAULT_BOLD);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvEditFields:
                Toast.makeText(this,"Redirecionando para pagina de edicao de campos..",Toast.LENGTH_SHORT).show();
                break;
        }
    }


//    //// TODO: 14/11/15 Pensar em uma maneira de refatorar para evitar a duplicacao do trecho de codigo a seguir em todas as activities
//    //Custom Toolbar events handler
//    public void initToolbars(){
//        //// TODO: 16/11/15 pesquisar forma de incluir biblioteca android support
//        //Recebendo toolbar criadas
//        android.support.v7.widget.Toolbar tbTop = (android.support.v7.widget.Toolbar)findViewById(R.id.tbTop);
//        android.support.v7.widget.Toolbar tbBottom = (android.support.v7.widget.Toolbar)findViewById(R.id.tbBottom);
//
//        //Tratando o tbtop como se fosse o AcionBar padrao, portanto precisa implementar metodo onCreateOptionsMenu
//        setSupportActionBar(tbTop);
//
//        //// TODO: 14/11/15 gambirra para editar o titulo...
//        getSupportActionBar().setTitle("SUSSA_PERFIL");
//        tbBottom.inflateMenu(R.menu.bottom_menu);
//
//
//        tbBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.itProfile:
//                        //TODO verificar se esta na propria activity Profile
//                        Toast.makeText(getApplicationContext(),"Carregando tela de perfil",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.itMatriz:
//                        //// TODO: 23/11/15 Bug: icone prevalece na proxima activity..
//                        Toast.makeText(getApplicationContext(),"Carregando tela de gerencia de matrizes",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), Matriz.class));
//                        break;
//                    case R.id.itProfessores:
//                        Toast.makeText(getApplicationContext(),"Carregando tela de Professores",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), Professores.class));
//                        break;
//                    case R.id.itArquivos:
//                        Toast.makeText(getApplicationContext(),"Carregando tela de Arquivos",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return false;
//            }
//        });
//    }

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
