package com.ata.service;

import java.util.List;

import com.ata.chat.Hashing;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.Repository;

public class UserService {
	private final Database data;
	public Hashing hashPassword = new Hashing();

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

	public boolean login(String username, String password) {
		User attemptedUser = data.getUsers().getFirst(user -> user.getUserName().equals(username));
		if (attemptedUser == null) {
			return false;
		}
		return attemptedUser.login(password);
	}
}
