package com.ata.chat;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
	private String name;
	private ArrayList<User> users;
	
	public Group(String name) {
		name = name;
		this.users = new ArrayList<>();
	}
	public void addUser(User user) {
		this.users.add(user);
	}
	public ArrayList<User> getUsers(){
		return this.users;
	}
	public String getName() {
		return name;
	}
	
}
