package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.annotations.Test;
import utils.Endpoints;

public class LoginTest extends BaseTest {

    @Test
    public void getUserLogin() {
        Response userResponse = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("username", "theUser")
                .when()
                .get(Endpoints.USER_BY_NAME);

        User user = userResponse.jsonPath().getObject("$", User.class);

        RestAssured
                .given()
                .spec(requestSpec)
                .queryParam("username", user.getUsername())
                .queryParam("password", user.getPassword())
                .when()
                .get(Endpoints.USER_LOGIN)
                .then()
                .statusCode(200);
    }
}