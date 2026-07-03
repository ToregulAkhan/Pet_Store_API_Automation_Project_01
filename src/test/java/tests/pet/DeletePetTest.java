package tests.pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class DeletePetTest {

    @Test
    public void deletePetId(){
        RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .header("api_key", "12345")
                    .pathParam("petId", 10)
                .when()
                    .delete(Endpoints.PET_BY_ID)
                .then()
                    .statusCode(200)
                    .log().status()
                    .log().body();
    }
}
