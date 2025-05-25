package com.project1.Models;

public class PlayerProfile {
    private String username;
    private String password;
    private String answerSecurityQuestion;
    private String avatarPath;

    //having no args constructor(default) is necessary to load from json a class
    //also having getter and setter and do not be final is necessary too

    public PlayerProfile() {
    }

    public PlayerProfile(String username, String password,
                         String answerSecurityQuestion) {
        this.username = username;
        this.password = password;
        this.answerSecurityQuestion = answerSecurityQuestion;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAnswerSecurityQuestion(String answerSecurityQuestion) {
        this.answerSecurityQuestion = answerSecurityQuestion;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAnswerSecurityQuestion() {
        return answerSecurityQuestion;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getAvatarPath() {
        return avatarPath;
    }
}
