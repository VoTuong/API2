package com.googleclassroom.oauth2.common;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://www.google.com").
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.HEADERS).
                log(LogDetail.BODY).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.HEADERS).
                log(LogDetail.BODY).
                build();
    }
}
