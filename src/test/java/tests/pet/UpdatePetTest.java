package tests.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Category;
import model.Pet;
import model.Tag;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

import java.util.ArrayList;
import java.util.Arrays;

public class UpdatePetTest {

    @Test
    public void putPet(){
        Tag tag = new Tag(0, "string");
        Category category = new Category(1, "Dogs");
        Pet pet = new Pet(10, "doggie", category, Arrays.asList("string"), Arrays.asList(tag), "available");

        RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .body(pet)
                .when()
                    .post(Endpoints.PET)
                .then()
                    .statusCode(200)
                    .log().status()
                    .log().body();

    }
}
