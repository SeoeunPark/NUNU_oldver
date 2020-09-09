package com.example.NUNU;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserInfo {

    @PrimaryKey(autoGenerate = true) //id는 PrimaryKey로 지정해주며 자동으로 생성해줌
    private int id;
    public static String username;
    public static String greeting;
    public static String leftSight;
    public static String rightSight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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