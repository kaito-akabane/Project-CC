package com.example.ProjectCC.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    static final String salt = "094473248500e2a224d4cf445ba932160c99ac21";
    public static String encrypt(String pw) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((pw+salt).getBytes());
            byte[] digest = md.digest();
            for(byte b : digest)
                sb.append(String.format("%02X", b));
            return sb.toString();
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
