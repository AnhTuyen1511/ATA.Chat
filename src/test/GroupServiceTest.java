package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ata.chat.PublicGroup;
import com.ata.chat.User;
import com.ata.data.Database;
import com.ata.data.InMemoryDatabase;
import com.ata.service.GroupService;

class GroupServiceTest {
	Database data;
	private GroupService groupService;

	@BeforeEach
	void setUp() {
		data = InMemoryDatabase.getInstance();
		groupService = new GroupService(data);
	}

	@Test
	void testCreatePublicGroup() {
		String groupName = "Test Group";
		groupService.createPublicGroup(groupName);

		PublicGroup createdGroup = groupService.getListPublicGroups().get(0);

		assertEquals(groupName, createdGroup.getName());
		assertNotNull(createdGroup.getJoinCode());
		assertFalse(createdGroup.isPrivate());
	}

	@Test
	void testJoinGroup() {
		String groupName = "Test Group";
		String joinCode = groupService.createPublicGroup(groupName);

		User user = new User("testUser", "password");

		boolean result = groupService.joinGroup(user, joinCode);
		assertTrue(result);
	}

	@Test
	void testRemoveUserFromGroup() {
		String groupName = "Test Group";
		groupService.createPublicGroup(groupName);

		PublicGroup group = groupService.getListPublicGroups().get(0);
		User user = new User("testUser", "password");

		group.addUser(user);

		assertFalse(groupService.removeUserFromGroup(user, group.getName()));
	}

	@Test
	void testGetListPublicGroups() {
		assertEquals(0, groupService.getListPublicGroups().size());

		String groupName1 = "Test Group 1";
		String groupName2 = "Test Group 2";
		groupService.createPublicGroup(groupName1);
		groupService.createPublicGroup(groupName2);

		assertEquals(2, groupService.getListPublicGroups().size());
	}

}