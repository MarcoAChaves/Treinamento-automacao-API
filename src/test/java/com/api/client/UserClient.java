package com.api.client;

import com.api.model.User;
import com.api.utils.EvidenceLogger;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BASE_URL = "https://serverest.dev/#/";

    public Response criarUsuario(User user) {

        System.out.println("JSON ENVIADO:");
        System.out.println(user.toJson());   // 👈 PRINT AQUI

        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .body(user.toJson())
                        .when()
                        .post("/usuarios")
                        .then()
                        .extract().response();

        EvidenceLogger.addStep(
                "POST /usuarios",
                String.valueOf(response.statusCode()),
                response.asPrettyString()
        );

        return response;
    }

    public Response buscarUsuario(String id) {
        Response response =
         given()
                .baseUri(BASE_URL)
                .log().all()
                .when()
                .get("/usuarios/" + id)
                .then()
                .log().all()
                .extract().response();
        EvidenceLogger.addStep(
                "GET /usuarios/" + id,
                response.statusCode() < 300 ? "PASS" : "FAIL",
                response.asPrettyString()
        );
        return response;
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
