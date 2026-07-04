package tests.pet;

import base.BaseTest;
import io.restassured.RestAssured;
import model.Category;
import model.Pet;
import model.Tag;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class CreatePetTest extends BaseTest {

    @Test
    public void postPet() {
        Category category = new Category(1, "Dogs");
        List<String> photoUrls = Arrays.asList("string");
        List<Tag> tagList = Arrays.asList(new Tag(0, "string"));
        Pet pet = new Pet(10, "doggie", category, photoUrls, tagList, "available");

        RestAssured
                .given()
                .spec(requestSpec)
                .body(pet)
                .when()
                .post(Endpoints.PET)
                .then()
                .statusCode(200)
                .body("id", equalTo(10))
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));
    }

    @Test
    public void postPetId() {
        RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("petId", 10)
                .queryParam("name", "doggie")
                .queryParam("status", "available")
                .when()
                .post(Endpoints.PET_BY_ID)
                .then()
                .statusCode(200)
                .body("message", equalTo("10"));
    }

    @Test
    public void postPetIdUploadImage() {
        // Image lives in src/test/resources so the test doesn't depend on a local machine path.
        File image = new File(getClass().getClassLoader().getResource("pet-image.png").getFile());

        RestAssured
                .given()
                .baseUri(utils.ApiConstants.BASE_URL)
                .pathParam("petId", 10)
                .queryParam("additionalMetadata", "any name for image")
                .multiPart("file", image)
                .when()
                .post(Endpoints.PET_UPLOAD_IMAGE)
                .then()
                .statusCode(200)
                .body("code", equalTo(200));
    }
}