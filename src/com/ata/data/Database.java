package com.ata.data;

import com.ata.chat.Group;
import com.ata.chat.Message;
import com.ata.chat.User;

public class Database {
	private static Database instance = null;

	public Repository<User> users = new Repository<User>() {
	};
	public Repository<Group> groups = new Repository<Group>() {
	};
	public Repository<Message> messages = new Repository<Message>() {
	};

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public Repository<User> getUsers() {
		return users;
	}
	
	public Repository<Group> getGroups(){
		return groups;
	}
	public Repository<Message> getMessages(){
		return messages;
	}
}
