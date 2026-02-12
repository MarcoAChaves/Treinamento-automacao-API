package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioGetTest extends BaseTest {

    @Test
    void deveBuscarUsuarioPorId() {

        var user = UserFactory.usuarioValido();
        var createResponse = UsuarioService.criarUsuario(user);

        String id = createResponse.jsonPath().getString("_id");

        var response = UsuarioService.buscarUsuarioPorId(id);

        assertEquals(200, response.statusCode());
        assertEquals(user.email, response.jsonPath().getString("email"));
    }
}
