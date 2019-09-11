package com.botscrew.testtask.service.util;

public final class StringUtil {

    public static String getKeyAfter(String sentence, String text) {
        String[] tokens = sentence.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(text) && tokens[i + 1] != null) return tokens[i + 1];
        }
        return null;
    }

    public static String getKeyBefore(String sentence, String text) {
        String[] tokens = sentence.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(text) && tokens[i - 1] != null) return tokens[i - 1];
        }
        return null;
    }
}
