package com.qa.automation.core.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class RequestSpec {
    /**
     * Get Request Specification for weather endpoint
     *
     * @return RequestSpecification
     */
    public static RequestSpecification weatherReqSpec() {
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);

        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("baseurl");

        String authToken = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("authToken");

        return new RequestSpecBuilder().setBaseUri(baseUrl)
                .setContentType("application/json")
                .addQueryParam("access_key", authToken)
                .build();
    }
}
