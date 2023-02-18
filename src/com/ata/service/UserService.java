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

	public void addUser(String username, String paasword) {
		
//		String password=hash_password.hashPass(user.getPassword());
//		user.setPassword(password);
//		data.users.add(user);
//		repositoryUser.add(user);
	}

	public boolean login(String userName, String password) {
		List<User> users = data.users.getEntity();
		for (int index = 0; index < users.size(); index++) {
			String userName2 = users.get(index).getUserName();
			String password2 = users.get(index).getPassword();
			if (userName2.equals(userName) && password2.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public User getFirst(String username,List<User> users) {
		int index;
		users = data.users.getEntity();
		for(index = 0; index < users.size(); index++) {
			if(users.get(index).getUserName().equals(username)) {
				break;
			}
		}
		return users.get(index);
	}
}
