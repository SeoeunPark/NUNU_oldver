package com.example.NUNU;

public class UserInfo {
    public static String username;
    public static String greeting;
    public static String leftSight;
    public static String rightSight;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserInfo.username = username;
    }

    public static String getGreeting() {
        return greeting;
    }

    public static void setGreeting(String greeting) {
        UserInfo.greeting = greeting;
    }

    public static String getLeftSight() {
        return leftSight;
    }

    public static void setLeftSight(String leftSight) {
        UserInfo.leftSight = leftSight;
    }

    public static String getRightSight() {
        return rightSight;
    }

    public static void setRightSight(String rightSight) {
        UserInfo.rightSight = rightSight;
    }
}