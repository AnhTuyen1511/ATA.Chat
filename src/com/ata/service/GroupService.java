package com.ata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ata.chat.Group;
import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;

public class GroupService {
	private final Database data;

	public GroupService(Database data) {
		this.data = data;
	}

	public String createPublicGroup(String name) {
		String joinCode = generateJoinCode();
		PublicGroup publicGroup = new PublicGroup(name, joinCode, false);
		data.groups.add(publicGroup);
		return joinCode;
	}

	public boolean joinGroup(User user, String joinCode) {
		List<PublicGroup> listPublicGroups = getListPublicGroups();
		boolean success = false;
		for (int index = 0; index < listPublicGroups.size(); index++) {
			if (listPublicGroups.get(index).getJoinCode().equals(joinCode)) {
				listPublicGroups.get(index).addUser(user);
				success = true;
			}
		}
		return success;
	}

	public List<PublicGroup> getListPublicGroups() {
		List<Group> listGroups = data.groups.getListEntities();
		List<PublicGroup> listPublicGroups = new ArrayList<>();
		
		for (int index = 0; index < listGroups.size(); index++) {
			if (!listGroups.get(index).isPrivate()) {
				listPublicGroups.add((PublicGroup) listGroups.get(index));
			}
		}
		return listPublicGroups;
	}

	public boolean removeUserFromGroup(User user, String groupName) {
		Group group;
		group = this.getGroupByName(groupName);
		if (group != null) {
			group.removeUser(user);
			return true;
		}
		return false;
	}

	public Group getGroupById(String GroupID) {
		List<Group> listGroups = data.groups.getListEntities();
		Group tempGroup;
		
		for (int index = 0; index < listGroups.size(); index++) {
			tempGroup = listGroups.get(index);
			if (tempGroup.getGroupID().equalsIgnoreCase(GroupID)) {
				return tempGroup;
			}
		}
		return null;
	}

	public Group getGroupByName(String groupName) {
		return (Group) data.groups.getFirst(group -> group.getName().equalsIgnoreCase(groupName));
	}

	public String generateJoinCode() {
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
