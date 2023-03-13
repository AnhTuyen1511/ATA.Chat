package com.ata.service;

import java.util.ArrayList;
import java.util.List;

import com.ata.chat.User;
import com.ata.data.Database;

public class UserService {

	private final Database data;

	public UserService(Database database) {
		data = database;
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

	public List<User> findUsersByUserName(String searchString) {
		List<User> matchingUsers = new ArrayList<>();
		List<User> users = data.users.getListEntities();
		for (User user : users) {
			if (user.getUserName().contains(searchString)) {
				matchingUsers.add(user);
			}
		}
		return matchingUsers;
	}

	public boolean login(String username, String password) {
		User attemptedUser = data.getUsers().getFirst(user -> user.getUserName().equals(username));
		if (attemptedUser == null) {
			return false;
		}
		return attemptedUser.login(password);
	}
}
