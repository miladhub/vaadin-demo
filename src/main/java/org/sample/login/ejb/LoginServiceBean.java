package org.sample.login.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sample.login.model.Authenticator;
import org.sample.login.model.LoginService;
import org.sample.login.model.UsersStore;

@Stateless
public class LoginServiceBean implements LoginService {
	
	@Inject
	private UsersStore usersStore;
	
	@Override
	public boolean authenticate(String username, String pass) {
		return new Authenticator(usersStore).authenticate(username, pass);
	}
	
}
