package com.example.jimy.sussa;

import java.util.HashMap;

/**
 * Created by Jimy on 16/11/15.
 */
public class BDDisciplinas {
    HashMap<Integer,Disciplina> hashMatrizAbsoluta;
    Disciplina C1 = new Disciplina(R.id.btC1,"Obrigatoria","Calculo 1",false);

    public BDDisciplinas(){
        hashMatrizAbsoluta = new HashMap<>();
        hashMatrizAbsoluta.put(R.id.btC1, C1);
    }

    public boolean isCursado(int id_disciplina){
        return hashMatrizAbsoluta.get(id_disciplina).isDisciplinaFeita();
    }

    public void setCursado(int id_disciplina){
        if(isCursado(id_disciplina)) {
            hashMatrizAbsoluta.get(id_disciplina).setDisciplinaFeita(false);
        }else
        hashMatrizAbsoluta.get(id_disciplina).setDisciplinaFeita(true);
    }
}
