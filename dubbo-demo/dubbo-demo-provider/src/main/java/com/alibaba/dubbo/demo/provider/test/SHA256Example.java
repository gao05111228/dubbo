package com.alibaba.dubbo.demo.provider.test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA256Example {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String originalString = "Hello, World!";
        byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println("----->"+encodedhash);
        String originalString1 = "Hello, 1World!";
        byte[] encodedhash1 = digest.digest(originalString1.getBytes(StandardCharsets.UTF_8));
        System.out.println("----->"+encodedhash1);
        String originalString2 = "Hello, 121World!";
        byte[] encodedhash2 = digest.digest(originalString2.getBytes(StandardCharsets.UTF_8));
        System.out.println("----->"+ Arrays.toString(encodedhash2));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
