package com.example.chethangarapati.parkinglot;

public class UserDetails {

    private String userNickName;
    private String userEmail;
    private String userPhone;


    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public UserDetails(String userNickName, String userEmail, String userPhone) {
        this.userNickName = userNickName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }


}
