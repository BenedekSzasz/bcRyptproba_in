package com.example;
import org.mindrot.jbcrypt.BCrypt;
public class Main {
    public static void main(String[] args) {
        System.out.println("Start....!");

        String salt = BCrypt.gensalt(12);
        String hash = BCrypt.hashpw("titok", salt);
        System.out.println(hash);


        String inputPass = "titok";
        boolean isValid =BCrypt.checkpw(inputPass, hash);
        System.out.println(isValid);
    }
}