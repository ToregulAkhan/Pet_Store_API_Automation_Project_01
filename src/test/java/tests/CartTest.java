package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CartTest {

    @Test
    public void getCartTest(){
        Response response= RestAssured
                .given()
                .baseUri("https://sportmarket-cart-service-production.up.railway.app")
                .when()
                .get("/cart/3756");
        response.then().statusCode(200);
        System.out.println(response.statusCode());
        System.out.println(response.body().asPrettyString());
    }
}
