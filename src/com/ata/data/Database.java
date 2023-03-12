package com.ata.data;

import com.ata.chat.Group;
import com.ata.chat.Message;
import com.ata.chat.User;
import com.ata.repositories.Repository;

public abstract class Database {
	public Repository<User> users;
	public Repository<Group> groups;
	public Repository<Message> messages;

	public Repository<User> getUsers() {
		return users;
	}

	public Repository<Group> getGroups() {
		return groups;
	}

	public Repository<Message> getMessages() {
		return messages;
	}
}
