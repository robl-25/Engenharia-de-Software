package com.example.jimy.sussa;

/**
 * Created by Jimy on 11/11/15.
 */
public class UserBuilder {
    public void setCurrentUser(String nome, String usuario, String email, String senha, String curso, MatrizBCT_fragment matrizBCT_fragment, MatrizBCC_fragment matrizBCC_fragment){
        CurrentUser.nome = nome;
        CurrentUser.usuario = usuario;
        CurrentUser.email = email;
        CurrentUser.senha = senha;
        CurrentUser.curso = curso;
        CurrentUser.matrizBCT_fragment = matrizBCT_fragment;
        CurrentUser.matrizBCC_fragment = matrizBCC_fragment;
    }
}
