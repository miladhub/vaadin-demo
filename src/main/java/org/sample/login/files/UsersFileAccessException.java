package org.sample.login.files;

public class UsersFileAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsersFileAccessException() {
		super();
	}

	public UsersFileAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsersFileAccessException(String message) {
		super(message);
	}

	public UsersFileAccessException(Throwable cause) {
		super(cause);
	}
}
