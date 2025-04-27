package com.unindra.validation;

import java.util.regex.Pattern;

import com.unindra.model.request.TeacherRequest;

public class TeacherValidator {

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static String validate(TeacherRequest request) {
        if (isNullOrEmpty(request.getName())) {
            return "Nama harus diisi.";
        }

        if (isNullOrEmpty(request.getId())) {
            return "ID harus diisi.";
        } else if (request.getId().length() != 16) {
            return "ID harus terdiri dari 16 digit.";
        }

        if (isNullOrEmpty(request.getBirthPlace())) {
            return "Tempat lahir harus diisi.";
        }

        if (request.getBirthDate() == null) {
            return "Tanggal lahir harus diisi.";
        }

        if (isNullOrEmpty(request.getGender())) {
            return "Jenis kelamin harus diisi.";
        }

        if (isNullOrEmpty(request.getAddress())) {
            return "Alamat harus diisi.";
        }

        if (isNullOrEmpty(request.getPhoneNumber())) {
            return "Nomor telepon harus diisi.";
        } else if (!request.getPhoneNumber().startsWith("08")) {
            return "Nomor telepon harus dimulai dengan 08.";
        }

        if (isNullOrEmpty(request.getEmail())) {
            return "Email harus diisi.";
        } else if (!EMAIL_PATTERN.matcher(request.getEmail()).matches()) {
            return "Format email tidak valid.";
        }

        return null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
