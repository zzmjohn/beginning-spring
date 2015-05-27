package com.wiley.beginningspring;

/**
 * Created by mertcaliskan
 * on 23/11/14.
 */
public class MyStringUtils {

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}