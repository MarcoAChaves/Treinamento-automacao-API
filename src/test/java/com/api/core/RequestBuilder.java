package com.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RequestBuilder {

    public static RequestSpecification build() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .build();
    }
}
