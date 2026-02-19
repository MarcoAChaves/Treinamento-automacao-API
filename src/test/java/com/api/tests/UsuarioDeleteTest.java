package com.api.tests;

import com.api.assertions.ResponseValidator;
import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.model.User;
import com.api.service.UsuarioService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDeleteTest extends BaseTest {

    @Test
    void deveDeletarUsuario() {

        User user = UserFactory.usuarioValido();

        Response create =
                UsuarioService.criarUsuario(user);

        String id = create.jsonPath().getString("_id");

        Response delete =
                UsuarioService.deletarUsuario(id);

        ResponseValidator.statusCode(delete, 200);
        ResponseValidator.message(delete, "Registro excluído com sucesso");
    }
}
