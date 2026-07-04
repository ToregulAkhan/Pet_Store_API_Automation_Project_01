package tests.pet;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.Endpoints;

import static org.hamcrest.Matchers.equalTo;

public class DeletePetTest extends BaseTest {

    @Test
    public void deletePetId() {
        RestAssured
                .given()
                .spec(requestSpec)
                .header("api_key", "12345")
                .pathParam("petId", 10)
                .when()
                .delete(Endpoints.PET_BY_ID)
                .then()
                .statusCode(200);
    }
}