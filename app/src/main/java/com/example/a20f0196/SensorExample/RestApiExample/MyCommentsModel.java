package com.example.a20f0196.SensorExample.RestApiExample;

public class MyCommentsModel {


    public static float postId;
    private  static float id;
    private static String name;
    private static String email;
    private static String body;




// Getter Methods



    public static float getPostId() {
        return postId;
    }

    public static float getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getBody() {
        return body;
    }

    // Setter Methods

    public void setPostId(float postId) {
        this.postId = postId;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }
}