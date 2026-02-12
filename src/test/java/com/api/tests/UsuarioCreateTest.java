package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioCreateTest extends BaseTest {

    @Test
    void deveCriarUsuarioComSucesso() {
        User user = UserFactory.usuarioValido();

        var response = UsuarioService.criarUsuario(user);

        assertEquals(201, response.statusCode());
    }

    @Test
    void naoDeveCriarUsuarioSemSenha() {
        User user = UserFactory.usuarioSemSenha();

        var response = UsuarioService.criarUsuario(user);

        assertEquals(400, response.statusCode());
        assertEquals("password deve ser uma string", response.jsonPath().getString("password"));
    }
}
