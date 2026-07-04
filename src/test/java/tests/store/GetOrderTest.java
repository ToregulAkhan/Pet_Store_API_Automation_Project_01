package tests.store;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Map;

public class GetOrderTest extends BaseTest {

    @Test
    public void getStoreOrderId() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("orderId", 10)
                .when()
                .get(Endpoints.STORE_ORDER_BY_ID);

        response.then().statusCode(200);

        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals(order.getId(), 10);
        Assert.assertNotNull(order.getStatus());
    }

    @Test
    public void getStoreInventory() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.STORE_INVENTORY);

        response.then().statusCode(200);

        Map<String, Integer> inventory = response.jsonPath().getMap("");
        Assert.assertFalse(inventory.isEmpty(), "Inventory response should not be empty");
    }
}