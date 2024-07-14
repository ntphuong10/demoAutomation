package org.example.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.example.utils.ConstantComponent.*;

import java.util.HashMap;
import java.util.Map;

public class BaseAPI {
    public Map<String, String> getHeader(String token) {
        Map<String, String> headers = new HashMap<>();
        if (!token.isEmpty()) {
            headers.put(AUTHORIZATION, token);
        }
        return headers;
    }

    public Response getAPI(String baseURL, String token) {
        return SerenityRest.given().
                contentType(ContentType.JSON)
                .baseUri(baseURL)
                .log()
                .all()
                .when()
                .get()
                .prettyPeek();
    }

    public Response getAPI(String baseURL, String token, Map<String, String> param) {
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers(getHeader(token))
                .baseUri(baseURL)
                .formParams(param)
                .when()
                .log()
                .all()
                .get()
                .prettyPeek();

    }

    public Response postAPI(String baseURL, String basePath, String token, Object body) {
        return SerenityRest.given()
                .headers(getHeader(token))
                .baseUri(baseURL)
                .basePath(basePath)
                .when()
                .body(body)
                .post()
                .prettyPeek();
    }

    public Response postAPI(String baseURL, String basePath, Object body) {
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .baseUri(baseURL)
                .basePath(basePath)
                .when()
                .body(body)
                .log()
                .all()
                .post()
                .prettyPeek();
    }

    public Response putAPI(String baseURL, String basePath, Object body) {
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .baseUri(baseURL)
                .basePath(basePath)
                .when()
                .body(body)
                .log()
                .all()
                .post()
                .prettyPeek();
    }
}
