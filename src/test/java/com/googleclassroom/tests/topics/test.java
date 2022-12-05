package com.googleclassroom.tests.topics;

import com.googleclassroom.oauth2.api.CoursesAPI;
import com.googleclassroom.oauth2.api.TopicAPI;
import com.googleclassroom.oauth2.common.RestResource;
import com.googleclassroom.oauth2.common.Route;
import com.googleclassroom.oauth2.common.TokenManager;
import com.googleclassroom.oauth2.enums.StatusCode;
import com.googleclassroom.oauth2.pojo.coursespojo.Courses;
import com.googleclassroom.oauth2.pojo.coursespojo.Topic;
import com.googleclassroom.oauth2.util.FakerUtils;
import com.googleclassroom.oauth2.util.Log;
import com.googleclassroom.tests.base.BaseTest;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test extends BaseTest {


    Response response;
    SoftAssert softAssert = new SoftAssert();
    String newCourseID;
    String newTopicID;
    String nameCourse = FakerUtils.generateCourseName();
    String nameTopic = FakerUtils.generateTopicName();
    String desc = FakerUtils.generateCourseDescriptionText();
    String ownerID = "me";

    Courses courses = Courses.coursesBuilder(nameCourse, desc, ownerID);


    @BeforeMethod
    public void createCourse(){
        Log.info("Step: Create course");
        response = CoursesAPI.createCourse(courses);
        JSONObject object = new JSONObject(response.getBody().asString());

        Log.step("Step: Get course id");
        newCourseID = object.getString("id");
        System.out.println(newCourseID);
    }

    Topic topic = Topic.builderTopic(newCourseID, nameTopic);

    @SneakyThrows
    @Test(description = "Verify course is created successfully using valid data")
    public void createATopicInCourseSuccessfullyTest(){
        RestResource.post(Route.COURSES + "/" + newCourseID + "/topics", TokenManager.getToken(), topic);
    }
}
