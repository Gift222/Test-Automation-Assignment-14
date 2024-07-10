package delivery.api;

import delivery.utils.ApiClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static delivery.spec.Specifications.getAuthenticatedRequestSpecification;

public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification(bearerToken));

        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        softly.assertThat(response.getContentType()).isEqualTo(ContentType.JSON.toString());
    }

    @Test
    void createOrderAndCheckResponse() {

        Response response = ApiClient.createOrder(getAuthenticatedRequestSpecification(bearerToken));

        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        softly.assertThat(response.getContentType()).isEqualTo(ContentType.JSON.toString());
        softly.assertThat(response.getBody().jsonPath().getString("STATUS")).isEqualTo("OPEN");
        softly.assertThat(response.getBody().jsonPath().getString("id")).isNotEmpty();
        softly.assertThat(response.getBody().jsonPath().getString("CustomerName")).isNotEmpty();
        softly.assertThat(response.getBody().jsonPath().getString("CustomerPhone")).isNotEmpty();
    }

    @Test
    void deleteOrderAndCheckStatusCode(Object orderId) {
        Response responseCreateOrder = ApiClient.createOrder(getAuthenticatedRequestSpecification(bearerToken),
                String bearerToken = responseCreatedOrder.getBody().jsonpath().getString("id");
        ApiClient.deleteOrder(getAuthenticatedRequestSpecification(bearerToken)orderId);
    }


}
