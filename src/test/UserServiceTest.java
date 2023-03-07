package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.service.UserService;

class UserServiceTest {
	private UserService userService;
	private Database database;

	@Before
	public void setUp() {
		database = new Database();
		userService = new UserService(database);
	}

	@Test
	public void testAddUserSuccess() {
		boolean result = userService.addUser("JohnDoe", "password123");
		assertTrue(result);
	}

	@Test
	public void testAddUserFailure() {
		User newUser = new User("JohnDoe", "password123");
		database.getUsers().add(newUser);

		boolean result = userService.addUser("JohnDoe", "password123");
		assertFalse(result);
	}

	@Test
	public void testFindUsersByUserName() {
		User user1 = new User("JohnDoe", "password123");
		User user2 = new User("JaneDoe", "password456");
		User user3 = new User("MarkSmith", "password789");
		database.getUsers().add(user1);
		database.getUsers().add(user2);
		database.getUsers().add(user3);

		List<User> expectedUsers = new ArrayList<>();
		expectedUsers.add(user1);
		expectedUsers.add(user2);
		UserService userService = new UserService(database);
		List<User> actualUsers = userService.findUsersByUserName("Doe");
		assertEquals(expectedUsers, actualUsers);
	}

	@Test
	public void testLoginSuccess() {
		User newUser = new User("JohnDoe", "password123");
		database.getUsers().add(newUser);

		boolean result = userService.login("JohnDoe", "password123");
		assertTrue(result);
	}

	@Test
	public void testLoginFailure() {
		User newUser = new User("JohnDoe", "password123");
		database.getUsers().add(newUser);

		boolean result = userService.login("JohnDoe", "wrongpassword");
		assertFalse(result);
	}

}
