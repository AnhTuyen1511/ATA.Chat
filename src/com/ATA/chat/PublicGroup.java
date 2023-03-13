package com.ata.chat;

<<<<<<< HEAD
<<<<<<< HEAD
public class PublicGroup extends Group {
	private String joinCode;

	public PublicGroup(String name, String joinCode, boolean isPrivate) {
		super(name);
		this.joinCode = joinCode;
		this.setPrivate(isPrivate);
=======
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import com.ata.data.Database;

=======
>>>>>>> main
public class PublicGroup extends Group {
	private String joinCode;

	public PublicGroup(String name, String joinCode, boolean isPrivate) {
		super(name);
		this.joinCode = joinCode;
		this.setPrivate(isPrivate);
<<<<<<< HEAD

>>>>>>> 12859f6c6cbe6fa95cee910919b3d751fba2a899
=======
>>>>>>> main
	}

	public String getJoinCode() {
		return joinCode;
	}

	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======

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

>>>>>>> 12859f6c6cbe6fa95cee910919b3d751fba2a899
=======
>>>>>>> main
}
