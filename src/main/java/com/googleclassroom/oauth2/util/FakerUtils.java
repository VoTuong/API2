package com.googleclassroom.oauth2.util;

import net.datafaker.Faker;

public class FakerUtils {

    public static String generateCourseName(){
        Faker faker = new Faker();
        return "Course " + faker.regexify("[0-9]{4}");
    }

    public static String generateTopicName(){
        Faker faker = new Faker();
        return "Topic " + faker.regexify("[0-9]{4}");
    }

    public static String generateCourseDescriptionText(){
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
