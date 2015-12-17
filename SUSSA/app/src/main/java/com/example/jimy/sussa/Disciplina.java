package com.example.jimy.sussa;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

/**
 * Created by Jimy on 16/11/15.
 */
//// TODO: 22/11/15 fazer disciplina ser um botao dinamico 
public class Disciplina{
    private int id_disciplina;
    private String nome, type;
    private boolean disciplinaFeita;



    public Disciplina(int id_disciplina, String nome, String type, boolean disciplinaFeita) {
        this.id_disciplina = id_disciplina;
        this.nome = nome;
        this.disciplinaFeita = disciplinaFeita;
        this.type = type;
    }

    public boolean isDisciplinaFeita() {
        return disciplinaFeita;
    }

    public void setDisciplinaFeita(boolean disciplinaFeita) {
        this.disciplinaFeita = disciplinaFeita;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
