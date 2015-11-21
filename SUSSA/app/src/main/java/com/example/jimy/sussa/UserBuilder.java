package com.example.jimy.sussa;

/**
 * Created by Jimy on 11/11/15.
 */
public class UserBuilder {
    public void setUsuario(String nome, String email, String senha, String curso){
        if(nome!="")    Usuario.nome = nome;
        if(email!="")   Usuario.email = email;
        if(senha!="")   Usuario.senha = senha;
        if(curso!="")   Usuario.curso = curso;
    }
}
