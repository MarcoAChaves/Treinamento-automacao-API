package com.api.tests;

import com.api.assertions.ResponseValidator;
import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.UsuarioService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioGetTest extends BaseTest {

    @Test
    void deveBuscarUsuarioPorId() {

        // cria usuário
        User user = UserFactory.usuarioValido();

        Response create =
                UsuarioService.criarUsuario(user);

        String id = create.jsonPath().getString("_id");
        assertNotNull(id);


        // busca usuário criado
        Response response =
                UsuarioService.buscarUsuario(id);

        ResponseValidator.statusCode(response, 200);
    }
}