package com.naukma;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AuthenticationManager {
    private boolean isSecured;
    private Map<String, String> usersDatabase;

    public AuthenticationManager() {
        usersDatabase = new HashMap<>();
        Random rand = new Random();
        isSecured = rand.nextBoolean();
        usersDatabase.put("john_doe", "password123");
        usersDatabase.put("jane_smith", "pass456");
    }

    public boolean isValidUser(String username) {
        return usersDatabase.containsKey(username);
    }

    public boolean validateCredentials(String username, String password) {
        return usersDatabase.containsKey(username) && usersDatabase.get(username).equals(password);
    }

    public boolean isSecured() {
        return isSecured;
    }
}
