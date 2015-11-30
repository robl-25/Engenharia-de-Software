package com.example.jimy.sussa;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Jimy on 24/11/15.
 */
public class ToolbarCreator {

    public void initToolbars(AppCompatActivity activity,String Titulo){
        final AppCompatActivity v =  activity;

        //// TODO: 16/11/15 pesquisar forma de incluir biblioteca android support
        //Recebendo toolbar criadas
        android.support.v7.widget.Toolbar tbTop = (android.support.v7.widget.Toolbar)v.findViewById(R.id.tbTop);
        android.support.v7.widget.Toolbar tbBottom = (android.support.v7.widget.Toolbar)v.findViewById(R.id.tbBottom);

        //Tratando o tbtop como se fosse o AcionBar padrao, portanto precisa implementar metodo onCreateOptionsMenu
        v.setSupportActionBar(tbTop);

        //// TODO: 14/11/15 gambirra para editar o titulo...
        v.getSupportActionBar().setTitle(Titulo);
        tbBottom.inflateMenu(R.menu.bottom_menu);

        //margens
        tbBottom.setContentInsetsAbsolute(10,10);


        tbBottom.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itProfile:
                        //TODO verificar se Cesta na propria activity Profile
                        Toast.makeText(v.getApplicationContext(), "Carregando tela de perfil", Toast.LENGTH_SHORT).show();
                        v.startActivity(new Intent(v.getApplicationContext(), Profile.class));
                        break;
                    case R.id.itMatriz:
                        //// TODO: 23/11/15 Bug: icone prevalece na proxima activity..
                        Toast.makeText(v.getApplicationContext(),"Carregando tela de gerencia de matrizes",Toast.LENGTH_SHORT).show();
                        v.startActivity(new Intent(v.getApplicationContext(), Matriz.class));
                        break;
                    case R.id.itProfessores:
                        Toast.makeText(v.getApplicationContext(),"Carregando tela de Professores",Toast.LENGTH_SHORT).show();
                        v.startActivity(new Intent(v.getApplicationContext(), Professores.class));
                        break;
                    case R.id.itArquivos:
                        Toast.makeText(v.getApplicationContext(),"Carregando tela de Arquivos",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


    }

}
