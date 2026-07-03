package tests.store;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Order;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class GetOrderTest {

    @Test
    public void getStoreOrderId(){
        Response response = RestAssured
                .given()
                .baseUri(ApiConstants.BASE_URL)
                .contentType(ApiConstants.CONTENT_TYPE)
                .pathParam("orderId", 10)
                .when()
                .get(Endpoints.STORE_ORDER_BY_ID);

        Order order = response.jsonPath().getObject("", Order.class);
        System.out.println("id: " + order.getId());
        System.out.println("petID: " + order.getPetId());
        System.out.println("quantity: " + order.getQuantity());
        System.out.println("shipDate: " + order.getShipDate());
        System.out.println("status: " + order.getStatus());
        System.out.println("complete: " + order.getComplete());
    }
}
