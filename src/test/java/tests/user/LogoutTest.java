package tests.user;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class LogoutTest {

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
