package tests.user;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class DeleteUserTest {

    @Test
    public void deleteUserName(){
        RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParam("username", "theUser")
                .when()
                .delete(Endpoints.USER_BY_NAME)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
