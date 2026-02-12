package com.api.service;

import com.api.core.RequestBuilder;
import com.api.model.User;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UsuarioService {

    public static Response criarUsuario(User user) {

        JSONObject body = new JSONObject();
        body.put("nome", user.getNome());
        body.put("email", user.getEmail());
        body.put("password", user.getPassword());
        body.put("administrador", user.getAdministrador());

        return RequestBuilder.post("/usuarios", body.toString());
    }

    public static Response buscarUsuarioPorId(String id) {
        return RequestBuilder.get("/usuarios/" + id);
    }

    public static Response deletarUsuario(String id) {
        return RequestBuilder.delete("/usuarios/" + id);
    }
}
