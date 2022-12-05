package com.googleclassroom.oauth2.enums;

public enum StatusCode {
    CODE_200(200, ""),
    CODE_201(201, ""),
    CODE_204(204, ""),
    CODE_400_EMPTY_NAME(400, "course.name: Course name must be specified."),
    CODE_401_INVALID_TOKEN(401, "[\"You do not have permission to create issues in this project.\"]"),
    CODE_400_EMPTY_SUMMARY(400, "{\"summary\":\"Operation value must be a string\"}"),

    CODE_404(404, "{\"errorMessages\":[\"Issue does not exist or you do not have permission to see it.\"],\"errors\":{}}");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
