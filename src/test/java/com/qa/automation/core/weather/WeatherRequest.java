package com.qa.automation.core.weather;

import com.qa.automation.core.utils.RequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherRequest {

    @Step("Verify location for the present weather response")
    public void verifyLocationInWeather(Response WeatherResp, String expectedLocation) {
        String WeatherLocation = WeatherResp.getBody().jsonPath().get("location.name").toString();
        assertThat(WeatherLocation).isEqualTo(expectedLocation);
    }

    @Step("Verify success status should be false for invalid location")
    public void verifySuccessStatusInWeatherForInvalidLocation(Response WeatherResp) {
        Boolean successStatus = WeatherResp.getBody().jsonPath().get("success");
        assertThat(successStatus).isEqualTo(false);
    }

    @Step("Verify error code and type for weather")
    public void verifyErrorCodeAndTypeForWeather(Response WeatherResp, String errorCode, String errorType) {
        String errorCodeActual = WeatherResp.getBody().jsonPath().get("error.code").toString();
        String errorTypeActual = WeatherResp.getBody().jsonPath().get("error.type");
        assertThat(errorCodeActual).isEqualTo(errorCode);
        assertThat(errorTypeActual).isEqualTo(errorType);
    }
}
