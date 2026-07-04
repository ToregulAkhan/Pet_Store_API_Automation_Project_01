package tests.store;

import base.BaseTest;
import io.restassured.RestAssured;
import model.Order;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class CreateOrderTest extends BaseTest {

    @Test
    public void postStoreOrder() {
        Order order = new Order(10, 198772, 7, new Date(), "approved", true);

        RestAssured
                .given()
                .spec(requestSpec)
                .body(order)
                .when()
                .post(Endpoints.STORE_ORDER)
                .then()
                .statusCode(200)
                .body("id", equalTo(10))
                .body("petId", equalTo(198772))
                .body("status", equalTo("approved"));
    }
}