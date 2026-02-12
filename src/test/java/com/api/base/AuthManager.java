package com.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class AuthManager {

    private static String token;

    public static void authenticate(String email, String password) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(body.toString())
                .post("/login");

        token = response.jsonPath().getString("authorization");
    }

    public static String getToken() {
        return token;
    }
}