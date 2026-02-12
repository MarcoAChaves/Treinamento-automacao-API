package com.api.service;

import com.api.core.RequestBuilder;
import com.api.model.LoginRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService {

    public static Response login(LoginRequest login) {
        return given()
                .spec(RequestBuilder.build())
                .body(login)
                .post("/login");
    }
}
