package tests.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class GetPetTest {

    private static final Logger log = LoggerFactory.getLogger(GetPetTest.class);

    @Test
    public void getFindByStatus(){
        RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .queryParam("status", "sold")
                .when()
                    .get(Endpoints.PET_FIND_BY_STATUS)
                .then()
                    .statusCode(200)
                    .log().status()
                    .log().body();

    }
}
