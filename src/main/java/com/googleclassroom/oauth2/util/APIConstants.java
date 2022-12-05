package com.googleclassroom.oauth2.util;


public class APIConstants {
    public static String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    public static String ACCESS_TOKEN;
    public static String AUTHORIZATION;
    public static String CLOUD_ID;
    public static String PROJECT_KEY = "API";
    public static String ISSUE_NAME = "Task";

    public static final String ISSUE_KEY_NODE = "key";
    public static final String ISSUE_ID_NODE = "id";
    public static final String SUMMARY_NODE_OF_GET_RESPONSE = "fields.summary";
    public static final String DESCRIPTION_NODE_OF_GET_RESPONSE = "fields.description.content[0].content[0].text";
    public static final String ERROR_SUMMARY_NODE = "errors.summary";
}
