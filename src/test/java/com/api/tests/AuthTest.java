package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.AuthService;
import com.api.service.UsuarioService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthTest extends BaseTest {

    @Test
    void deveLogarComSucesso() {

        User user = UserFactory.usuarioValido();

        UsuarioService.criarUsuario(user);

        Response response =
                AuthService.login(user.getEmail(), user.getPassword());

        assertEquals(200, response.statusCode());
        assertNotNull(response.jsonPath().getString("authorization"));
    }
}