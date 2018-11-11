package com.example.chethangarapati.parkinglot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class regScreenPresenterTest {

    @Mock
    private regScreenView view;
    @Mock
    private regScreenService service;
    private regScreenPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new regScreenPresenter(view, service);
    }

    @Test
    public void CheckUserNameIsEmpty() throws Exception{

        when(view.getUsername()).thenReturn("");
        presenter.setOnClickListener();

        verify(view).showUsernameError();
    }

    @Test
    public void CheckPasswordIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("usernm");
        when(view.getPassword()).thenReturn("");
        presenter.setOnClickListener();

        verify(view).showPasswordError();
    }

    @Test
    public void CheckPhnoIsEmpty() throws Exception{

        when(view.getPhno()).thenReturn("");
        presenter.setOnClickListener();

        verify(view).showNoPhnoError();
    }
//
//    @Test
//    public void ChecknickNameIsEmpty() throws Exception{
//
//        when(view.getUsername()).thenReturn("");
//        presenter.setOnClickListener();
//
//        verify(view).showUsernameError();
//    }
}