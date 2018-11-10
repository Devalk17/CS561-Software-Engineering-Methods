package com.example.chethangarapati.parkinglot;

public interface LoginView {
    String getUsername();

    void showUsernameError();

    String getPassword();

    void showPasswordError();

    void showMainActivity();

    void showLoginError();
}
