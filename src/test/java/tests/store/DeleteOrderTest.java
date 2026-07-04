package tests.store;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.Endpoints;

public class DeleteOrderTest extends BaseTest {

    @Test
    public void deleteStoreOrderId() {
        RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("orderId", 10)
                .when()
                .delete(Endpoints.STORE_ORDER_BY_ID)
                .then()
                .statusCode(200);
    }
}