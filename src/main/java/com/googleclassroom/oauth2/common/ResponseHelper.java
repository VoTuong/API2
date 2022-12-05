package com.googleclassroom.oauth2.common;

import com.googleclassroom.oauth2.util.APIConstants;
import io.restassured.response.Response;

public class ResponseHelper {

    public static String getResponseNode(Response response, String nodePath) {
        return response.getBody().path(nodePath);
    }

    public static String getIssueKey(Response response) {
        return getResponseNode(response, APIConstants.ISSUE_KEY_NODE);
    }

    public static String getIssueId(Response response) {
        return getResponseNode(response, APIConstants.ISSUE_ID_NODE);
    }

    public static String getIssueSummaryGetResponse(Response response) {
        return getResponseNode(response, APIConstants.SUMMARY_NODE_OF_GET_RESPONSE);
    }

    public static String getIssueDescriptionGetResponse(Response response) {
        return getResponseNode(response, APIConstants.DESCRIPTION_NODE_OF_GET_RESPONSE);
    }

    public static String getErrorSummary(Response response) {
        return getResponseNode(response, APIConstants.ERROR_SUMMARY_NODE);
    }

}
