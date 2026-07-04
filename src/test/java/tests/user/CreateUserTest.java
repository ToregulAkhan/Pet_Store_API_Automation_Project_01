package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import model.User;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends BaseTest {

    @Test
    public void postUser() {
        RestAssured
                .given()
                .spec(requestSpec)
                .body(new User(10, "theUser", "John", "James", "john@email.com", "12345", "12345", 1))
                .when()
                .post(Endpoints.USER)
                .then()
                .statusCode(200);
    }

    @Test
    public void postUserCreateWithList() {
        RestAssured
                .given()
                .spec(requestSpec)
                .body(Arrays.asList(new User(10, "theUser", "John", "James", "john@email.com", "12345", "12345", 1)))
                .when()
                .post(Endpoints.USER_CREATE_WITH_LIST)
                .then()
                .statusCode(200);
    }
}