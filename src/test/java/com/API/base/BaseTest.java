package com.API.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    @BeforeAll
    static void setup() throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config.properties"));

        RestAssured.baseURI = prop.getProperty("base.url");
    }
}
