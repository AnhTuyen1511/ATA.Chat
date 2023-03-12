package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.ata.chat.Group;
import com.ata.chat.Message;
import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.service.MessageService;
import com.ata.service.UserService;

class MessageServiceTest {
	private MessageService messageService=new MessageService();;
//	@Before
//	public void setUp() {
//		messageService = new MessageService();
//	}

	@Test
	void testSendMessageToReceicer() {
		User user1 = new User("JohnDoe", "password123");
		User user2 = new User("JaneDoe", "password456");
		User user3 = new User("MarkSmith", "password789");
		messageService.sendMessagetoReceiver(user2, user3, "hello banhbeo");
		boolean actualResult=user3.getMessage(user2,"hello banhbeo" );
		assertEquals(true, actualResult);
	}
	@Test
	void testSendMessageToGroup() {
		User user = new User("anh", "password123");
		PublicGroup group= new PublicGroup("balabla", false);
		group.setMessages();
		messageService.sendMessagetoGroup(user, group, "bla bla bla");
		boolean actualResult=group.getMessage(user,"bla bla bla");
		assertEquals(true, actualResult);
	}
	@Test
	void getMessageByKeyword() {
		User user = new User("anh", "password123");
		PublicGroup group= new PublicGroup("balabla", false);
		group.setMessages();
		messageService.sendMessagetoGroup(user, group, "bla bla bla");
		boolean actualResult=group.getMessage(user,"bla bla bla");
		assertEquals(true, actualResult);
	}
}
