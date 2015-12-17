package com.example.jimy.sussa;

import java.util.HashMap;

/**
 * Created by Jimy on 16/11/15.
 */
public class BDDisciplinas {
    HashMap<Integer,Disciplina> hashMatrizAbsoluta;
    Disciplina C1 = new Disciplina(R.id.btC1,"Calculo 1","Obrigatoria",false);
    Disciplina ID1 = new Disciplina(R.id.btID1,"Interdisciplinar","Interdisciplinar",false);

    public BDDisciplinas(){
        hashMatrizAbsoluta = new HashMap<>();
        hashMatrizAbsoluta.put(R.id.btC1, C1);
        hashMatrizAbsoluta.put(R.id.btID1, ID1);
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

    public String getCursoNome(int id_disciplina){
        return hashMatrizAbsoluta.get(id_disciplina).getNome();
    }

    public void setCursoNome(int id_disciplina, String nome){
        hashMatrizAbsoluta.get(id_disciplina).setNome(nome);
    }

    public String getCursoTipo(int id_disciplina){
        return hashMatrizAbsoluta.get(id_disciplina).getType();
    }
}
