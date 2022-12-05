package com.googleclassroom.oauth2.pojo.coursespojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Jacksonized
@Builder
public class Courses {

    @JsonProperty("id")
    public String getId() {
        return this.id; }
    public void setId(String id) {
        this.id = id; }
    String id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public void setDescription(String description) {
        this.description = description; }
    String description;
    @JsonProperty("ownerId")
    public String getOwnerId() {
        return this.ownerId; }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId; }
    String ownerId;
    @JsonProperty("creationTime")
    public Date getCreationTime() {
        return this.creationTime; }
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime; }
    Date creationTime;
    @JsonProperty("updateTime")
    public Date getUpdateTime() {
        return this.updateTime; }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime; }
    Date updateTime;
    @JsonProperty("enrollmentCode")
    public String getEnrollmentCode() {
        return this.enrollmentCode; }
    public void setEnrollmentCode(String enrollmentCode) {
        this.enrollmentCode = enrollmentCode; }
    String enrollmentCode;
    @JsonProperty("courseState")
    public String getCourseState() {
        return this.courseState; }
    public void setCourseState(String courseState) {
        this.courseState = courseState; }
    String courseState;
    @JsonProperty("alternateLink")
    public String getAlternateLink() {
        return this.alternateLink; }
    public void setAlternateLink(String alternateLink) {
        this.alternateLink = alternateLink; }
    String alternateLink;
    @JsonProperty("teacherGroupEmail")
    public String getTeacherGroupEmail() {
        return this.teacherGroupEmail; }
    public void setTeacherGroupEmail(String teacherGroupEmail) {
        this.teacherGroupEmail = teacherGroupEmail; }
    String teacherGroupEmail;
    @JsonProperty("courseGroupEmail")
    public String getCourseGroupEmail() {
        return this.courseGroupEmail; }
    public void setCourseGroupEmail(String courseGroupEmail) {
        this.courseGroupEmail = courseGroupEmail; }
    String courseGroupEmail;
    @JsonProperty("teacherFolder")
    public TeacherFolder getTeacherFolder() {
        return this.teacherFolder; }
    public void setTeacherFolder(TeacherFolder teacherFolder) {
        this.teacherFolder = teacherFolder; }
    TeacherFolder teacherFolder;
    @JsonProperty("guardiansEnabled")
    public boolean getGuardiansEnabled() {
        return this.guardiansEnabled; }
    public void setGuardiansEnabled(boolean guardiansEnabled) {
        this.guardiansEnabled = guardiansEnabled; }
    boolean guardiansEnabled;
    @JsonProperty("gradebookSettings")
    public GradebookSettings getGradebookSettings() {
        return this.gradebookSettings; }
    public void setGradebookSettings(GradebookSettings gradebookSettings) {
        this.gradebookSettings = gradebookSettings; }
    GradebookSettings gradebookSettings;

    public static Courses coursesBuilder(String name, String description, String ownerId){
        return Courses.builder().
                name(name).
                description(description).
                ownerId(ownerId).build();
    }
}
