package tests.user;

import io.restassured.RestAssured;
import model.User;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

import java.util.Arrays;

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

    @Test
    public void postUserCreateWithList(){
        RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .body(Arrays.asList(new User(10, "theUser", "John", "James", "john@email.com", "12345", "12345", 1)))
                .when()
                .post(Endpoints.USER_CREATE_WITH_LIST)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
