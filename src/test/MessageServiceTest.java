package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ata.chat.Group;
import com.ata.chat.Message;
import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.InMemoryDatabase;
import com.ata.service.GroupService;
import com.ata.service.MessageService;
import com.ata.service.UserService;

class MessageServiceTest {
	Database data;
	private MessageService messageService;
	private GroupService groupService;
	

	@BeforeEach
	void setUp() {
		data = InMemoryDatabase.getInstance();
		messageService = new MessageService(data);
		groupService = new GroupService(data);
	}

	@Test
	void testSendMessageToReceicer() {
		User user1 = new User("JohnDoe", "password123");
		User user2 = new User("JaneDoe", "password456");
		User user3 = new User("MarkSmith", "password789");
		messageService.sendMessagetoReceiver(user2, user3, "hello banhbeo");
		boolean actualResult = user3.getMessage(user2, "hello banhbeo");
		assertEquals(true, actualResult);
	}

	@Test
	void testSendMessageToGroup() {
		User user = new User("anh", "password123");
		String joinCode = groupService.generateJoinCode();
		PublicGroup group= new PublicGroup("balabla",joinCode, false);
//		group.setMessages();
		messageService.sendMessagetoGroup(user, group, "bla bla bla");
		boolean actualResult=group.getMessage(user,"bla bla bla");
		assertEquals(true, actualResult);
	}

	@Test
	void deleteMessageToReceiver() {
		User user1 = new User("kate", "password123");
		User user2 = new User("july", "password456");
		User user3 = new User("john", "password789");
		messageService.sendMessagetoReceiver(user1, user3, "hello anh");
		Message message = new Message(user1, user3, "hello anh");
		messageService.deleteMessage(message);
		boolean actualResult = user3.getMessage(user3, "hello anh");
		assertEquals(false, actualResult);
	}

	@Test
	void deleteMessageToGroup() {
		User user = new User("JohnDoe", "password123");
		PublicGroup group = new PublicGroup("balabla", false);
		group.setMessages();
		Message message = new Message(user, group, "hello group");
		messageService.deleteMessage(message);
		boolean actualResult = group.getMessage(user, "hello group");
		assertEquals(false, actualResult);
	}
}
