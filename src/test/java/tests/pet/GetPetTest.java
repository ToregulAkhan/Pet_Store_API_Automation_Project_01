package tests.pet;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

import java.util.List;

public class GetPetTest {

    private static final Logger log = LoggerFactory.getLogger(GetPetTest.class);

    @Test
    public void getFindByStatus(){
        Response response = RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .queryParam("status", "sold")
                .when()
                    .get(Endpoints.PET_FIND_BY_STATUS);

        response.then().statusCode(200)
                .log().status()
                .log().body();

        //List<Pet> pets = response.as(new TypeRef<List<Pet>>() {});
        List<Pet> pets = response.jsonPath().getList("", Pet.class);
        Pet pet = pets.get(0);
        System.out.println(pet.getName() + "it is get name");
        System.out.println("------------------------------------------------------------------");

    }

    @Test
    public void getFindByTags(){
        Response response = RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .queryParam("tags", "tag1", "tag2", "tag3")
                .when()
                .get(Endpoints.PET_FIND_BY_TAGS);

        response.then().statusCode(200)
                .log().status();

        List<Pet> pets = response.jsonPath().getList("", Pet.class);
        Pet pet = pets.get(0);
        System.out.println("id: " + pet.getTags().get(0).getId());
        System.out.println("name: " + pet.getTags().get(0).getName());
        System.out.println("------------------------------------------------------------------");
    }

    @Test
    public void getPetById(){
        Response response= RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParams("petId", 10)
                .when()
                .get(Endpoints.PET_BY_ID);

        response.then().statusCode(200)
                .log().status()
                .log().body();

        Pet pets = response.jsonPath().getObject("", Pet.class);
        System.out.println("------------------------------------------------------------------");

    }
}
