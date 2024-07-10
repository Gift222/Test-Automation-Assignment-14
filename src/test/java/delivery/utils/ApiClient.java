package delivery.utils;

import com.google.gson.Gson;
import delivery.api.BaseSetupApi;
import delivery.dto.LoginDto;
import delivery.dto.orderDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ApiClient extends BaseSetupApi {
    public static Response getOrders(RequestSpecification spec) {

        return given()
                .spec(spec)
                .log()
                .all()
                .get("orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response createOrder(RequestSpecification spec) {
        Gson gson = new Gson();
        orderDto requestOrder = new orderDto(new orderDto("Gift", "0987878", "Take a taxi");

        return given()
                .spec(spec)
                .log()
                .all()
                .body(gson.toJson(requestOrder))
                .post("orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static void deleteOrder(RequestSpecification spec, String orderId) {
        given()
                .spec(spec)
                .log()
                .all()
                .delete("orders/" + orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

    }

    public static String authorizeAndGetToken(String username, String password) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(new LoginDto(username, password)))
                .post("login/student")
                .then()
                .log()
                .all()
                .extract()
                .response()
                .asString();
    }


}