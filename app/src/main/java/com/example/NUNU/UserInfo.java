package com.example.NUNU;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class UserInfo {

    @PrimaryKey(autoGenerate = true) //id는 PrimaryKey로 지정해주며 자동으로 생성해줌
    public int id;
    public  String username;
    public  String greeting;
    public  String leftSight;
    public  String rightSight;

    public UserInfo(){

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

    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  String getGreeting() {
        return greeting;
    }

    public  void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public  String getLeftSight() {
        return leftSight;
    }

    public  void setLeftSight(String leftSight) {
        this.leftSight = leftSight;
    }

    public  String getRightSight() {
        return rightSight;
    }

    public  void setRightSight(String rightSight) {
        this.rightSight = rightSight;
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