package com.example.chethangarapati.parkinglot;

public class LoginPresenter {

    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) {

        this.view = view;
        this.service = service;
    }

    public void setOnClickListener() {
        String username = view.getUsername();
        if (username.isEmpty()){
            view.showUsernameError();
            return;
        }

        String password = view.getPassword();
        if (password.isEmpty()){
            view.showPasswordError();
            return;
        }

        boolean loginSuccess = service.login(username, password);
        if (loginSuccess){
            view.showMainActivity();
            return;
        }
        view.showLoginError();
    }

}
