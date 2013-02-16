package org.sample.login.web;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

@WebServlet(urlPatterns = "/*")
public class LoginServlet extends AbstractApplicationServlet {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Instance<LoginApp> instance;
	
	@Override
	protected Application getNewApplication(HttpServletRequest request)
			throws ServletException {
		return instance.get();
	}

	@Override
	protected Class<? extends Application> getApplicationClass()
			throws ClassNotFoundException {
		return LoginApp.class;
	}
	
}
