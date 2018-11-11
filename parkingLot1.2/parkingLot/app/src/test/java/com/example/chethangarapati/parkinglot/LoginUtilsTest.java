package com.example.chethangarapati.parkinglot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

//import org.junit.Test;

public class LoginUtilsTest {

    private LoginUtils utils;

    @Before
    public void setUp(){
      utils = new LoginUtils();
    }

    @Test
    public void aValidEmailAddressPasses() throws Exception {


        assertTrue(utils.isValidEmailAddress("abc@bar.com"));
    }

    @Test
    public void passwordLength() throws Exception {

    assertTrue(utils.getPasswordLength("enteredPassword")>8);
    }
}
