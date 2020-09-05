package com.example.NUNU;

public class Greeting {
    String username;
    String greeting;

    public Greeting(String username){
        this.username = "박서빈";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
