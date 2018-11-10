package com.example.chethangarapati.parkinglot;

public class LoginUtils {

    /**
     * checks if provided email id has is valid and returns true if it is
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){

        boolean hasAtSign = email.indexOf("@") > -1;

        return hasAtSign;
    }

    /**
     * returns length of password to check minimum legth of password.
     * @param passwd
     * @return
     */
    public int getPasswordLength(String passwd){

        return passwd.length();
    }
}
