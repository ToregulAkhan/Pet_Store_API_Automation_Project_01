package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.Endpoints;

public class LogoutTest extends BaseTest {

    @Test
    public void getUserLogout() {
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.USER_LOGOUT)
                .then()
                .statusCode(200);
    }
}