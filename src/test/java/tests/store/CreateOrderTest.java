package tests.store;

import io.restassured.RestAssured;
import model.Order;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

import java.util.Date;

public class CreateOrderTest {

    @Test
    public void postStoreOrder(){
        Order order = new Order(10, 198772, 7, new Date(), "approved",true);
        RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .body(order)
                .when()
                    .post(Endpoints.STORE_ORDER)
                .then()
                    .statusCode(200)
                    .log().status()
                    .log().body();

    }
}
