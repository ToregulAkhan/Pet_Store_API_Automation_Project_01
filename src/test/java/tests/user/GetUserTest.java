package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class GetUserTest {
    User user;

    @Test
    public void getUserName(){
        Response response = RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParam("username", "theUser")
                .when()
                .get(Endpoints.USER_BY_NAME);

        user = response.jsonPath().getObject("$", User.class);
        response.then().statusCode(200)
                .log().status()
                .log().body();
    }

    @Test(dependsOnMethods = "getUserName")
    public void getUserLogin(){
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

    @Test
    public void getUserLogout(){
        RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .when()
                .get(Endpoints.USER_LOGOUT)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
