package com.api.client;

import com.api.model.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BASE_URL = "https://serverest.dev/#/";

    public Response criarUsuario(User user) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(user.toJson())   // ← CORREÇÃO CRÍTICA
                .log().all()
                .when()
                .post("/usuarios")
                .then()
                .log().all()
                .extract().response();
    }

    public Response buscarUsuario(String id) {
        return given()
                .baseUri(BASE_URL)
                .log().all()
                .when()
                .get("/usuarios/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    public Response deletarUsuario(String id) {
        return given()
                .baseUri(BASE_URL)
                .log().all()
                .when()
                .delete("/usuarios/" + id)
                .then()
                .log().all()
                .extract().response();
    }
}
