package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.Endpoints;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserName() {
        RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("username", "theUser")
                .when()
                .delete(Endpoints.USER_BY_NAME)
                .then()
                .statusCode(200);
    }
}