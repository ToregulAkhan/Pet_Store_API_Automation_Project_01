package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class LoginTest {

    @Test
    public void getUserLogin(){
        Response response = RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParam("username", "theUser")
                .when()
                .get(Endpoints.USER_BY_NAME);

        User user = response.jsonPath().getObject("$", User.class);

        RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .queryParam("username", user.getUsername())
                .queryParam("password", user.getPassword())
                .when()
                .get(Endpoints.USER_LOGIN)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
