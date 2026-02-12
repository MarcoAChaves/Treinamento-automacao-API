package com.api.factory;

import com.api.model.User;
import java.util.UUID;

public class UserFactory {

    public static User usuarioValido() {
        User user = new User();

        user.setNome("Marco Teste");
        user.setEmail("teste" + System.currentTimeMillis() + "@qa.com");
        user.setPassword("123456");
        user.setAdministrador("true");

        return user;
    }

    public static User usuarioSemSenha() {
        User user = new User();

        user.setNome("Marco Teste");
        user.setEmail("teste" + System.currentTimeMillis() + "@qa.com");
        user.setAdministrador("true");

        return user;
    }
}



