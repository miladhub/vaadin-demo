package org.sample.login.login;

import org.sample.login.model.LoginService;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class LoginWindow extends Window implements Button.ClickListener {
	
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	private TextField user;
	private PasswordField passwd;
	
	public LoginWindow(String name, LoginService loginService) {
		super(name);
		this.loginService = loginService;
		this.user = new TextField("Username");
		this.passwd = new PasswordField("Password");

		FormLayout layout = new FormLayout();
		layout.setSizeUndefined();
		setContent(layout);
		
		layout.addComponent(user);
		layout.addComponent(passwd);
		layout.addComponent(new Button("Login", this));
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (loginService.authenticate((String) user.getValue(), (String) passwd.getValue())) {
			showNotification("OK");
		} else {
			showNotification("Failed");
		}
	}
	
}
