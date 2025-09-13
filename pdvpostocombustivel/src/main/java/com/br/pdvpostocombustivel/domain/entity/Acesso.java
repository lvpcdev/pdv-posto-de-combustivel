package com.br.domain.entity;

public class Acesso {

    //atributos
    private String usuario;
    private String senha;

    //contrutor
    public Acesso(String usuario, String senha) {
        this.usuario = usuario;
        this.senha =senha;
    }

    //getters
    public String getSenha() {
        return senha;
    }
    public String getUsuario() {
        return usuario;
    }

    //setters
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
