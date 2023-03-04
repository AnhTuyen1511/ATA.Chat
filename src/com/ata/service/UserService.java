package com.ata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ata.chat.HashPassword;
import java.util.List;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.Repository;

public class UserService {
	public Database data;

	public UserService(Database database) {
			data=database;
	}

	public List<User> findUsersByName(List<User> users, String searchString) {
	    List<User> matchingUsers = new ArrayList<>();
	    for (User user : users) {
	        if (user.getFirstName().contains(searchString)) {
	            matchingUsers.add(user);
	        }
	    }
	    return matchingUsers;
	}
	
	private String generateJoinCode() {
        String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(alphanumeric.length());
            sb.append(alphanumeric.charAt(index));
        }
        return sb.toString();
    }

	public boolean addUser(String username, String password) {
		User existing = data.getUsers().getFirst(user -> user.getUserName().equals(username));
		if (existing != null) {
			return false;
		}

		User newUser = new User(username, password);
		data.getUsers().add(newUser);
		return true;
	}

	public boolean login(String username, String password) {
		User attemptedUser = data.getUsers().getFirst(user -> user.getUserName().equals(username));
		if (attemptedUser == null) {
			return false;
		}
		return attemptedUser.login(password);
	}
}
