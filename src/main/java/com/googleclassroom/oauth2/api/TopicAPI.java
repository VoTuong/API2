package com.googleclassroom.oauth2.api;

import com.googleclassroom.oauth2.common.RestResource;
import com.googleclassroom.oauth2.common.Route;
import com.googleclassroom.oauth2.common.TokenManager;
import com.googleclassroom.oauth2.pojo.coursespojo.Topic;
import com.googleclassroom.oauth2.util.Log;
import io.restassured.response.Response;

public class TopicAPI {

    public static Response createTopic(String courseID, Topic topic){
        Log.info("Creating new topic");
        return RestResource.post(Route.COURSES + "/" + courseID + "/topics", TokenManager.getToken(), topic);
    }

    public static Response getTopic(String courseID, String topicID){
        Log.info("Getting topic with topic id");
        return RestResource.get(Route.COURSES + "/" + courseID + "/topics/" + topicID, TokenManager.getToken());
    }

    public static Response deleteTopic(String courseID, String topicID){
        Log.info("Delete topic with topic id");
        return RestResource.delete(Route.COURSES + "/" + courseID + "/topics/" + topicID, TokenManager.getToken());
    }
}
