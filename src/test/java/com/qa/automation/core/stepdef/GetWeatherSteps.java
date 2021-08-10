package com.qa.automation.core.stepdef;

import com.qa.automation.core.utils.CommonRequest;
import com.qa.automation.core.weather.WeatherActions;
import com.qa.automation.core.weather.WeatherRequest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetWeatherSteps {

    @Steps
    WeatherActions weatherActions;

    @Steps
    WeatherRequest weatherRequest;

    @Steps
    CommonRequest commonRequest;


    @When("I call the get weather endpoint for location {}")
    public void i_call_the_get_weather_endpoint_for_location(String location) {
        weatherActions.getWeather(location);
    }

    @When("I call the get weather endpoint for location \"(.*)\" with blank access key")
    public void i_call_the_get_weather_endpoint_with_blank_access_key(String location) {
        weatherActions.getWeatherWithBlankAccessKey(location);
    }
    @When("I call the get weather endpoint for location \"(.*)\" with invalid access key")
    public void i_call_the_get_weather_endpoint_with_invalid_access_key(String location) {
        weatherActions.getWeatherWithInvalidAccessKey(location);
    }

    @Then("weather details should be retrieved")
    public void weather_details_should_be_retrieved() {
        commonRequest.responseCodeIs(200, lastResponse());
    }
    @And("the weather response should have details for location {}")
    public void the_weather_response_should_have_details_for_provided_location(String location) {
        weatherRequest.verifyLocationInWeather(lastResponse(), location);
    }

    @And("the weather response success status should be false")
    public void weather_success_status_should_be_false() {
        weatherRequest.verifySuccessStatusInWeatherForInvalidLocation(lastResponse());
    }

    @And("the weather response error code should be \"(.*)\" and error type should be \"(.*)\"")
    public void weather_error_code_and_type_should_be(String errorCode, String errorType) {
        weatherRequest.verifyErrorCodeAndTypeForWeather(lastResponse(), errorCode, errorType);
    }


}
