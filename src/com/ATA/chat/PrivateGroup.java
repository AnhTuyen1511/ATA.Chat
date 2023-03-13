package com.ata.chat;

public class PrivateGroup extends Group {
	private User admin;
	public PrivateGroup(String name, boolean isPrivate) {
		super(name);
		isPrivate = isPrivate;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
}
