package com.digdes.school.phonebook.config;

public class StoreConfig {

    private static String currentStore = null;

    public static String getStorePath() {
        return currentStore;
    }

    public static void setStorePath(String path) {
        currentStore = path;
    }
}
