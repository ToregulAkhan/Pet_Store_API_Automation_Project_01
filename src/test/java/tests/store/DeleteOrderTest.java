package tests.store;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ApiConstants;
import utils.Endpoints;

public class DeleteOrderTest {

    @Test
    public void deleteStoreOrderId(){
        RestAssured
                .given()
                    .baseUri(ApiConstants.BASE_URL)
                    .contentType(ApiConstants.CONTENT_TYPE)
                    .pathParam("orderId", 10)
                .when()
                    .delete(Endpoints.STORE_ORDER_BY_ID)
                .then()
                    .statusCode(200)
                    .log().status()
                    .log().body();
    }
}
