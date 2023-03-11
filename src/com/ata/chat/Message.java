package com.ata.chat;

import java.util.UUID;

public class Message {
	public String idMessage;
	public User sender;
	public String messageContent;
	public Object receiver;

	public Message(User sender, Object receiver, String messageContent) {
		this.sender = sender;
		this.messageContent = messageContent;
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Object getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

//	public String getIdMessage() {
//		return idMessage;
//	}

	public void setIdMessage() {
		this.idMessage = UUID.randomUUID().toString();;
	}

	public void setReceiver(Object receiver) {
		this.receiver = receiver;
	}

	public Message findIdMessage(String idOfMessage) {
		if (idOfMessage.equals(idMessage)) {
		return this;
		}else {
			return null;
		}
	}

}
