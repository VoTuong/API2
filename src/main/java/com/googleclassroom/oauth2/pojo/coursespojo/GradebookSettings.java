package com.googleclassroom.oauth2.pojo.coursespojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradebookSettings {
    @JsonProperty("calculationType")
    public String getCalculationType() {
        return this.calculationType; }
    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType; }
    String calculationType;
    @JsonProperty("displaySetting")
    public String getDisplaySetting() {
        return this.displaySetting; }
    public void setDisplaySetting(String displaySetting) {
        this.displaySetting = displaySetting; }
    String displaySetting;
}
