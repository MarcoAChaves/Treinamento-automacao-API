package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.LoginRequest;
import com.api.service.AuthService;
import com.api.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthTest extends BaseTest {

    @Test
    void deveLogarComSucesso() {

        var user = UserFactory.usuarioValido();
        UsuarioService.criarUsuario(user);

        LoginRequest login = new LoginRequest();
        login.email = user.email;
        login.password = user.password;

        var response = AuthService.login(login);

        assertEquals(200, response.statusCode());
        assertNotNull(response.jsonPath().getString("authorization"));
    }
}