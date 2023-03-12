package com.ata.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.ata.chat.Group;
import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;

public class GroupService {
	Database data = new Database();

	public void createPublicGroup(String name) {
		
		PublicGroup publicGroup = new PublicGroup(name,  false);
		data.groups.add(publicGroup);
	
	}

	public void joinGroup(User user,String joinCode) {
		 List <PublicGroup> listPublicGroups = getListPublicGroups();
		
		for (int index = 0; index < listPublicGroups.size(); index++) {
			if(listPublicGroups.get(index).getJoinCode().equals(joinCode)) {
				listPublicGroups.get(index).addUser(user);
			}
		}

	}
	
	public List<PublicGroup> getListPublicGroups(){
		List<Group> listGroups=data.groups.listEntities;
		List<PublicGroup> listPublicGroups = new ArrayList<>();
		for (int index = 0; index < listGroups.size(); index++) {
			if(!listGroups.get(index).isPrivate()) {
				listPublicGroups.add((PublicGroup)listGroups.get(index));
			}
		}
		return listPublicGroups;
	}


	
	

}
