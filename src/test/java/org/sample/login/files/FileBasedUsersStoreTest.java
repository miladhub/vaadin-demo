package org.sample.login.files;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.sample.login.model.User;

public class FileBasedUsersStoreTest {
	private FileBasedUsersStore store = new FileBasedUsersStore();
	
	@Before
	public void readUser() {
		store.readUsersFile(new File("src/test/resources/users.txt"));
	}
	
	@Test
	public void adminExists() {
		assertTrue(store.existsUserWithUsername("admin")); 
	}
	
	@Test
	public void getAdminUser() {
		assertThat(store.getUserWithUsername("admin"), equalTo(new User("admin", "admin"))); 
	}
}
