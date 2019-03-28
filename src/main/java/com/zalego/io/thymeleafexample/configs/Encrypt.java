package com.zalego.io.thymeleafexample.configs;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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

    public String encryptData(String hash,String value){

        // hash values has 64 characters

        String hash0 = hash.substring(0,23);
        String hash1 = hash.substring(45,63);
        String encrypt_val = Base64.getEncoder().
                encodeToString(value.getBytes());
        System.out.println(hash0);
        System.out.println(hash1);
        return hash1+hash0+encrypt_val;
    }
    public String decryptData(String value){
        String v = value.substring(41);

        byte[] d = Base64.getDecoder().decode(v);
       return new String(d);
    }
}
