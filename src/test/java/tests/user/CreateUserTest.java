package tests.user;

import io.restassured.RestAssured;
import model.User;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class CreateUserTest {

    @Test
    public void postUser(){
        RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .body(new User(10, "theUser", "John", "James", "john@email.com", "12345", "12345", 1))
                .when()
                .post(Endpoints.USER)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
