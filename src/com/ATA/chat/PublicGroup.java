package com.ata.chat;

public class PublicGroup extends Group {
	private String joinCode;

	public PublicGroup(String name, String joinCode) {
		super(name);
		joinCode = joinCode;
	}
}
