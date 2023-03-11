package com.ata.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.ata.service.TextService;
public class User {
	private String userID;
	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private String gender;
	private String dateOfBirth;
	private String hashedPass;
	private List<Message> messages;

	public User(String userID, String lastName, String firstName, String userName, String password, String gender,
			String dateOfBirth) {
		this.userID = userID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		messages = new ArrayList<>();
	}

//	private String hash(String text) {
//		TextService textService = new TextService();
//		return textService.hashMD5(text);
//	}
//
//	public User(String userName, String password) {
//		userName = userName;
//		password = hash(password);
//	}
//
//	public boolean login(String password) {
//		String hashedInputPass = hash(password);
//		if (this.password.equals(hashedInputPass)) {
//			return true;
//		}
//		return false;
//	}

	public String getUserID() {
		return userID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public List<Message> getMessageByKeywords(Predicate<Message> predicate) {
		List<Message> listMessases;
		listMessases = messages.stream().filter(predicate).collect(Collectors.toList());
		return listMessases;
	}
}