package com.api.assertions;

import com.api.utils.EvidenceLogger;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseValidator {

    public static void statusCode(Response response, int esperado) {
        EvidenceLogger.log("Validando status code esperado: " + esperado);

        Assertions.assertEquals(esperado, response.statusCode());
    }

    public static void message(Response response, String expectedMessage) {
        EvidenceLogger.log("Validando mensagem");
        String message = response.jsonPath().getString("message");

        Assertions.assertEquals(expectedMessage, message,
                "Mensagem retornada diferente da esperada");
    }

    public static void fieldEquals(Response response, String field, Object expected) {
        assertNotNull(response, "Response está nulo");
        Object value = response.jsonPath().get(field);

        Assertions.assertEquals(expected, value,
                "Valor diferente no campo: " + field);
    }

    public static void notNull(Response response, String field) {
        assertNotNull(response.jsonPath().get(field),
                "Campo nulo: " + field);
    }

    public static void responseTimeLessThan(Response response, long maxMillis) {
        assertTrue(response.time() < maxMillis,
                "Tempo excedido: " + response.time() + "ms");
    }
}