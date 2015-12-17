package com.example.jimy.sussa;

/**
 * Created by Jimy on 16/12/15.
 */
public class User {
    private String
            nome = "teste",
            usuario = "testenick",
            email = "teste@unifesp.br",
            senha = "testeteste",
            curso = "BCTeste";

    //set of Matrix of user
    private MatrizBCT_fragment matrizBCT_fragment;
    private MatrizBCC_fragment matrizBCC_fragment;

    public User(String nome, String usuario, String email, String senha, String curso) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.curso = curso;
        matrizBCT_fragment = new MatrizBCT_fragment();
        matrizBCC_fragment = new MatrizBCC_fragment();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public MatrizBCT_fragment getMatrizBCT_fragment() {
        return matrizBCT_fragment;
    }

    public MatrizBCC_fragment getMatrizBCC_fragment() {
        return matrizBCC_fragment;
    }

    public void setMatrizBCT_fragment(MatrizBCT_fragment matrizBCT_fragment) {
        this.matrizBCT_fragment = matrizBCT_fragment;
    }

    public void setMatrizBCC_fragment(MatrizBCC_fragment matrizBCC_fragment) {
        this.matrizBCC_fragment = matrizBCC_fragment;
    }
}
