package tests.pet;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.List;

public class GetPetTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(GetPetTest.class);

    @Test
    public void getFindByStatus() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .queryParam("status", "sold")
                .when()
                .get(Endpoints.PET_FIND_BY_STATUS);

        response.then().statusCode(200);

        List<Pet> pets = response.jsonPath().getList("", Pet.class);
        Assert.assertFalse(pets.isEmpty(), "Expected at least one pet with status 'sold'");
        pets.forEach(pet -> Assert.assertEquals(pet.getStatus(), "sold"));

        log.info("First pet found: {}", pets.get(0).getName());
    }

    @Test
    public void getFindByTags() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .queryParam("tags", "tag1", "tag2", "tag3")
                .when()
                .get(Endpoints.PET_FIND_BY_TAGS);

        response.then().statusCode(200);

        List<Pet> pets = response.jsonPath().getList("", Pet.class);
        Assert.assertFalse(pets.isEmpty(), "Expected at least one pet for the given tags");

        log.info("Tag id: {}, name: {}", pets.get(0).getTags().get(0).getId(), pets.get(0).getTags().get(0).getName());
    }

    @Test
    public void getPetById() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParams("petId", 10)
                .when()
                .get(Endpoints.PET_BY_ID);

        response.then().statusCode(200);

        Pet pet = response.jsonPath().getObject("", Pet.class);
        Assert.assertEquals(pet.getId(), 10);
        Assert.assertEquals(pet.getName(), "doggie");
    }
}