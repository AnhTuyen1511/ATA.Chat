package com.ata.service;

import java.nio.file.Files;
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
	private List<Message> messages;

	public MessageService(Database data) {
		this.data = data;
		groups = data.groups.getListEntities();
		messages = data.messages.getListEntities();
	}

	public void sendMessagetoGroup(User sender, Group group, String messageContent) {
		Message message = new Message(sender, group, messageContent);
		group.getMessages().add(message);
		
	}

	public void sendMessagetoReceiver(User sender, User receiver, String messageContent) {
		Message message = new Message(sender, receiver, messageContent);
		receiver.getMessages().add(message);
	}

//	public void sendFile(User sender, Object recipient, File file) {
//	    // save file to a folder with unique ID
//	    String fileId = UUID.randomUUID().toString();
//	    File newFile = new File("" + fileId);
//	    // copy file to new location
//	    Files.copy(file.toPath(), newFile.toPath());
//	    Message message = new FileMessage(UUID.randomUUID(), sender, recipient, new Date());
//	    saveMessage(message);
//	    // send message to recipient
//	}
	
	public List<Group> getGroupsOfUser(User user) {
        List<Group> userGroups = new ArrayList<Group>();
        for (Group group : groups) {
            if (group.getUsers().contains(user)) {
                userGroups.add(group);
            }
        }
        return userGroups;
    }
	
//	public List<Message> getListConversationOfUser(User user){
//		List<Group> listGroupConversation = getGroupsOfUser(user);
//		List<Message> listConversation;
//		for(Group group : listGroupConversation) {
//			
//		}
//		return null;
//	}
	
	public List<Message> getTopLatestMessage(User sender, User receiver, int numberOfLatestMessages, int exception) {
		List<Message> messagesOfSender = sender.getMessages();
		List<Message> messagesOfReceiver = receiver.getMessages();
		List<Message> topLatestMessage = new ArrayList<>();
		int startFrom = messagesOfSender.size() - 1 - exception;
		int endAt = startFrom - numberOfLatestMessages;

		for (int i = startFrom; i > numberOfLatestMessages; i--) {
			if (startFrom >= 0 && endAt >= 0) {
				topLatestMessage.add(messagesOfSender.get(i));
				topLatestMessage.add(messagesOfReceiver.get(i));
			} else {
				break;
			}
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

	public List<Message> findMessageByKeywords(User user, String keyword) {
		List<Message> result = user.getMessageByKeywords(message -> message.messageContent.contains(keyword));
		return result;
	}

	public List<File> getFilesInGroup(Group group) {
		List<File> files = group.getFiles();
		return files;
	}
}
