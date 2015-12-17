package com.example.jimy.sussa;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Jimy on 24/11/15.
 */
public class ToolbarCreator implements View.OnClickListener{
    AppCompatActivity activity;

    public void initToolbars(AppCompatActivity activity,String Titulo){
        this.activity =  activity;

        //// TODO: 16/11/15 pesquisar forma de incluir biblioteca android support
        //Recebendo toolbar criadas
        android.support.v7.widget.Toolbar tbTop = (android.support.v7.widget.Toolbar)activity.findViewById(R.id.tbTop);
        android.support.v7.widget.Toolbar tbBottom = (android.support.v7.widget.Toolbar)activity.findViewById(R.id.tbBottom);

        //Tratando o tbtop como se fosse o AcionBar padrao, portanto precisa implementar metodo onCreateOptionsMenu
        activity.setSupportActionBar(tbTop);

        //// TODO: 14/11/15 gambirra para editar o titulo...
        activity.getSupportActionBar().setTitle(Titulo);
        //tbBottom.inflateMenu(R.menu.bottom_menu);

        //margens
        tbBottom.setContentInsetsAbsolute(10, 10);

        ImageButton itProfile = (ImageButton)activity.findViewById(R.id.itProfile);
        ImageButton itMatriz = (ImageButton)activity.findViewById(R.id.itMatriz);
        ImageButton itProfessores = (ImageButton)activity.findViewById(R.id.itProfessores);
        ImageButton itArquivos = (ImageButton)activity.findViewById(R.id.itArquivos);

        itProfile.setOnClickListener(this);
        itMatriz.setOnClickListener(this);
        itProfessores.setOnClickListener(this);
        itArquivos.setOnClickListener(this);


//        tbBottom.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.itProfile:
//                        //TODO verificar se Cesta na propria activity Profile
//                        Toast.makeText(v.getApplicationContext(), "Carregando tela de perfil", Toast.LENGTH_SHORT).show();
//                        v.startActivity(new Intent(v.getApplicationContext(), Profile.class));
//                        break;
//                    case R.id.itMatriz:
//                        //// TODO: 23/11/15 Bug: icone prevalece na proxima activity..
//                        Toast.makeText(v.getApplicationContext(),"Carregando tela de gerencia de matrizes",Toast.LENGTH_SHORT).show();
//                        v.startActivity(new Intent(v.getApplicationContext(), Matriz.class));
//                        break;
//                    case R.id.itProfessores:
//                        Toast.makeText(v.getApplicationContext(),"Carregando tela de Professores",Toast.LENGTH_SHORT).show();
//                        v.startActivity(new Intent(v.getApplicationContext(), Professores.class));
//                        break;
//                    case R.id.itArquivos:
//                        Toast.makeText(v.getApplicationContext(),"Carregando tela de Arquivos",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return false;
//            }
//        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.itProfile:
                //TODO verificar se Cesta na propria activity Profile
                Toast.makeText(activity.getApplicationContext(), "Carregando tela de perfil", Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity.getApplicationContext(), Profile.class));
                break;
            case R.id.itMatriz:
                //// TODO: 23/11/15 Bug: icone prevalece na proxima activity..
                Toast.makeText(activity.getApplicationContext(),"Carregando tela de gerencia de matrizes",Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity.getApplicationContext(), Matriz.class));
                break;
            case R.id.itProfessores:
                Toast.makeText(activity.getApplicationContext(),"Carregando tela de Professores",Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity.getApplicationContext(), Professores.class));
                break;
            case R.id.itArquivos:
                Toast.makeText(activity.getApplicationContext(),"Carregando tela de Arquivos",Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity.getApplicationContext(),Arquivos.class));
                break;
        }
    }
}
