package com.googleclassroom.oauth2.pojo.coursespojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherFolder {
    @JsonProperty("id")
    public String getId() {
        return this.id; }
    public void setId(String id) {
        this.id = id; }
    String id;
}
