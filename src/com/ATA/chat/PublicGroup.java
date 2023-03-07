package com.ata.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.ata.data.Database;

public class PublicGroup extends Group {
	private String joinCode;

	public PublicGroup(String name, String joinCode, boolean isPrivate) {
		super(name);
		joinCode = joinCode;
		isPrivate = isPrivate;
	}

	public String getJoinCode() {
		return joinCode;
	}

	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}
	
	public List<PublicGroup> getListPublicGroups(){
		Database database = new Database();
		List<Group> listGroups=database.groups.listEntities;
		List<PublicGroup> listPublicGroups = new ArrayList<>();
		for (int index = 0; index < listGroups.size(); index++) {
			if(!listGroups.get(index).isPrivate()) {
				listPublicGroups.add((PublicGroup)listGroups.get(index));
			}
		}
		return listPublicGroups;
	}
	
}
