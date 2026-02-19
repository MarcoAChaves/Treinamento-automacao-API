package com.api.service;

import com.api.client.UserClient;
import com.api.model.User;
import io.restassured.response.Response;

public class UsuarioService {

    private static final UserClient client = new UserClient();

    public static Response criarUsuario(User user) {
        return client.criarUsuario(user);
    }

    public static Response buscarUsuario(String id) {
        return client.buscarUsuario(id);
    }

    public static Response deletarUsuario(String id) {
        return client.deletarUsuario(id);
    }
}
