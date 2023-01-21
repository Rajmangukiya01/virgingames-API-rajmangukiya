package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BingoSteps {

    @Step("Get all data from bingo lobby feed")
    public ValidatableResponse getDataOfBingoLobbyFeed() {
        return SerenityRest.given().log().all()
                .basePath(Path.BINGO)
                .when()
                .get(EndPoints.GET_ALL_DATA)
                .then()
                .statusCode(200);
    }
}
