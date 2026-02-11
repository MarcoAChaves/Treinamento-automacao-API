package com.API.model;

public class User {

    public String nome;
    public String email;
    public String password;
    public String administrador;

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.password = "123456";
        this.administrador = "true";
    }
}
