package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HealthTest {

    @Test
    public void checkHealth() {
        RestAssured.baseURI = "https://sportmarket-cart-service-production.up.railway.app";
        Response response = RestAssured
                .given()
                .when()
                .get("/health");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asPrettyString());
    }
}
