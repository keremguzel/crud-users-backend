package com.example.kerem.entity.vm;

import com.example.kerem.entity.User;

public class UserVM {
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userGender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public UserVM(User user) {
        this.setUserName(user.getUserName());
        this.setUserSurname(user.getUserSurname());
        this.setUserEmail(user.getUserEmail());
        this.setUserGender(user.getUserGender());
    }
}
