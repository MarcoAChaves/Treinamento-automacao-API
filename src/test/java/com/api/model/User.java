package com.api.model;

import org.json.JSONObject;

public class User {

    private String nome;
    private String email;
    private String password;
    private String administrador;

    // setters
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setAdministrador(String administrador) { this.administrador = administrador; }

    // getters  ← FALTAVAM
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getAdministrador() { return administrador; }

    public String toJson() {
        return new JSONObject()
                .put("nome", nome)
                .put("email", email)
                .put("password", password)
                .put("administrador", administrador)
                .toString();
    }
}
