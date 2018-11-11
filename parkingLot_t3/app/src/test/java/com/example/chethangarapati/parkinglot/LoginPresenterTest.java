package com.example.chethangarapati.parkinglot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        presenter.setOnClickListener();

        verify(view).showUsernameError();
    }


    @Test
    public void ErrorWhenPasswordIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("usernm");
        when(view.getPassword()).thenReturn("");
        presenter.setOnClickListener();

        verify(view).showPasswordError();
    }

    @Test
    public void StartMainActivity() throws Exception{
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james","bond")).thenReturn(true);
        presenter.setOnClickListener();

        verify(view).showMainActivity();
    }

    @Test
    public void LoginError() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(false);
        presenter.setOnClickListener();

        verify(view).showLoginError();
    }
}