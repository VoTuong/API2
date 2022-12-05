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

public class TestCaseUserIsNotAbleCreateANewCourseWithoutCourseName extends BaseTest {

    Response response;
    SoftAssert softAssert = new SoftAssert();
    String newCourseID;
    String name = "";
    String desc = FakerUtils.generateCourseDescriptionText();
    String ownerID = "me";

    Courses courses = Courses.coursesBuilder(name, desc, ownerID);

    @SneakyThrows
    @Test(description = "Verify course is not created successfully using blank course name")
    public void createNewCourseWithoutCourseNameTest(){
        Log.step("Step 1: Create course");
        response = CoursesAPI.createCourse(courses);

        Log.step("Step 2: Verify points");
        softAssert.assertEquals(response.statusCode(), StatusCode.CODE_400_EMPTY_NAME.code);
        softAssert.assertEquals(response.getBody().path("error.message"), StatusCode.CODE_400_EMPTY_NAME.msg);

        softAssert.assertAll();
    }


}
