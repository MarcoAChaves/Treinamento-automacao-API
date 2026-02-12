package com.api.service;

import com.api.core.RequestBuilder;
import com.api.model.LoginRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class AuthService {

    public static Response login(String email, String senha) {

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", senha);

        return RequestBuilder.post("/login", body.toString());
    }
}
