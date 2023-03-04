package com.ata.chat;

public class PrivateGroup extends Group {
	private User admin;
	public PrivateGroup(String name, User admin) {
		super(name);
		this.admin = admin;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
	
}
