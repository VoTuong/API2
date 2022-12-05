package com.googleclassroom.oauth2.common;

import io.restassured.response.Response;

import static com.googleclassroom.oauth2.common.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, Object requestBody){
        return given(getRequestSpec()).
                body(requestBody).
                auth().oauth2(token).
        when().post(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String token){
        return given(getRequestSpec()).
                auth().oauth2(token).
        when().get(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, Object updateIssue){
        return given(getRequestSpec()).
                auth().oauth2(token).
                body(updateIssue).
        when().put(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response delete(String path, String token){
        return given(getRequestSpec()).
                auth().oauth2(token).
                when().delete(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}
