package com.amk_community.amkexamen.utils;

import java.util.regex.Pattern;

/**
 * Created by Jordan on 06/09/2017.
 */

public class ValidateForm {
    private final static Pattern passwprdPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})");

    public static boolean isValidPassword(String pass) {
        return passwprdPattern.matcher(pass).matches();
    }
}
