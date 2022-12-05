package com.googleclassroom.tests.courses;

import com.googleclassroom.oauth2.api.CoursesAPI;
import com.googleclassroom.oauth2.enums.StatusCode;
import com.googleclassroom.oauth2.pojo.coursespojo.Courses;
import com.googleclassroom.oauth2.util.FakerUtils;
import com.googleclassroom.oauth2.util.Log;
import com.googleclassroom.tests.base.BaseTest;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCaseUserIsAbleCreateANewCourseSuccessful extends BaseTest {

    Response response;
    SoftAssert softAssert = new SoftAssert();
    String newCourseID;
    String name = FakerUtils.generateCourseName();
    String desc = FakerUtils.generateCourseDescriptionText();
    String ownerID = "me";

    Courses courses = Courses.coursesBuilder(name, desc, ownerID);

    @SneakyThrows
    @Test(description = "Verify course is created successfully using valid data")
    public void createCourseSuccessfullyTest(){
        Log.step("Step 1: Create course");
        response = CoursesAPI.createCourse(courses);
        JSONObject object = new JSONObject(response.getBody().asString());

        Log.step("Step 2: Get course from course id");
        newCourseID = object.getString("id");
        response = CoursesAPI.getCourse(newCourseID);

        Log.step("Step 3: Verify points");
        softAssert.assertEquals(response.statusCode(), StatusCode.CODE_200.code);
        softAssert.assertEquals(response.getBody().path("name"), name);
        softAssert.assertEquals(response.getBody().path("description"), desc);

        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteCourse(){
        Log.info("Delete created course");
        response = CoursesAPI.deleteCourse(newCourseID);
    }

}
