package com.ata.chat;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
	private String groupID;
	private String name;
	private ArrayList<User> users;
	private ArrayList<File> files;
	private boolean isPrivate;

	public Group(String name) {
		name = name;
		this.users = new ArrayList<>();
	}
	
	public String getGroupID() {
		return groupID;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void removeUser(User user) {
		this.users.remove(user);
	}
	public ArrayList<User> getUsers(){
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
