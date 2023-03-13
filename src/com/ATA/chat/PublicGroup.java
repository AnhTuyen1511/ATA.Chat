package com.ata.chat;

import java.util.Random;

public class PublicGroup extends Group {


	private String joinCode;

	public PublicGroup(String name, String joinCode, boolean isPrivate) {
		super(name);
		this.joinCode = joinCode;
		this.setPrivate(isPrivate);
	}

	public String getJoinCode() {
		return joinCode;
	}

	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}


	private String generateJoinCode() {
		String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(alphanumeric.length());
			sb.append(alphanumeric.charAt(index));
		}
		return sb.toString();
	}


}
