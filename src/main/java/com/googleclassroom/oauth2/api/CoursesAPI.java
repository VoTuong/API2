package com.googleclassroom.oauth2.api;

import com.googleclassroom.oauth2.common.RestResource;
import com.googleclassroom.oauth2.common.Route;
import com.googleclassroom.oauth2.common.TokenManager;
import com.googleclassroom.oauth2.pojo.coursespojo.Courses;
import com.googleclassroom.oauth2.util.Log;
import io.restassured.response.Response;

public class CoursesAPI {


    public static Response createCourse(Courses courses){
        Log.info("Creating new Courses");
        return RestResource.post(Route.COURSES, TokenManager.getToken(), courses);
    }

    public static Response getCourse(String courseID){
        Log.info("Getting course with course id");
        return RestResource.get(Route.COURSES + "/" + courseID, TokenManager.getToken());
    }

    public static Response deleteCourse(String courseID){
        Log.info("Delete course with course id");
        return RestResource.delete(Route.COURSES + "/" + courseID, TokenManager.getToken());
    }

}
