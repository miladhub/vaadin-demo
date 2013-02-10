package org.sample.login.login;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.sample.login.model.LoginService;

import com.vaadin.Application;

@SessionScoped
public class LoginApp extends Application {
	private static final long serialVersionUID = 1L;

	@Inject
	private LoginService loginService;

	@Override
	public void init() {
		setMainWindow(new LoginWindow("My Vaadin Application - Login",
				loginService));
	}
}
