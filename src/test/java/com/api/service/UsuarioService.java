package com.api.service;

import com.api.core.RequestBuilder;
import com.api.model.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsuarioService {

    public static Response criarUsuario(User user) {
        return given()
                .spec(RequestBuilder.build())
                .body(user)
                .post("/usuarios");
    }

    public static Response buscarUsuarios() {
        return given()
                .spec(RequestBuilder.build())
                .get("/usuarios");
    }

    public static Response buscarUsuarioPorId(String id) {
        return given()
                .spec(RequestBuilder.build())
                .get("/usuarios/" + id);
    }

    public static Response deletarUsuario(String id) {
        return given()
                .spec(RequestBuilder.build())
                .delete("/usuarios/" + id);
    }
}
