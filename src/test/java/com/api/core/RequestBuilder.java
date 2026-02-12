package com.api.core;

import com.api.model.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class RequestBuilder {

    static {
        RestAssured.baseURI = "https://serverest.dev";
    }

    public static Response post(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    public static Response get(String endpoint) {
        return given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete(String endpoint) {
        return given()
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

//    public static RequestSpecification build() {
//        return null;
//    }
}

