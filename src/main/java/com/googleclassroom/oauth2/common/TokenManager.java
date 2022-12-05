package com.googleclassroom.oauth2.common;


import com.googleclassroom.oauth2.util.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;

import static com.googleclassroom.oauth2.common.SpecBuilder.getRequestSpec;
import static com.googleclassroom.oauth2.common.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class TokenManager {

    protected static String bodyJson = "{\n" +
            "    \"client_id\": \"%s\",\n" +
            "    \"client_secret\": \"%s\",\n" +
            "    \"refresh_token\":\"%s\",\n" +
            "    \"grant_type\": \"%s\"\n" +
            "}";

    private static final String client_id= ConfigLoader.getInstance().getClientId();
    private static final String client_secret = ConfigLoader.getInstance().getClientSecret();
    private static final String refresh_token = ConfigLoader.getInstance().getRefreshToken();
    private static final String grant_type = ConfigLoader.getInstance().getGrantType();
    private static final String token_url = ConfigLoader.getInstance().getTokenUrl();

    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing token ...");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            } else{
                System.out.println("Token is good to use");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;
    }

    private static Response renewToken(){
        String body = String.format(bodyJson, client_id, client_secret, refresh_token, grant_type);

        Response response = given(getRequestSpec()).
                body(body).
                when().post(token_url).
                then().spec(getResponseSpec()).
                extract().
                response();

        if(response.statusCode() != 200){
            throw new RuntimeException("ABORT!!! Renew Token failed");
        }
        return response;
    }

}
