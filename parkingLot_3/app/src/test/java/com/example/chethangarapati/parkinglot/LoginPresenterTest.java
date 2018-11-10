package com.example.chethangarapati.parkinglot;

import com.google.android.gms.auth.api.Auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception{

        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void ErrorWhenUserNameIsEmpty() throws Exception{

        when(view.getUsername()).thenReturn("");
        presenter.setOnClickListerer();

        verify(view).showUsernameError();
    }

    @Test
    public void ErrorWhenPasswordIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("usernm");
        when(view.getPassword()).thenReturn("");
        presenter.setOnClickListerer();

        verify(view).showPasswordError();
    }

    @Test
    public void StartMainActivity() throws Exception{
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james","bond")).thenReturn(true);
        presenter.setOnClickListerer();

        verify(view).showMainActivity();
    }

    @Test
    public void LoginError() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(false);
        presenter.setOnClickListerer();

        verify(view).showLoginError();
    }
}