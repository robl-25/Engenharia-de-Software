package com.example.jimy.sussa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MatrizInterativa extends AppCompatActivity implements View.OnClickListener{
    Button btEditarMatriz;
    BDDisciplinas bddisciplinas;
    TextView tvMatrizAtual;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    MatrizBCT_fragment mbct = new MatrizBCT_fragment();
    MatrizBCC_fragment mbcc = new MatrizBCC_fragment();

    int count = 0;      //indice de referencia ao fragment atual
    int edicao = 0;     //indice de referencia ao modo de acesso da matriz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bddisciplinas = new BDDisciplinas();
        setContentView(R.layout.activity_matrizesint);

        tvMatrizAtual = (TextView)findViewById(R.id.tvMatrizAtual);
        btEditarMatriz = (Button)findViewById(R.id.btEditarMatriz);

        //setando o local onde a matriz BCT vai ser posicionada
        fragmentTransaction.add(R.id.llMatrizContainer, mbct);
        fragmentTransaction.commit();

        //// TODO: 18/11/15 Mesclar spinner com tvMatrizAtual
        btEditarMatriz.setOnClickListener(this);
        tvMatrizAtual.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvMatrizAtual:
                openFragment(getNextMatriz());
                break;
            case R.id.btEditarMatriz:
                //POSSIBILITAR EDICAO
                if(edicao == 0) {
                    edicao = 1;
                    btEditarMatriz.setText("VISUALIZAR");
                    switch (count) {
                        case 0:
                            mbct.setButtonsEnabled();
                            break;
                        case 1:
                            //mbcc.setButtonsEnabled();
                            break;
                    }
                }
                //MODO DE LEITURA
                else{
                    edicao = 0;
                    btEditarMatriz.setText("EDITAR MATRIZ");
                    switch (count) {
                        case 0:
                            mbct.setButtonsUnabled();
                            break;
                        case 1:
                            //mbcc.setButtonsUnabled();
                            break;
                    }
                }
        }
    }

    //esse metodo eh necessario para toda vez instanciar um novo fragmentManager
    public void openFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.llMatrizContainer, fragment);
        fragmentTransaction.addToBackStack(null);   //serve para lembrar que o fragment atual sera a tela que aparecera ao apertar 'voltar'
        fragmentTransaction.commit();
    }

    public Fragment getNextMatriz(){
        switch (count){
            case 0:
                tvMatrizAtual.setText("MATRIZ_BCC");
                count++;
                return mbcc;
            case 1:
                tvMatrizAtual.setText("MATRIZ_BCT");
                count--;
                return mbct;
        }
        return mbct;
    }


}
