package tests.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class GetPetTest {

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
                    .log().all();

    }
}
