package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ata.chat.Message;
import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.InMemoryDatabase;
import com.ata.service.GroupService;
import com.ata.service.MessageService;

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

	@AfterEach
	void clearDatabase() {
		data.groups.delete();
		data.users.delete();
	}

	@Test
	void testSendMessageToReceicer() {
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
		PublicGroup group = new PublicGroup("balabla", joinCode, false);
		messageService.sendMessagetoGroup(user, group, "bla bla bla");
		boolean actualResult = group.getMessage(user, "bla bla bla");
		assertEquals(true, actualResult);
	}

	@Test
	void testDeleteMessageToReceiver() {
		User user1 = new User("kate", "password123");
		User user3 = new User("john", "password789");
		messageService.sendMessagetoReceiver(user1, user3, "hello anh");
		Message message = new Message(user1, user3, "hello anh");
		messageService.deleteMessage(message);
		boolean actualResult = user3.getMessage(user3, "hello anh");
		assertEquals(false, actualResult);
	}

	@Test
	void testDeleteMessageToGroup() {
		User user = new User("JohnDoe", "password123");
		String joinCode = groupService.generateJoinCode();
		PublicGroup group = new PublicGroup("balabla", joinCode, false);
		Message message = new Message(user, group, "hello group");
		messageService.deleteMessage(message);
		boolean actualResult = group.getMessage(user, "hello group");
		assertEquals(false, actualResult);
	}

	@Test
	void testListGroupConversationOfUser() {
		User user = new User("JohnDoe", "password123");
		String joinCode = groupService.createPublicGroup("balabla");
		groupService.joinGroup(user, joinCode);
		String joinCode1 = groupService.createPublicGroup("balabla1");
		groupService.joinGroup(user, joinCode1);
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("balabla");
		expectedList.add("balabla1");
		List<String> actualList = messageService.getListGroupConversationOfUser(user);
		assertEquals(expectedList, actualList);
	}

	@Test
	void testFindKeyword() {
		User user1 = new User("beo", "password123");
		User user2 = new User("teo", "ak123456");
		messageService.sendMessagetoReceiver(user1, user2, "hello teo");
		messageService.sendMessagetoReceiver(user2, user1, "hello beo");
		int numberOfMessage = messageService.findMessageByKeywords(user1, user2, "hello");
		int expectedResult = 2;
		assertEquals(expectedResult, numberOfMessage);
	}

	@Test
	public void testGetTopLatestMessage() {
		User user1 = new User("anh", "kimanh123");
		User user2 = new User("anhkim", "anhkim123");
		messageService.sendMessagetoReceiver(user1, user2, "1");
		messageService.sendMessagetoReceiver(user1, user2, "2");
		messageService.sendMessagetoReceiver(user1, user2, "3");
		messageService.sendMessagetoReceiver(user1, user2, "4");
		messageService.sendMessagetoReceiver(user1, user2, "5");
		messageService.sendMessagetoReceiver(user1, user2, "6");
		messageService.sendMessagetoReceiver(user1, user2, "7");
		List<Message> messages = messageService.getTopLatestMessage(user1, user2, 3, 1);
		assertEquals(3, messages.size());
		assertEquals("6", messages.get(0).getMessageContent());
		assertEquals("5", messages.get(1).getMessageContent());
		assertEquals("4", messages.get(2).getMessageContent());
	}

	@Test
	public void testDeleteMessage() {
		User user1 = new User("anh", "kimanh123");
		User user2 = new User("anhkim", "anhkim123");
		messageService.sendMessagetoReceiver(user1, user2, "Hello Jane!");
		Message message = user2.getMessages().get(0);
		messageService.deleteMessage(message);
		assertEquals(0, user2.getMessages().size());
	}
}
