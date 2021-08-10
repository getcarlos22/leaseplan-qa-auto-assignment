package com.qa.automation.core.stepdef;

import com.qa.automation.core.utils.CommonRequest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Steps;

public class commonSteps {

    @Steps
    CommonRequest commonRequest;

   /* @When("I look up the present weather {word} for a city {word}")
    public void lookUpThePresentWeather(String presentWeather, String city){
        commonRequest.fetchLocationByWeatherAndCity(presentWeather,city);

    }

    @Then("The resulting location should be {} in {}")
    public void theResultingLocationShouldBe(String placeName, String city){
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LocationResponse.CITY, equalTo(city)));
        restAssuredThat(response -> response.body(LocationResponse.FIRST_PLACE_NAME, equalTo(placeName)));
    }*/

    @Then("response status should be OK")
    public void response_status_should_be_ok() {
        commonRequest.responseCodeIs(200, lastResponse());
    }

    @Then("the schema should match with the specification defined in \"(.*)\"")
    public void the_schema_should_match_with_the_specification(String spec) {
        commonRequest.verifyResponseSchema(lastResponse(), spec);
    }

}
