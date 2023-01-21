package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.BingoSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs {
    static ValidatableResponse response;
    String streamName;
    @Steps
    BingoSteps bingoSteps;

    @When("^I can send Get request to the Lobby feed endpoint$")
    public void iCanSendGetRequestToTheLobbyFeedEndpoint() {
        response = bingoSteps.getDataOfBingoLobbyFeed();
        streamName = response.extract().jsonPath().get("bingoLobbyInfoResource.streams[6].streamName");
    }

    @And("^I get Valid Status code is \"([^\"]*)\"$")
    public void iGetValidStatusCodeIs(int statusCode) {
        response.statusCode(statusCode);
    }

    @Then("^I can verify streamName is \"([^\"]*)\"$")
    public void iCanVerifyStreamNameIs(String name) {
        Assert.assertEquals("stream name is not displayed", name, streamName);
    }
}
