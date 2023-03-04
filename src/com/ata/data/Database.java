package com.ata.data;

import com.ata.chat.Group;
import com.ata.chat.User;

public class Database {
	
	private static Database instance = null;
	public Repository<User> users = new Repository<User>() {};
	
	public Repository<Group> groups = new Repository<Group>() {};
	
	public static synchronized Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	 public Repository<User> getUsers() {
	        return users;
	    }
}
