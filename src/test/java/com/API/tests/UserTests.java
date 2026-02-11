package com.API.tests;

import com.API.base.BaseTest;
import com.API.client.UserClient;
import com.API.model.User;
import com.API.utils.EvidenceLogger;
import com.API.utils.ReportManager;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests extends BaseTest {

    UserClient client = new UserClient();

    @Test
    void createUserTest(){

        User user = new User("Marco", "marco"+System.currentTimeMillis()+"@mail.com");

        Response response = client.createUser(user);

        EvidenceLogger.log("Criar usuário", response.statusCode(), response.asPrettyString());

        assertEquals(201,response.statusCode());
    }

    @AfterEach
    void report(){
        ReportManager.generate("UserTest");
    }
}
