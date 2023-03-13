package com.ata.chat;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		messages = new ArrayList<>();

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


	public boolean getMessage(User user, String contentMessage) {
		List<Message> messagesOfSender = new ArrayList<>();
		for (Message message : messages) {
			if (message.sender == user && contentMessage.equals(message.messageContent)) {
				return true;
			}
		}
		return false;
	}

	public List<Message> getMessageByKeywords(Predicate<Message> predicate) {
		List<Message> listMessases;
		listMessases = messages.stream().filter(predicate).collect(Collectors.toList());
		return listMessases;
	}

	public void removeMessage(User sender, Message message) {
		for (Message messageFromList : messages) {
			String contentOfMessage = message.getMessageContent();
			if (contentOfMessage.equals(messageFromList.messageContent)) {
				if (sender.getUserID() == message.getSender().getUserID()) {
					messages.remove(messageFromList);
				}
			}

		}
	}
}
