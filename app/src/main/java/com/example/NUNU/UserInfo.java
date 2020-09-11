package com.example.NUNU;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class UserInfo {

    @PrimaryKey(autoGenerate = true) //id는 PrimaryKey로 지정해주며 자동으로 생성해줌
    public int id;
    public static String username;
    public static String greeting;
    public static String leftSight;
    public static String rightSight;

    public UserInfo(){

    }
    public UserInfo(int id, String username,String leftSight,String rightSight){
        this.id=id;
        this.username=username;
        this.leftSight=leftSight;
        this.rightSight=rightSight;

    }
    public UserInfo(String username, String leftSight, String rightSight) {
        this.username=username;
        this.leftSight=leftSight;
        this.rightSight=rightSight;
    }





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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                "name="+username+
                "leftsight="+leftSight+
                "rightSight="+rightSight+
                '}';
    }
}