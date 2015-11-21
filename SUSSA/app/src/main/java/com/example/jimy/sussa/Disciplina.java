package com.example.jimy.sussa;

/**
 * Created by Jimy on 16/11/15.
 */
public class Disciplina {
    private int id_disciplina;
    private String nome;
    private boolean disciplinaFeita;

    public Disciplina(int id_disciplina, String nome, boolean disciplinaFeita) {
        this.id_disciplina = id_disciplina;
        this.nome = nome;
        this.disciplinaFeita = disciplinaFeita;
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

}
