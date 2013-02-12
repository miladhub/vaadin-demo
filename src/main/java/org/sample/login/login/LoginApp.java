package org.sample.login.login;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.sample.login.model.LoginService;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;

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
	
	/**
	 * {@link https://vaadin.com/forum/-/message_boards/view_message/131360}
	 * {@link http://dev.vaadin.com/ticket/4379}
	 */
	@PreDestroy
    public void unbound() {
        ((WebApplicationContext) getContext()).valueUnbound(null);
    }
	
}
