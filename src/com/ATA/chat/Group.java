package com.ata.chat;
import java.util.ArrayList;

public abstract class Group extends BaseEntity {
	private String groupID;
	private String name;
	private ArrayList<User> users;
	private ArrayList<File> files;
	private ArrayList<Message> messages;
	private boolean isPrivate;

	public Group(String name) {
		this.name = name;
		this.users = new ArrayList<>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}
	public boolean removeUser(User user) {
		return this.users.remove(user);
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

	public String getGroupID() {
		return groupID;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

}
