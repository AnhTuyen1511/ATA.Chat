package com.ata.chat;

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
}
