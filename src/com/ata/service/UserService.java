package com.ata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ata.chat.HashPassword;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.Repository;

public class UserService {
	public Database data;
	public HashPassword hashPassword=new HashPassword();


	public UserService(Database database) {
			data=database;
	}
	public void addUser(User user) {
		
//		String password=hash_password.hashPass(user.getPassword());
//		user.setPassword(password);
		data.users.add(user);
//		repositoryUser.add(user);
	}
	public boolean login(String userName,String password) {
		List<User> users=data.users.getEntity();
		for(int index=0;index<users.size();index++) {
			String userName2=users.get(index).getUserName();
			String password2=users.get(index).getPassword();
			if(userName2.equals(userName)&&password2.equals(password)){
				return true;
			}
		}
		return false;
	}
	public List<User> findUsersByName(List<User> users, String searchString) {
	    List<User> matchingUsers = new ArrayList<>();
	    for (User user : users) {
	        if (user.getFirstName().contains(searchString)) {
	            matchingUsers.add(user);
	        }
	    }
	    return matchingUsers;
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
