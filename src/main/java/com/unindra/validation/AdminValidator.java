package com.unindra.validation;

public class AdminValidator {

    public static String validate(String username, String password) {
        if (isNullOrEmpty(username) || isNullOrEmpty(password)) {
            return "Username atau Password tidak boleh kosong";
        }

        return null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
