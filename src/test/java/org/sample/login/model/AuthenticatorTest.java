package org.sample.login.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

@RunWith(JMock.class)
public class AuthenticatorTest {
	private final Mockery context = new JUnit4Mockery();
	private final UsersStore usersStore = context.mock(UsersStore.class);
	private final Authenticator authenticator = new Authenticator(usersStore);
	
	@Test
	public void succeedWithExistingUser() {
		context.checking(new Expectations() {{
			allowing(usersStore).existsUserWithUsername("admin"); will(returnValue(true));
			allowing(usersStore).getUserWithUsername("admin"); will(returnValue(new User("admin", "admin")));
		}});
		assertTrue(authenticator.authenticate("admin", "admin"));
	}
	
	@Test
	public void failsWithExistingUserBadPassword() {
		context.checking(new Expectations() {{
			allowing(usersStore).existsUserWithUsername("admin"); will(returnValue(true));
			allowing(usersStore).getUserWithUsername("admin"); will(returnValue(new User("admin", "not-admin")));
		}});
		assertFalse(authenticator.authenticate("admin", "admin"));
	}
	
	@Test
	public void failsWithNonExistingUser() {
		context.checking(new Expectations() {{
			allowing(usersStore).existsUserWithUsername("admin"); will(returnValue(false));
			never(usersStore).getUserWithUsername(with(any(String.class)));
		}});
		assertFalse(authenticator.authenticate("admin", "admin"));
	}
}
