package com.api.client;

import com.api.base.AuthManager;
import com.api.model.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response createUser(User user) {
        return given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(user)
                .when()
                .post("/usuarios");
    }

    public Response getUsers() {
        return given()
                .header("Authorization", AuthManager.getToken())
                .get("/usuarios");
    }

    public Response getUserById(String id) {
        return given()
                .get("/usuarios/" + id);
    }

    public Response deleteUser(String id) {
        return given()
                .delete("/usuarios/" + id);
    }
}
