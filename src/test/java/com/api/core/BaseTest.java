package com.api.core;

import com.api.utils.EvidenceLogger;
import com.api.utils.ReportGenerator;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://serverest.dev/#/";
    }

    @AfterEach
    void gerarRelatorio(TestInfo info) {
        ReportGenerator.gerar(info.getDisplayName(), EvidenceLogger.get());
        EvidenceLogger.clear();
    }
}
