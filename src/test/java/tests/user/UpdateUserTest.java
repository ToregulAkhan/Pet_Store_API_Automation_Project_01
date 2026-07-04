package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import model.User;
import org.testng.annotations.Test;
import utils.Endpoints;

public class UpdateUserTest extends BaseTest {

    @Test
    public void putUserName() {
        RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("username", "theUser")
                .body(new User(10, "theUser", "John", "James", "john@email.com", "12345", "12345", 1))
                .when()
                .put(Endpoints.USER_BY_NAME)
                .then()
                .statusCode(200);
    }
}