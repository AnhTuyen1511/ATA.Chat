package com.ata.chat;

import java.util.ArrayList;

public abstract class Group {
	private String name;
	private ArrayList<User> users;
	private ArrayList<File> files;
	private boolean isPrivate;

	public Group(String name) {
		name = name;
		this.users = new ArrayList<>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public String getName() {
		return name;
	}

	public ArrayList<File> getFiles() {
		return this.files;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

}
