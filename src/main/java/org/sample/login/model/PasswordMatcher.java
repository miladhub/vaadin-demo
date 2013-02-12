package org.sample.login.model;

public interface PasswordMatcher {
	boolean passwordMatches(String userPassword, String password);
}
