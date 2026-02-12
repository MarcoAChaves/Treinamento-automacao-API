package com.api.tests;

import com.api.core.BaseTest;
import com.api.factory.UserFactory;
import com.api.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDeleteTest extends BaseTest {

    @Test
    void deveDeletarUsuario() {

        var user = UserFactory.usuarioValido();
        var createResponse = UsuarioService.criarUsuario(user);

        String id = createResponse.jsonPath().getString("_id");

        var deleteResponse = UsuarioService.deletarUsuario(id);

        assertEquals(200, deleteResponse.statusCode());
        assertEquals("Registro excluído com sucesso", deleteResponse.jsonPath().getString("message"));
    }
}
