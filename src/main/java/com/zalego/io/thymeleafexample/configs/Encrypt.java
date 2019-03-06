package com.zalego.io.thymeleafexample.configs;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public String EncryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest=MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(password.getBytes("UTF-8"));

            StringBuffer hexaString = new StringBuffer();
            for (byte h : hash){
                String hex = Integer.toHexString(0xff & h);
                if(hex.length()==1){
                   hexaString.append('0');
                }
                hexaString.append(hex);


            }
            return hexaString.toString();


    }
}
