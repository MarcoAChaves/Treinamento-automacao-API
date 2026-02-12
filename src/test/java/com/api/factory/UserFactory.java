package com.api.factory;

import com.api.model.User;
import java.util.UUID;

public class UserFactory {

    public static User usuarioValido() {
        User user = new User();
        user.nome = "Usuario " + UUID.randomUUID();
        user.email = "user" + UUID.randomUUID() + "@test.com";
        user.password = "123456";
        user.administrador = "true";
        return user;
    }

    public static User usuarioSemSenha() {
        User user = usuarioValido();
        user.password = null;
        return user;
    }

    public static User usuarioDuplicado(String email) {
        User user = usuarioValido();
        user.email = email;
        return user;
    }
}

