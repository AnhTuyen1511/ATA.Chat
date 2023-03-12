package com.ata.service;

import java.util.ArrayList;
import java.util.List;

import com.ata.chat.User;
import com.ata.data.Database;

public class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public boolean addUser(String username, String password) {
        User existing = database.getUsers().getFirst(user -> user.getUserName().equals(username));
        if (existing != null) {
            return false;
        }

        User newUser = new User(username, password);
        database.getUsers().add(newUser);
        return true;
    }

    public boolean login(String username, String password) {
        User attemptedUser = database.getUsers().getFirst(user -> user.getUserName().equals(username));
        if (attemptedUser == null) {
            return false;
        }
        return attemptedUser.login(password);
    }

    public List<User> findUsersByUserName(String searchString) {
        List<User> matchingUsers = new ArrayList<>();
        List<User> users = database.getUsers().listEntities;
        for (User user : users) {
            if (user.getUserName().contains(searchString)) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }
}
