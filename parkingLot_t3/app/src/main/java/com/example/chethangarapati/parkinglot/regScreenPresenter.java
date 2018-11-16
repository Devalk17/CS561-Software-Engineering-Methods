package com.example.chethangarapati.parkinglot;

public class regScreenPresenter {

    private regScreenView view;
    private regScreenService service;

    public regScreenPresenter(regScreenView view, regScreenService service) {
        this.view = view;
        this.service = service;
    }

    public void setOnClickListener() {
        String username = view.getUsername();
        if (username.isEmpty()) {
            view.showUsernameError();
            return;
        }

        String password = view.getPassword();
        if (password.isEmpty()){
            view.showPasswordError();
            return;
        }
    }
}

