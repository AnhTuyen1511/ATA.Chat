package com.ata.data;

import com.ata.chat.User;
import com.ata.repositories.InMemoryRepository;
import com.ata.chat.Group;
import com.ata.chat.Message;

public class InMemoryDatabase extends Database {
	private static InMemoryDatabase database;

	private InMemoryDatabase() {
		users = new InMemoryRepository<User>();
		groups = new InMemoryRepository<Group>();
		messages = new InMemoryRepository<Message>();
	}

	public static InMemoryDatabase getInstance() {
		if (database == null) {
			database = new InMemoryDatabase();
		}
		return database;
	}
}
