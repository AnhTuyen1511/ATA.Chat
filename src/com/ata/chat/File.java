package com.ata.chat;

public class File {
	private String name;
	private String type;
	private long size;
	private String path;

	public File(String name, String type, long size, String path) {
		super();
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
