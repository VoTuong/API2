package com.googleclassroom.oauth2.pojo.coursespojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class Topic {
    @JsonProperty("courseId")
    public String getCourseId() {
        return this.courseId; }
    public void setCourseId(String courseId) {
        this.courseId = courseId; }
    String courseId;
    @JsonProperty("topicId")
    public String getTopicId() {
        return this.topicId; }
    public void setTopicId(String topicId) {
        this.topicId = topicId; }
    String topicId;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("updateTime")
    public String getUpdateTime() {
        return this.updateTime; }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime; }
    String updateTime;

    public static Topic builderTopic(String courseId, String name){
        return Topic.builder().
                courseId(courseId).
                name(name).
                build();
    }
}
