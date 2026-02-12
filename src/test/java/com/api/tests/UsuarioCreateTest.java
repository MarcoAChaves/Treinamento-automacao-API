package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.UsuarioService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioCreateTest extends BaseTest {

    @Test
    void deveCriarUsuarioComSucesso() {
        User user = UserFactory.usuarioValido();

        Response response = UsuarioService.criarUsuario(user);

        assertEquals(201, response.statusCode());
    }

    @Test
    void naoDeveCriarUsuarioSemSenha() {
        User user = UserFactory.usuarioSemSenha();

        var response = UsuarioService.criarUsuario(user);

        assertEquals(400, response.statusCode());
        assertEquals("password é obrigatório", response.jsonPath().getString("password"));
    }
}
