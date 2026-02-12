package com.api.utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ApiLogFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification req,
                           FilterableResponseSpecification res,
                           FilterContext ctx) {

        long start = System.currentTimeMillis();

        Response response = ctx.next(req, res);

        long time = System.currentTimeMillis() - start;

        EvidenceLogger.log(
                "REQUEST:\n" +
                        req.getMethod() + " " + req.getURI() +
                        "\nHeaders: " + req.getHeaders() +
                        "\nBody: " + req.getBody()
        );

        EvidenceLogger.log(
                "RESPONSE:\nStatus: " + response.statusCode() +
                        "\nTempo: " + time + "ms" +
                        "\nBody: " + response.getBody().asPrettyString()
        );

        return response;
    }
}
