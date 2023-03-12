package com.ata.chat;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
	private String name;
	private ArrayList<User> users;
	private ArrayList<File> files;
	private ArrayList<Message> messages;
	private boolean isPrivate;

	public Group(String name) {
		name = name;
		this.users = new ArrayList<>();
		messages= new ArrayList<>();
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

	public void setMessages() {
		this.messages = new ArrayList<>();
	}
	public boolean getMessage(User user, String contentMessage) {
		List<Message> messagesOfSender= new ArrayList<>();
		for(Message message: messages) {
			if(message.sender==user&&contentMessage.equals(message.messageContent)) {
				return true;
			}
		}
		return  false;
	}
}
