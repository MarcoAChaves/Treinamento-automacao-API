package com.API.client;

import com.API.model.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response createUser(User user){
        return given()
                .contentType("application/json")
                .body(user)
                .post("/usuarios");
    }

    public Response getUsers(){
        return given()
                .get("/usuarios");
    }

    public Response getUserById(String id){
        return given()
                .get("/usuarios/" + id);
    }

    public Response deleteUser(String id){
        return given()
                .delete("/usuarios/" + id);
    }
}
