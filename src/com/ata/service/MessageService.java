package com.ata.service;

import java.util.ArrayList;
import java.util.List;
import com.ata.chat.File;
import com.ata.chat.Group;
import com.ata.chat.Message;
import com.ata.chat.User;
import com.ata.data.Database;

public class MessageService {
	private final Database data;
	private List<Group> groups;

	public MessageService(Database data) {
		this.data = data;
	}

	public void sendMessagetoGroup(User sender, Group group, String messageContent) {
		Message message = new Message(sender, group, messageContent);
		group.getMessages().add(message);

	}

	public void sendMessagetoReceiver(User sender, User receiver, String messageContent) {
		Message message = new Message(sender, receiver, messageContent);
		receiver.getMessages().add(message);
	}

	public List<Group> getGroupsOfUser(User user) {
		List<Group> userGroups = new ArrayList<Group>();
		for (Group group : groups) {
			if (group.getUsers().contains(user)) {
				userGroups.add(group);
			}
		}
		return userGroups;
	}
	
	public List<Message> getTopLatestMessage(User sender, User receiver, int numberOfLatestMessages, int exception) {
		List<Message> messagesOfReceiver = receiver.getMessages();
		List<Message> topLatestMessage = new ArrayList<>();
		int startFrom = messagesOfReceiver.size() - 1 - exception;
		int endAt = startFrom - numberOfLatestMessages;
		for (int i = startFrom; i > endAt; i--) {
			topLatestMessage.add(messagesOfReceiver.get(i));
		}
		return topLatestMessage;
	}

	public void deleteMessage(Message message) {
		Object receiver = message.getReceiver();
		if (receiver instanceof User) {
			User user = (User) receiver;
			user.getMessages().remove(message);
		} else {
			Group group = (Group) receiver;
			group.getMessages().remove(message);
		}
	}

	public int findMessageByKeywords(User sender, User receiver, String keyword) {
		List<Message> result1 = sender.getMessageByKeywords(keyword);
		List<Message> result2 = receiver.getMessageByKeywords(keyword);
		int numberOfMessage = result1.size() + result2.size();
		return numberOfMessage;
	}

	public List<File> getFilesInGroup(Group group) {
		List<File> files = group.getFiles();
		return files;
	}

	public List<String> getReceiverConversations(User user) {
		List<String> conversations = user.getConversions(user);
		return conversations;
	}

	public List<Group> getGroupsOfUser(User user) {
		List<Group> userGroups = new ArrayList<Group>();
		groups = data.groups.getListEntities();
		for (Group group : groups) {
			if (group.getUsers().contains(user)) {
				userGroups.add(group);
			}
		}
		return userGroups;
	}

	public List<String> getListGroupConversationOfUser(User user) {
		List<Group> listGroupConversation = getGroupsOfUser(user);
		List<String> listConversation = new ArrayList<>();
		for (Group group : listGroupConversation) {
			listConversation.add(group.getName());
		}
		return listConversation;
	}

	public void setUserAlias(User assignor, User assignee, String aliasName) {
		assignor.setAlias(assignee, aliasName);
	}

	public String getUserAlias(User assignor, User assignee) {
		return assignor.getAlias(assignee);
	}
}
