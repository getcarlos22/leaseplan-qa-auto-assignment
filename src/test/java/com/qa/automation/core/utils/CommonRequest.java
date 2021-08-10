package com.qa.automation.core.utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class CommonRequest {

    @Step("Verify that API response is {0}")
    public void responseCodeIs(int responseCode, Response lastResponse) {
        assertThat(lastResponse.statusCode()).isEqualTo(responseCode);
    }

    @Step("Verify response schema with {1}")
    public void verifyResponseSchema(Response lastResponse, String schemaJson) {
        lastResponse.then().body(matchesJsonSchemaInClasspath("schema/" + schemaJson));
    }
}
