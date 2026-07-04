package tests.user;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

public class GetUserTest extends BaseTest {

    @Test
    public void getUserName() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("username", "theUser")
                .when()
                .get(Endpoints.USER_BY_NAME);

        response.then().statusCode(200);

        User user = response.jsonPath().getObject("$", User.class);
        Assert.assertEquals(user.getUsername(), "theUser");
    }
}