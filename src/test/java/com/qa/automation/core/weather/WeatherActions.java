package com.qa.automation.core.weather;

import com.qa.automation.core.utils.RequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherActions {

    @Step("Get present weather for location {0}")
    public Response getWeather(String location) {
        return SerenityRest.given().spec(RequestSpec.weatherReqSpec())
                .basePath("current")
                .queryParams("query", location)
                .get().then().extract().response();
    }
    @Step("Get present weather with blank access key")
    public Response getWeatherWithBlankAccessKey(String location) {
        return SerenityRest.given().spec(RequestSpec.weatherReqSpec())
                .basePath("current")
                .queryParams("query", location)
                .queryParams("access_key", "")
                .get().then().extract().response();
    }

    @Step("Get present weather with invalid access key")
    public Response getWeatherWithInvalidAccessKey(String location) {
        return SerenityRest.given().spec(RequestSpec.weatherReqSpec())
                .basePath("current")
                .queryParams("query", location)
                .queryParams("access_key", "xxxxxxxxxxxxxxx")
                .get().then().extract().response();
    }

}
