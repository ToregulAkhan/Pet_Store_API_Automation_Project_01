package tests.pet;

import base.BaseTest;
import io.restassured.RestAssured;
import model.Category;
import model.Pet;
import model.Tag;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;

public class UpdatePetTest extends BaseTest {

    @Test
    public void putPet() {
        Tag tag = new Tag(0, "string");
        Category category = new Category(1, "Dogs");
        Pet pet = new Pet(10, "doggie", category, Arrays.asList("string"), Arrays.asList(tag), "available");

        RestAssured
                .given()
                .spec(requestSpec)
                .body(pet)
                .when()
                .put(Endpoints.PET) // BUGFIX: was previously calling .post() by mistake
                .then()
                .statusCode(200)
                .body("id", equalTo(10))
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));
    }
}