package org.sample.login.ejb;

import javax.ejb.Stateless;

import org.sample.login.model.LoginService;

@Stateless
public class LoginServiceBean implements LoginService {
	@Override
	public boolean authenticate(String username, String pass) {
		if (username.equals("admin") && pass.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
}
