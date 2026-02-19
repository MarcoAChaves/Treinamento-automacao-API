package com.api.tests;

import com.api.assertions.ResponseValidator;
import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.UsuarioService;
import com.api.utils.EvidenceLogger;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class UsuarioCreateTest extends BaseTest {

    @Test
    void deveCriarUsuarioComSucesso() {
        User user = UserFactory.usuarioValido();

        Response response = UsuarioService.criarUsuario(user);

        ResponseValidator.statusCode(response, 201);
        ResponseValidator.message(response, "Cadastro realizado com sucesso");
        ResponseValidator.notNull(response, "_id");
    }
}
