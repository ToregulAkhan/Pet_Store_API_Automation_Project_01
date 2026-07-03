package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class GetUserTest {

    @Test
    public void getUserName(){
        Response response = RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParam("username", "theUser")
                .when()
                .get(Endpoints.USER_BY_NAME);

        User user = response.jsonPath().getObject("$", User.class);
        response.then().statusCode(200)
                .log().status()
                .log().body();
    }
}
