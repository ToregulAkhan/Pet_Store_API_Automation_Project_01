package tests.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import model.Category;
import model.Pet;
import model.Tag;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatePetTest {

    @Test
    public void postPet(){
        Category category = new Category(1, "Dogs");
        //tag = new Tag(0, "string");
        List<String> url = Arrays.asList("string");
        List<Tag> tagList = Arrays.asList(new Tag(0, "string"));
        Pet pet = new Pet(10, "doggie", category, url, tagList, "available");

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
                    .body("id",equalTo(10))
                    .body("name", equalTo("doggie"))
                    .body("status", equalTo("available"));

    }
}
